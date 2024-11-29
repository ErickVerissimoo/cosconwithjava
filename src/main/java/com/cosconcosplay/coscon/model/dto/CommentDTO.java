package com.cosconcosplay.coscon.model.dto;

import java.util.List;

import com.cosconcosplay.coscon.model.Comment;

public class CommentDTO {
     String coment;
     clienteDTO dto; 
     postDTO postdto; 
     List<replyDTO> respostas;
    public Comment toEntity(){
        return Comment.builder().comentario(this.coment).postagem(postdto.toEntity()).usuario(dto.toEntity()).respostas(this.respostas.stream().map(x -> x.toEntity()).toList()).build();
    }
}
