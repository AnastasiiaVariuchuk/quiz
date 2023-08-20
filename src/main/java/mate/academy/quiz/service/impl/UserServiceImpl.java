package mate.academy.quiz.service.impl;

import lombok.AllArgsConstructor;
import mate.academy.quiz.dto.UserDTO;
import mate.academy.quiz.model.User;
import mate.academy.quiz.repository.UserRepository;
import mate.academy.quiz.service.UserService;
import mate.academy.quiz.service.mapper.UserMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;
import java.util.*;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void updateUserPersonalInfo(UserDTO user) {
        userRepository.updateUserPersonalInfo(user.getName(), user.getSurname(), user.getEmail());
    }

    @Transactional
    @Override
    public void updateUserEmail(UserDTO user, String email) {
        userRepository.updateUserEmail(user.getEmail(), email);
    }

    @Transactional
    @Override
    public void updateUserPassword(UserDTO user) {
        userRepository.updateUserPassword(user.getPassword(), user.getEmail());
    }

    @Transactional
    @Override
    public void updateUserInfo(UserDTO user) {
        userRepository.updateUserInfo(user.getId(), user.getName(), user.getSurname(), user.getRole());
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        return userRepository.isUserExistByEmail(email);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Transactional
    @Override
    public void blockUser(Long id) {
        userRepository.blockUser(id, userRepository.getUserBlockById(id) ^ 1);
    }

    @Override
    public boolean create(UserDTO user) {
        if (!userRepository.isUserExistByEmail(user.getEmail())) {
            user.setCreateDate(new Date(Calendar.getInstance().getTime().getTime()));
            userRepository.save(UserMapper.INSTANCE.mapFromDto(user));
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll(Pageable pageable, String email) {
        return userRepository.findAllUsers(pageable, email);
    }

    @Override
    public Long getUsersCount() {
        return userRepository.count();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}