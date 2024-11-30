package com.cosconcosplay.coscon.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
@Table(name = "comentario")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Cliente usuario;
    @ManyToOne 
    @JoinColumn(name = "postagem_id")
    private Post postagem;
    @OneToMany(mappedBy = "comentario", cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Reply> respostas;
}
