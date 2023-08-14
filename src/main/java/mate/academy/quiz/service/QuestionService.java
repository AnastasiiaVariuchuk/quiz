package mate.academy.quiz.service;

import mate.academy.quiz.model.Answer;
import mate.academy.quiz.model.Question;

import java.util.List;

public interface QuestionService {
    boolean create(Question question);
    List<Question> getAllQuizQuestions(Long id);
    void saveQuestionForQuiz(List<Question> questions);
    void deleteQuizQuestionsByQuizId(Long id);
    boolean isCorrect(List<Integer>answersList, Long quizId, int questionId);
    void addAnswerToQuestion(Answer answer);
    void removeAnswerToQuestion(Long id);
}