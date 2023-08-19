package mate.academy.quiz.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mate.academy.quiz.model.Answer;
import mate.academy.quiz.model.Question;
import mate.academy.quiz.repository.AnswerRepository;
import mate.academy.quiz.repository.QuestionRepository;
import mate.academy.quiz.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Override
    public boolean create(Question question) {
        questionRepository.save(question);
        return true;
    }

    @Override
    public List<Question> getAllQuizQuestions(Long id) {
        return questionRepository.findAllByQuizId(id);
    }

    @Transactional
    @Override
    public void deleteQuizQuestionsByQuizId(Long id) {
        questionRepository.deleteQuestionsByQuizId(id);
    }

    @Transactional
    @Override
    public void saveQuestionForQuiz(List<Question> questions) {
        questionRepository.saveAll(questions);

    }

    @Override
    public boolean isCorrect(List<Integer> answersList, Long quizId, int questionId) {
        List<Answer> correctAnswers = questionRepository.findAllByQuizId(quizId).get(questionId).getAnswers();
        return IntStream.range(0, correctAnswers.size())
                .allMatch(i -> {
                    int answer = correctAnswers.get(i).getAnswer();
                    int index = i;
                    return (answer == 1 && answersList.contains(index)) || (answer == 0 && !answersList.contains(index));
                });
    }

    @Override
    public void addAnswerToQuestion(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void removeAnswerToQuestion(Long id) {
        answerRepository.deleteById(id);
    }
}