package com.example.mongodb_demo.controller;

import com.example.mongodb_demo.model.Music;
import com.example.mongodb_demo.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    MusicService service;

    @GetMapping("/")
    public ResponseEntity<List<Music>>list(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> create(@RequestBody Music music){
        return new ResponseEntity<>(service.create(music), HttpStatus.OK);
    }
}
