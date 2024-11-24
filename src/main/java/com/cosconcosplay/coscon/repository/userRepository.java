package com.cosconcosplay.coscon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosconcosplay.coscon.model.User;

@Repository
public interface userRepository  extends JpaRepository<User, Integer>{
User findByEmail(String email);
boolean existsByEmail(String email);
}
