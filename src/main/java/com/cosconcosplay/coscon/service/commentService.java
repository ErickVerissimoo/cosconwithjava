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
public void comentar( @Valid Comment comentario){
    
repository.saveAndFlush(comentario);
}
public void apagarComentario(@Valid Comment coment){
repository.deleteById(coment.getId());
}

}




