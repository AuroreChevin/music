package fr.rory.music.web;

import fr.rory.music.business.IbusinessImpl;
import fr.rory.music.entities.MusicalGenre;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
@Slf4j
public class MusicalGenreController {
    @Autowired
    IbusinessImpl business;

    @GetMapping(value = "/musical-genres")
    public ResponseEntity<List<MusicalGenre>> getAllMusicalGenres(){
        List<MusicalGenre> musicalGenres = business.getAllMusicalGenres();
        return ResponseEntity.ok(musicalGenres);
    }
    @GetMapping(value = "/musical-genres/{id}")
    public ResponseEntity<MusicalGenre> getMusicalGenreById(@PathVariable("id") Long id){
        return ResponseEntity.ok(business.readMusicalGenreById(id));
    }
}
