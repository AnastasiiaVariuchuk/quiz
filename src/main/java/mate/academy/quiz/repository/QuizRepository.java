package mate.academy.quiz.repository;

import mate.academy.quiz.model.Quiz;
import mate.academy.quiz.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
    @Query("SELECT count(q) FROM Quiz q WHERE q.archived=0")
    Long getQuizzesCount();

    @Query(value = "SELECT q FROM Quiz q WHERE (q.topic.id=:topicId " +
            "OR 0=:topicId) AND q.topic.archived=0 AND q.archived=0 ")
    Page<Quiz> getAllQuizzesByPage(Pageable pageable, @Param("topicId") Long topicId);

    @Modifying
    @Query("UPDATE Quiz q SET q.description= :description ,q.header= :header," +
            " q.difficult = :difficult,q" +
            ".duration= :duration, q.topic= :topic WHERE q.id= :id AND q.id>0")
    void editQuizInfo(@Param("id") Long id, @Param("header") String header,
                      @Param("description") String description, @Param("difficult") String difficult, @Param(
            "duration") int duration, @Param("topic") Topic topic);

    @Modifying
    @Query("UPDATE Quiz q SET q.archived=1 WHERE q.id=:id")
    void archiveQuiz(@Param("id") Long id);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false " +
            "END FROM Result r WHERE r.quiz.id = :id")
    boolean isAnyPassedQuiz(@Param("id") Long id);

    @Query("SELECT CASE WHEN COUNT(q) > 0 THEN true ELSE false " +
            "END FROM Quiz q WHERE q.id = :id")
    boolean isQuizExistById(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM Quiz q WHERE q.id =:id")
    void deleteQuizById(@Param("id") Long id);
}