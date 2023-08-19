package mate.academy.quiz.repository;

import mate.academy.quiz.model.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic,Long> {
    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false " +
            "END FROM Topic t WHERE t.name = :name")
    boolean isTopicExistByName(@Param("name") String name);
    @Query("SELECT t FROM Topic t WHERE t.archived = 0")
    List<Topic> findAllTopics();
}
