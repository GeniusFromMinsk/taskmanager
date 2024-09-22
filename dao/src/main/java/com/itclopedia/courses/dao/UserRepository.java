package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmailOrUsername(String email, String username);
}
