package com.cosconcosplay.coscon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosconcosplay.coscon.model.Comment;
import com.cosconcosplay.coscon.repository.commentRepository;
import com.cosconcosplay.coscon.repository.postRepository;
import com.cosconcosplay.coscon.repository.userRepository;

import jakarta.validation.Valid;

@Service
public class commentService {
@Autowired private commentRepository repository;
@Autowired private userRepository service;
@Autowired private postRepository repo;
public void comentar( @Valid Comment comentario){
    
repository.saveAndFlush(comentario);
}
public static record commentDTO (String comentario, Integer postID, Integer userID ){
  

}

public Comment toEntity(@Valid commentDTO dto){
 return Comment.builder().comentario(dto.comentario).usuario(service.getReferenceById(dto.userID)).postagem(repo.getReferenceById(dto.postID)).build();
}

}
