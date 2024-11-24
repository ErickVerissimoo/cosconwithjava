package com.cosconcosplay.coscon.model;

import java.util.List;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
@Entity
@Builder
@Data
public class User {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Integer id;
@NaturalId
@Email(message = "Email inválido")
private String email;
private String username;
@NotNull
private String password;
@OneToMany(mappedBy = "usuario")
private List<Post> postagens;
}
