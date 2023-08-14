package mate.academy.quiz.service;

import mate.academy.quiz.model.Answer;

import java.util.List;

public interface AnswerService {
    boolean create(Answer answer);
    List<Answer> getAllAnswersByQuestionId(Long id);
    void delete(Long id);
}
