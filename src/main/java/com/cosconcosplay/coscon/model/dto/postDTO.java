package com.cosconcosplay.coscon.model.dto;

import java.util.List;

import com.cosconcosplay.coscon.model.Post;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class postDTO{
    private String titulo;
    private String body;
    private clienteDTO cliente;
    private byte[][] imagens;
    private List<CommentDTO> comentarios;
    public Post toEntity(){
return Post.builder().body(this.body).title(this.titulo).imagens(this.imagens).usuario(cliente.toEntity()).comentarios(this.comentarios.stream().map(CommentDTO::toEntity).toList()).build();
}
}
