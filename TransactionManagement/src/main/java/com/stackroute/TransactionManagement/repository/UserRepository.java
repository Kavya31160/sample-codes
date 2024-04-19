package com.stackroute.TransactionManagement.repository;

/**
 * @author Saravanan.1.P
 * @Date 22-11-2023
 */
import com.stackroute.TransactionManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long>{
    @Transactional
    void deleteByFirstName(String firstName);
}
