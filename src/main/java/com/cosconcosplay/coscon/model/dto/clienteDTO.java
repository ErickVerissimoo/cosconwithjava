package com.cosconcosplay.coscon.model.dto;

import com.cosconcosplay.coscon.model.Cliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class  clienteDTO {
    private String email;
    private String username;
    private String password;
    private Integer id;
public Cliente toEntity(){
    return Cliente.builder().email(this.email).password(this.password).username(this.username).id(this.id).build();
}
}

