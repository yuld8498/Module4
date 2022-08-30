package com.example.musicapp.model;

import org.springframework.web.multipart.MultipartFile;

public class SongUpload {
    private Long id;
    private String nameOfSong;
    private String nameOfSinger;
    private String typeOfSong;
    private MultipartFile file;

    public SongUpload() {
    }

    public SongUpload(Long id, String nameOfSong, String nameOfSinger, String typeOfSong, MultipartFile file) {
        this.id = id;
        this.nameOfSong = nameOfSong;
        this.nameOfSinger = nameOfSinger;
        this.typeOfSong = typeOfSong;
        this.file = file;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
