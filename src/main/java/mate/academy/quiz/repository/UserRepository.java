package mate.academy.quiz.repository;

import mate.academy.quiz.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u.block FROM User u WHERE u.id=:id")
    int getUserBlockById(@Param("id") Long id);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false " +
            "END FROM User u WHERE u.email = :email")
    boolean isUserExistByEmail(@Param("email") String email);

    Optional<User> findByEmail(String email);
    Optional<User> findUserById(Long id);

    @Query("SELECT u FROM User u WHERE u.email!=:email")
    List<User> findAllUsers(Pageable pageable, @Param("email") String email);

    @Modifying
    @Query("UPDATE User u SET u.name=:name, u.surname=:surname,u.role=:role WHERE u.id=:id")
    void updateUserInfo(@Param("id") Long id, @Param("name") String name, @Param("surname") String surname, @Param(
            "role") Role role);

    @Modifying
    @Query("UPDATE User u SET u.name=:name, u.surname=:surname WHERE u" +
            ".email=:oldEmail")
    void updateUserPersonalInfo(@Param("name") String name, @Param("surname") String surname,
                                @Param("oldEmail") String oldEmail);

    @Modifying
    @Query("UPDATE User u SET u.block=:block WHERE u.id=:id")
    void blockUser(@Param("id") Long id, @Param("block") int block);

    @Modifying
    @Query("UPDATE User u SET u.email=:email WHERE u.email=:oldEmail")
    void updateUserEmail(@Param("email") String email, @Param("oldEmail") String oldEmail);

    @Modifying
    @Query("UPDATE User u SET u.password=:password WHERE u.email=:email")
    void updateUserPassword(@Param("password") String password, @Param("email") String email);
}