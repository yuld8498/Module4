package com.example.musicapp.controller;

import com.example.musicapp.model.Song;
import com.example.musicapp.model.SongUpload;
import com.example.musicapp.service.IMusicService;
import com.example.musicapp.service.MusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;
    IMusicService musicService = new MusicService();

    @GetMapping("")
    public String pageIndex(Model model){
        List<Song> Songs = musicService.findAll();
        model.addAttribute("Songs",Songs);
        return "index" ;
    }
    @GetMapping("/create")
    public ModelAndView createSong(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("SongUpload",new SongUpload());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SongUpload songUpload ) {
        MultipartFile multipartFile= songUpload.getFile();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songUpload.getFile().getBytes(), new File(fileUpload));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Song song = new Song(songUpload.getNameOfSong(),songUpload.getNameOfSinger(),songUpload.getTypeOfSong(),fileName);
        musicService.addASong(song);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("SongUpload",songUpload);
        modelAndView.addObject("fileName",fileName);
        modelAndView.addObject("message","Upload is successfully");
        return modelAndView;
    }
}
