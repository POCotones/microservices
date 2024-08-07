package com.ritallus.ms_users.services;

import com.ritallus.ms_users.entities.User;
import com.ritallus.ms_users.exceptions.BusinessException;
import com.ritallus.ms_users.exceptions.DataNotFoundException;
import com.ritallus.ms_users.repositories.UserRepository;
import com.ritallus.ms_users.utils.MessageResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        user.setCreateDate(LocalDateTime.now());
        user.setLastUpdate(LocalDateTime.now());
        return repository.save(user);
    }

    public void validateUserExists(String email) {
        var user = repository.findByEmail(email);
        if (user.isPresent()) {
            throw new BusinessException(MessageResponse.USER_EXISTS_EXCEPTION);
        }
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() ->
                new DataNotFoundException(MessageResponse.USER_NOT_FOUND_EXCEPTION));
    }
}