package mate.academy.quiz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.management.relation.Role;
import java.util.Optional;

public interface RoleRepository {
    @Query("SELECT r FROM Role  r where r.name = :name")
    Optional<Role> findByName(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false " +
            "END FROM Role r WHERE r.name = :name")
    boolean isRoleExistsByName(@Param("name") String name);
    @Query("SELECT r.name FROM Role  r where r.id = :id")
    String getRoleNameById(int id);
}