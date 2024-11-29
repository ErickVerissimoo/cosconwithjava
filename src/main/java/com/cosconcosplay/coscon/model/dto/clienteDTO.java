package com.cosconcosplay.coscon.model.dto;

import com.cosconcosplay.coscon.model.Cliente;


public class  clienteDTO {
     String email;
     String username;
     String password;
     Integer id;
public Cliente toEntity(){
    return Cliente.builder().email(this.email).password(this.password).username(this.username).id(this.id).build();
}
}

