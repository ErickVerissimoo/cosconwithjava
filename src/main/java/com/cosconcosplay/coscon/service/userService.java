package com.cosconcosplay.coscon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cosconcosplay.coscon.model.Cliente;
import com.cosconcosplay.coscon.repository.userRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Service
public class userService implements GenericService<Cliente, Integer> {
@Autowired private userRepository repository;
@Autowired private sessionService service;
@Override
@Transactional
public void add(Cliente entity) {
if(repository.existsByEmail(entity.getEmail())){
throw new EntityExistsException("A entidade já existe");
}
repository.saveAndFlush(entity);
}

@Override
public Cliente get(Integer id) {
try{
return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("A entidade não foi encontrada"));
}catch(EntityNotFoundException e){
System.out.println(e.getMessage());
return null;

}
}

@Override
public List<Cliente> getAll() {
return repository.findAll();    

}
public Integer findID(String username){
return Optional.of(repository.findIdByUsername(username)).orElseThrow(() -> new EntityNotFoundException("Entidade não existe") );
}


@Override
@Transactional
public void update(Cliente entity) {
    if (!repository.existsById(entity.getId())) {
        throw new EntityNotFoundException("Entidade não encontrada");
    }
    repository.save(entity);
}

@Override
public void delete(Integer id) {
try{
repository.deleteById(id);
}    catch(EntityNotFoundException ex){
System.out.println(ex.getMessage());
}}
public void login(Cliente usuario){
try{
    service.associateAndLogin(usuario);
System.out.println("Login efetuado com sucesso!");

}catch(EntityNotFoundException ex){
ex.printStackTrace();
}
}
public  record usuarioDTO(@Email String email, @NotBlank String username, @Size(min = 9) String password){
    public Cliente toEntity(){
        return Cliente.builder().email(this.email).password(this.password).username(this.username).build();
    }
}

}




