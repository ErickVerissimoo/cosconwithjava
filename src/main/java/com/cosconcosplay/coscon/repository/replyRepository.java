package com.cosconcosplay.coscon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosconcosplay.coscon.model.Reply;

@Repository
public interface replyRepository extends JpaRepository<Reply, Integer> {

}
