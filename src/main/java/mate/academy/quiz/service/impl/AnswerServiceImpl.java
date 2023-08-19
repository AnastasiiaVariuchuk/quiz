package mate.academy.quiz.service.impl;

import lombok.AllArgsConstructor;
import mate.academy.quiz.model.Answer;
import mate.academy.quiz.repository.AnswerRepository;
import mate.academy.quiz.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    @Override
    public boolean create(Answer answer) {
        answerRepository.save(answer);
        return true;
    }

    @Override
    public List<Answer> getAllAnswersByQuestionId(Long id) {
        return answerRepository.findAllByQuestionId(id);
    }

    @Override
    public void delete(Long id) {
        answerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Not found answer with id: " + id));
        answerRepository.deleteById(id);
    }
}