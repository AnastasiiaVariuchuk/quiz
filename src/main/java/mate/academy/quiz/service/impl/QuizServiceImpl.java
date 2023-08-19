package mate.academy.quiz.service.impl;

import lombok.AllArgsConstructor;
import mate.academy.quiz.dto.QuizDTO;
import mate.academy.quiz.model.Quiz;
import mate.academy.quiz.repository.QuizRepository;
import mate.academy.quiz.repository.TopicRepository;
import mate.academy.quiz.service.QuizService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;

    @Override
    public Optional<Quiz> getQuizById(String id) {
        return quizRepository.findById(Long.parseLong(id));
    }

    @Override
    public boolean createQuiz(Quiz quiz) {
        quiz.setCreateDate(new Date(Calendar.getInstance().getTime().getTime()));
        quizRepository.save(quiz);
        return true;
    }

    @Transactional
    @Override
    public void editQuizInfo(QuizDTO quiz) {
        quizRepository.editQuizInfo(quiz.getId(), quiz.getHeader(), quiz.getDescription(), quiz.getDifficult(),
                quiz.getDuration(), quiz.getTopic());
    }

    @Transactional
    @Override
    public List<Quiz> getQuizzesByPage(Pageable pageable, Long topicSort) {
        return quizRepository.getAllQuizzesByPage(pageable,
                (long) topicSort).getContent();
    }

    @Transactional
    @Override
    public boolean deleteQuiz(Long id) {
        if (quizRepository.isQuizExistById(id)) {
            if (quizRepository.isAnyPassedQuiz(id)) {
                quizRepository.archiveQuiz(id);
            } else {
                quizRepository.deleteQuizById(id);
            }
            return true;
        }
        return false;
    }

    @Override
    public Long getQuizzesCount() {
        return quizRepository.getQuizzesCount();
    }
}
