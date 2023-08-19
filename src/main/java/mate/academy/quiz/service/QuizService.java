package mate.academy.quiz.service;

import mate.academy.quiz.dto.QuizDTO;
import mate.academy.quiz.model.Quiz;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    boolean createQuiz(Quiz quiz);
    Optional<Quiz> getQuizById(String id);
    boolean deleteQuiz(Long id);
    void editQuizInfo(QuizDTO quiz);
    List<Quiz> getQuizzesByPage(Pageable pageable, Long topicSort);
    Long getQuizzesCount();
}