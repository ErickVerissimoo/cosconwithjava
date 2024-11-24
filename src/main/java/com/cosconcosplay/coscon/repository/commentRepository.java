package com.cosconcosplay.coscon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosconcosplay.coscon.model.Comment;

@Repository
public interface commentRepository extends JpaRepository<Comment, Integer> {
    
}
