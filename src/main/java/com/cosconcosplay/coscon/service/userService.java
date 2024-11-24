package com.cosconcosplay.coscon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosconcosplay.coscon.model.User;
import com.cosconcosplay.coscon.repository.userRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class userService implements GenericService<User, Integer> {
@Autowired private userRepository repository;

@Override
public void add(User entity) {
if(repository.existsByEmail(entity.getEmail())){
throw new EntityExistsException("A entidade já existe");
}
repository.save(entity);
}

@Override
public User get(Integer id) {
try{
return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("A entidade não foi encontrada"));
}catch(EntityNotFoundException e){
System.out.println(e.getMessage());
return null;

}
}

@Override
public List<User> getAll() {
return repository.findAll();    

}

@Override
public void update(User entity) {
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
}


}


}

