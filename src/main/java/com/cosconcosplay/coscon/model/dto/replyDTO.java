package com.cosconcosplay.coscon.model.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cosconcosplay.coscon.model.Reply;
import com.cosconcosplay.coscon.repository.replyRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class replyDTO {
    CommentDTO coment;
    List<replyDTO> respostas;
    Integer primarydto;
    Integer replyId;
    Integer 
    @JsonIgnore
    @Autowired private replyRepository repository;
public Reply toEntity(){
    
return Reply.builder().comentario(coment.toEntity()).primaryReply(repository.getReferenceById(replyId)).id(replyId).build();
}

}