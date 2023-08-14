package mate.academy.quiz.repository;

import mate.academy.quiz.model.Question;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    @Query("SELECT q From Question q where q.quiz.id = :id")
    List<Question> getAllQuizQuestions(@Param("id") Long id);

    @Modifying
    @Query(nativeQuery = true, value = "delete from `spring-quiz`.question where quiz_id=:id")
    void deleteQuestionsByQuizId(@Param("id") long id);
}