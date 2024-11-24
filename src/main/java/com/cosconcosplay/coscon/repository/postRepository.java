package com.cosconcosplay.coscon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosconcosplay.coscon.model.Post;
@Repository
public interface postRepository extends JpaRepository<Post, Integer> {

}
