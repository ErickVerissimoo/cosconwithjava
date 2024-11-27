package com.cosconcosplay.coscon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosconcosplay.coscon.repository.userRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;

@Service
public class sessionService {
    @Autowired private userRepository userRepo;
    @Autowired private HttpSession sessao;
    public void associateAndLogin(String email) throws EntityNotFoundException
    {
        if(userRepo.existsByEmail(email)){
            var entity = userRepo.findByEmail(email);
            entity.setSessionId(sessao.getId());
            userRepo.saveAndFlush(entity);
        }
     else{
        throw new EntityNotFoundException("Entidade não encontrada");
     }
    }
  
}
