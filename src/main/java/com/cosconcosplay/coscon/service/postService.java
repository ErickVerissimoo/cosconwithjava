package com.cosconcosplay.coscon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cosconcosplay.coscon.model.Post;
import com.cosconcosplay.coscon.repository.postRepository;

import jakarta.persistence.EntityNotFoundException;

public class postService implements GenericService<Post, Integer> {
    @Autowired private postRepository repository;
    @Override
    public void add(Post entity)
     {
        repository.saveAndFlush(entity);

    }

    @Override
    public Post get(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post não existe"));    
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(Post entity) throws Exception {
        repository.save(entity);
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("Id não pode ser nulo");
        }
        
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Entidade com o ID " + id + " não encontrada");
        }
        
        repository.deleteById(id);
    }
}
