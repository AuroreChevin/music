package fr.fms.music.web;

import fr.fms.music.business.IbusinessImpl;
import fr.fms.music.entities.Album;
import fr.fms.music.entities.MusicalGenre;
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
    @GetMapping("/musicalgenres")
    public ResponseEntity<List<MusicalGenre>> getAllMusicalGenres(){
        List<MusicalGenre> musicalGenres = business.getAllMusicalGenres();
        return new ResponseEntity<List<MusicalGenre>>(musicalGenres,HttpStatus.OK);
    }
    @GetMapping("/musicalgenres/{id}")
    public MusicalGenre getMusicalGenreById(@PathVariable("id") Long id){
        return business.readMusicalGenreById(id).get();
    }
}
