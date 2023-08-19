package mate.academy.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mate.academy.quiz.model.Question;
import mate.academy.quiz.model.Topic;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
    private Long id;
    private String header;
    private String description;
    private int duration;
    private Date createDate;
    private String difficult;
    private List<Question> questions;
    private Topic topic;
}
