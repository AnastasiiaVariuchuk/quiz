package mate.academy.quiz.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@Table(name = "quiz")
public class Quiz implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "header")
    private String header;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_id")
    @ToString.Exclude
    private List<Question> questions = new ArrayList<>();
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "duration")
    private int duration;
    @Column(name = "difficult")
    @Enumerated(EnumType.STRING)
    private DIFFICULT difficult;
    @Column(name = "archived")
    private Integer archived;

    //TODO implement such methods in QuizService or QuestionService
//    public void addQuestion(Question question) {
//        questions.add(question);
//        question.setQuiz(this);
//    }
//
//    public void removeQuestion(Question question) {
//        questions.remove(question);
//        question.setQuiz(null);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(id, quiz.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public enum DIFFICULT {
        EASY, MEDIUM, HARD
    }
}