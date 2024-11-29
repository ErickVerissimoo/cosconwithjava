package com.cosconcosplay.coscon.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
@Entity
@Builder
@Data
@Table(name = "usuarios")
public class Cliente {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Integer id;

@Email(message = "Email inválido")
@Column(unique = true)
private String email;
private String username;
@NotNull
private String password;
@OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true)
private List<Post> postagens;
private String sessionId;
}
