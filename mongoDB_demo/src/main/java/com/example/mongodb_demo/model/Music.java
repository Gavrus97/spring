package com.example.mongodb_demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.*;

@Document
public class Music {

    @Id
    private String id;

    private String name;

    private Spring descr;

    private Integer createDate;

    private String[] genre;

    public Music(String id, String name, Spring descr, Integer createDate, String[] genre) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.createDate = createDate;
        this.genre = genre;
    }

    public Music() {
    }

    public Music(String name, Spring descr, Integer createDate, String[] genre) {
        this.name = name;
        this.descr = descr;
        this.createDate = createDate;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Spring getDescr() {
        return descr;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescr(Spring descr) {
        this.descr = descr;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }
}
