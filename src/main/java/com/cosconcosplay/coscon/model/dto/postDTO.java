package com.cosconcosplay.coscon.model.dto;

import java.util.List;

import com.cosconcosplay.coscon.model.Post;

public class postDTO{
    String titulo; String body; clienteDTO cliente; byte[][] imagens;
    List<CommentDTO> comentarios;
    public Post toEntity(){
return Post.builder().body(this.body).title(this.titulo).imagens(this.imagens).usuario(cliente.toEntity()).comentarios(this.comentarios.stream().map(CommentDTO::toEntity).toList()).build();
}
}
