package com.stackroute.TransactionManagement.service;

/**
 * @author Saravanan.1.P
 * @Date 22-11-2023
 */
import com.stackroute.TransactionManagement.model.User;
import com.stackroute.TransactionManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteUserByFirstName(String firstName) {
        userRepository.deleteByFirstName(firstName);
    }
}
