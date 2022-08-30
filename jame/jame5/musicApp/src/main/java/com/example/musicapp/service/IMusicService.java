package com.example.musicapp.service;

import com.example.musicapp.model.Song;

import java.util.List;

public interface IMusicService {
    List<Song> findAll();
    Song findASong(Long id);
    void addASong(Song song);
    Song UpdateASong(Song song);
    Song choseASong(String Name);
    void deleteASong(Song song);
}
