package com.cosconcosplay.coscon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosconcosplay.coscon.model.Comment;
import com.cosconcosplay.coscon.repository.commentRepository;

@Service
public class commentService {
@Autowired private commentRepository repository;

public void comentar(Comment comentario){
    
repository.saveAndFlush(comentario);
}

}
