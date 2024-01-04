package org.lessons.java.spring.bestoftheyear.controller;

import org.lessons.java.spring.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    @GetMapping
    public String songList(Model model){
        List<Song> songs = getSong();
        model.addAttribute("songs", songs);
        return "Song-list";
    }
    @GetMapping("/details")
    public String songDetails(@RequestParam int id, Model model) {
        Song song = getSongById(id);
        model.addAttribute("song", song);
        return "song-details";
    }
    public List<Song> getSong(){
        List<Song> songs = new ArrayList<>();

        songs.add(new Song(1, "Gigi D'alessio", "Non dirgli mai"));
        songs.add(new Song(2, "Martin Garrix", "Animals"));
        songs.add(new Song(3, "Eiffel 65", "I'm blue"));
        songs.add(new Song(4, "Mahamood & Blanco", "Brividi"));
        songs.add(new Song(5, "Rosario Miraggio", "Male"));
        return songs;
    }

    private Song getSongByName(String songName) {
        Song song = null;
        for (Song p : getSong() ) {
            if (p.getTitle().equals(songName)) {
                song = p;
                break;
            }
        }
        return song ;
    }
    private Song getSongById(int songId) {
        Song song = null;
        for (Song p : getSong()) {
            if (p.getId() == songId ){
                song = p;
                break;
            }
        }
        return song;
    }

}

