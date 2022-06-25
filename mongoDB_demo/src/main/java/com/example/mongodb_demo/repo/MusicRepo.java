package com.example.mongodb_demo.repo;

import com.example.mongodb_demo.model.Music;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicRepo extends MongoRepository<Music, String> {

    Music getByName(String name);
}
