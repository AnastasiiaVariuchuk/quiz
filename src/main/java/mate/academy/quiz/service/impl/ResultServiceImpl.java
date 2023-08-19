package mate.academy.quiz.service.impl;

import lombok.AllArgsConstructor;
import mate.academy.quiz.model.Result;
import mate.academy.quiz.repository.ResultRepository;
import mate.academy.quiz.service.ResultService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ResultServiceImpl implements ResultService {
    private final ResultRepository resultRepository;

    @Override
    public Double getUserAverageScoreById(Long id) {
        return resultRepository.getUserAvgScoreById(id);
    }
    @Override
    public List<Result> getUserResultsPageByEmail(String email, Pageable pageable){
        return resultRepository.getUserResultsPageByEmail(email, pageable);
    }
    @Override
    public List<Result> getUserResultsById(Long id) {
        return resultRepository.findAllById(id);
    }

    @Override
    public Optional<Result> getQuizResultById(Long id) {
        return resultRepository.findById(id);
    }

    @Override
    public boolean createResult(Result result) {
        resultRepository.save(result);
        return true;
    }

    @Override
    public Long getUserResultsCountByEmail(String email ) {
        return resultRepository.countById(email);
    }
}