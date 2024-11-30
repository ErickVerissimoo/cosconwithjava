package com.cosconcosplay.coscon.model.dto;

import java.util.List;

import com.cosconcosplay.coscon.model.Comment;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CommentDTO {
    private String coment;
    private clienteDTO dto; 
    private postDTO postdto; 
    private List<replyDTO> respostas;
    public Comment toEntity(){
        return Comment.builder().comentario(this.coment).postagem(postdto.toEntity()).usuario(dto.toEntity()).respostas(this.respostas.stream().map(x -> x.toEntity()).toList()).build();
    }
}
