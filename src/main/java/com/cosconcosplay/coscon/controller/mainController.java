package com.cosconcosplay.coscon.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cosconcosplay.coscon.model.Post;
import com.cosconcosplay.coscon.model.User;
import com.cosconcosplay.coscon.service.postService;
import com.cosconcosplay.coscon.service.userService;
import com.cosconcosplay.coscon.utils.Authenticated;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class mainController {
    @Autowired private userService service; 
    @Autowired private postService postserv;
@PostMapping(value = "cadastro", consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<String> cadastro(@Validated @RequestBody userDTO user) {

    service.add(User.builder().email(user.email).password(user.password).username(user.username).build());
return ResponseEntity.ok("Usuario cadastrado");
}
@Authenticated
@PostMapping("postar")
public ResponseEntity<String> postMethodName(@Validated @ModelAttribute postDTO post) {
    postserv.add(Post.builder().body(post.body).title(post.title).imagem(post.imagem).build());
    
    return ResponseEntity.status(HttpStatus.CREATED).body("Postado!");
}

public record userDTO(
    @NotBlank String username,
 @Size(min = 9, message = "A senha deve conter no minimo 9 letras") String password,
 @Email(message = "Email inválido") String email){}
 public record postDTO (@NotBlank String title,
 @NotBlank String body,
  @Nullable byte[] imagem){};
}
