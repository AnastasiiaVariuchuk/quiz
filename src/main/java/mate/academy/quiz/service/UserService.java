package mate.academy.quiz.service;

import mate.academy.quiz.dto.UserDTO;
import mate.academy.quiz.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean create(UserDTO user);

    void blockUser(Long id);

    Optional<User> findUserById(Long id);

    Optional<User> findUserByEmail(String email);

    boolean isUserExistByEmail(String email);

    void updateUserInfo(UserDTO user);

    void updateUserPassword(UserDTO user);

    void updateUserEmail(UserDTO user, String email);

    void updateUserPersonalInfo(UserDTO user);

    Long getUsersCount();

    List<User> findAll(Pageable pageable, String email);

    void deleteUser(Long id);

}