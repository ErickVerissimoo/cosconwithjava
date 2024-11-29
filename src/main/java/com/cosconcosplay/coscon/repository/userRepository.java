package com.cosconcosplay.coscon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cosconcosplay.coscon.model.Cliente;

@Repository
public interface userRepository  extends JpaRepository<Cliente, Integer>{
Cliente findByEmail(String email);
boolean existsByEmail(String email);
@Query("select p.id from Cliente p where p.username = :username")
Integer findIdByUsername(@Param("username") String username);
}
