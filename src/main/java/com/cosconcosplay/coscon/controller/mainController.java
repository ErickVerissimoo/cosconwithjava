package com.cosconcosplay.coscon.controller;

import org.springframework.web.bind.annotation.RestController;
import com.cosconcosplay.coscon.model.Post;
import com.cosconcosplay.coscon.model.dto.CommentDTO;
import com.cosconcosplay.coscon.model.dto.postDTO;
import com.cosconcosplay.coscon.repository.userRepository;
import com.cosconcosplay.coscon.service.commentService;
import com.cosconcosplay.coscon.service.userService.usuarioDTO;
import com.cosconcosplay.coscon.service.postService;
import com.cosconcosplay.coscon.service.userService;
import com.cosconcosplay.coscon.utils.Authenticated;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class mainController {
    @Autowired private userService service; 
    @Autowired private postService postserv;
    @Autowired private commentService coment;
    @Autowired private userRepository repo;
@PostMapping(value = "cadastro", consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<String> cadastro(@Validated @RequestBody usuarioDTO user) {

    service.add(user.toEntity());
return ResponseEntity.ok("Usuario cadastrado");
}
@PostMapping(value = "login")
public ResponseEntity<String> login(@RequestBody usuarioDTO entity, HttpServletRequest req, HttpServletResponse response) {
    HttpSession sessioe = req.getSession(true);
    service.login(entity.toEntity());
    Cookie cook = new Cookie("session_id", sessioe.getId());
    cook.setHttpOnly(true);
    Cookie userID = new Cookie("userid",service.findID(entity.username()).toString());
    response.addCookie(cook);
    response.addCookie(userID);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuário autenticado");
}


@Authenticated
@PostMapping("postar")
public ResponseEntity<String> postMethodName(@Validated @ModelAttribute postDTO post
, @CookieValue(value = "userid", defaultValue = "não encontrado") String userID) {
    var e = post.toEntity();
    e.setUsuario(repo.getReferenceById(Integer.parseInt(userID)));
    postserv.add(e);
    
    return ResponseEntity.status(HttpStatus.CREATED).body("Postado!");
}

@GetMapping(value = "feed")
public List<Post> getAll() {
    return postserv.getAll();
}
@Authenticated
@PostMapping("comentar")
public String comentarPost(@Validated @ModelAttribute CommentDTO dto) {
    
    coment.comentar(dto.toEntity());
    
    return null;
}


}


 