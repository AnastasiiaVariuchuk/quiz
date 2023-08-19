package mate.academy.quiz.service;

import mate.academy.quiz.model.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicService {
    boolean create(Topic topic);
    List<Topic> findAll();
    Optional<Topic> findById(String id);
}