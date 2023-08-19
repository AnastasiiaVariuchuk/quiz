package mate.academy.quiz.repository;

import mate.academy.quiz.model.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result,Long> {
    @Query("SELECT AVG(r.score) FROM Result  r WHERE r.user.id = :id")
    Double getUserAvgScoreById(@Param("id") Long id);
    @Query("SELECT r FROM Result r WHERE r.user.id = :id")
    List<Result> findAllById( @Param("id")  Long id);
    @Query("SELECT COUNT(r) FROM Result r JOIN User u on(r.user=u) WHERE u.email =:email")
    Long countById(@Param ("email")String email);
    @Query("SELECT r FROM Result r JOIN Quiz q ON(r.quiz=q) JOIN User u ON(r.user=u) WHERE u.email =:email")
    List<Result> getUserResultsPageByEmail(@Param("email" )String email, Pageable pageable);
}