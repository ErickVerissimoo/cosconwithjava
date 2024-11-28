package com.cosconcosplay.coscon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosconcosplay.coscon.model.Cliente;
import com.cosconcosplay.coscon.repository.userRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;

@Service
public class sessionService {
    @Autowired private userRepository userRepo;
    @Autowired private HttpSession sessao;
    public void associateAndLogin(Cliente user) throws EntityNotFoundException
    {
        if(userRepo.existsByEmail(user.getEmail()) && userRepo.existsById(user.getId())){
            var entity = userRepo.getReferenceById(user.getId());
            entity.setSessionId(sessao.getId());
            userRepo.saveAndFlush(entity);
        }
     else{
        throw new EntityNotFoundException("Entidade não encontrada");
     }
    }
  
}
