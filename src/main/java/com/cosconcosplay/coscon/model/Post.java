package com.cosconcosplay.coscon.model;

import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
@Entity
@Data
@Builder
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
@NotEmpty
private String title;
@Nullable
private String body;
@Nullable
@Column(columnDefinition = "bytea[]")
private byte[][] imagens;
@ManyToOne
@JoinColumn(name = "usuario_id")
private Cliente usuario;
@OneToMany(mappedBy = "postagem", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true )
private List<Comment> comentarios;
}