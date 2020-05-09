package com.demo.jwt.repository;

import com.demo.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByUsername(String username);

    User findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);
}
