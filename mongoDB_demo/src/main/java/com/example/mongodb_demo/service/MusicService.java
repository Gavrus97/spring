package com.example.mongodb_demo.service;

import com.example.mongodb_demo.model.Music;
import com.example.mongodb_demo.repo.MusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    MusicRepo repo;

     public List<Music> getAll(){
         return repo.findAll();
     }

     public String create(Music music){
         Music entity = repo.save(music);
         return entity.getId();
     }
}
