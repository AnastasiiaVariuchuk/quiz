package mate.academy.quiz.repository;

import mate.academy.quiz.model.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer,Long> {
    @Query("SELECT a From Answer a where a.question.id = :id")
    List<Answer> findAllById(@Param("id") Long id);
}