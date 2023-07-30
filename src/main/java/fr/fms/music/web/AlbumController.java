package fr.fms.music.web;

import fr.fms.music.business.IbusinessImpl;
import fr.fms.music.entities.Album;
import fr.fms.music.entities.MusicalGenre;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping
@Slf4j
public class AlbumController {
    @Autowired
    IbusinessImpl business;
    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAllAlbums(){
        List<Album> albums = business.getAllAlbums();
        return new ResponseEntity<List<Album>>(albums,HttpStatus.OK);
    }
    @GetMapping("/album/{id}")
    public Album getAlbumById(@PathVariable("id") Long id){
        return business.readAlbumById(id).get();
    }
    @GetMapping("/albums/musicalgenres/{id}")
    public List<Album> getAllAlbumsByMusicalGenreId(@PathVariable("id") Long id ){
        return business.readAlbumByMusicalGenreId(id);
    }
    @GetMapping(path = "/photo/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<?> getPhotos(@PathVariable("id") Long id) throws IOException{
        byte[] file =null;
        try {
            Album album = business.readAlbumById(id).get();
            if (album.getPhoto()==null)album.setPhoto("unknown.png");
            file = Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/musical/images/"+album.getPhoto()));
        }catch (Exception e){
            log.error("problème lors du download de l'image correspondant à l'album d'id : {}", id);
            return ResponseEntity.internalServerError().body(e.getCause());
        }
        return ResponseEntity.ok().body(file);
    }
    @PostMapping(path="/photo/{id}")
    public ResponseEntity<?> uploadPhoto(MultipartFile file, @PathVariable("id")Long id) throws IOException{
        try {
            Album album = business.readAlbumById(id).get();
            album.setPhoto(file.getOriginalFilename());
            Files.write(Paths.get(System.getProperty("user.home")+"/musical/images/"+album.getPhoto()),file.getBytes());
            business.saveAlbum(album);
        }catch (Exception e){
            log.error("problème lors de l'upload de l'image correspondant à l'album d'id : {}", id);
            return ResponseEntity.internalServerError().body(e.getCause());
        }
        return ResponseEntity.ok().build();
    }
}
