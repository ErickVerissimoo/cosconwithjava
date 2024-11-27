package com.cosconcosplay.coscon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosconcosplay.coscon.model.Cliente;

@Repository
public interface userRepository  extends JpaRepository<Cliente, Integer>{
Cliente findByEmail(String email);
boolean existsByEmail(String email);
}
