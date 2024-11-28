package com.cosconcosplay.coscon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosconcosplay.coscon.model.Reply;
import com.cosconcosplay.coscon.repository.replyRepository;

@Service
public class replyService {
@Autowired private replyRepository repository;

public void responder(Reply reply){
    repository.save(reply);
    

}

}
