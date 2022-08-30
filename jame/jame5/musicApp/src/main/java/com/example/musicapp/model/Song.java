package com.example.musicapp.model;

import javax.persistence.*;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfSong;
    private String nameOfSinger;
    private String typeOfSong;
    private String url;

    public Song() {
    }

    public Song(Long id, String nameOfSong, String nameOfSinger, String typeOfSong, String url) {
        this.id = id;
        this.nameOfSong = nameOfSong;
        this.nameOfSinger = nameOfSinger;
        this.typeOfSong = typeOfSong;
        this.url = url;
    }

    public Song(String nameOfSong, String nameOfSinger, String typeOfSong, String url) {
        this.nameOfSong = nameOfSong;
        this.nameOfSinger = nameOfSinger;
        this.typeOfSong = typeOfSong;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfSong() {
        return nameOfSong;
    }

    public void setNameOfSong(String nameOfSong) {
        this.nameOfSong = nameOfSong;
    }

    public String getNameOfSinger() {
        return nameOfSinger;
    }

    public void setNameOfSinger(String nameOfSinger) {
        this.nameOfSinger = nameOfSinger;
    }

    public String getTypeOfSong() {
        return typeOfSong;
    }

    public void setTypeOfSong(String typeOfSong) {
        this.typeOfSong = typeOfSong;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Song{" +
                "nameOfSong='" + nameOfSong + '\'' +
                ", nameOfSinger='" + nameOfSinger + '\'' +
                ", typeOfSong='" + typeOfSong + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}