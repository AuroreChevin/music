package fr.rory.music.web;

import fr.rory.music.business.IbusinessImpl;
import fr.rory.music.entities.Album;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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

    @GetMapping(value = "/albums")
    public ResponseEntity<List<Album>> getAllAlbums(){
        List<Album> albums = business.getAllAlbums();
        if(albums == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(albums);
    }

    @GetMapping(value ="/albums/paging")
    public Page<Album>getAllAlbumsPagination(@RequestParam(defaultValue = "0")int page,
                                                                     @RequestParam(defaultValue = "8") int size){
        return business.getAllAlbumsPagination(page,size);
    }

    @GetMapping(value ="/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable("id") Long id){
        return ResponseEntity.ok(business.readAlbumById(id));
    }

    @GetMapping(value ="/albums/musical-genres/{id}")
    public ResponseEntity<List<Album>> getAllAlbumsByMusicalGenreId(@PathVariable("id") Long id ){
        return ResponseEntity.ok(business.readAlbumByMusicalGenreId(id));
    }

    @GetMapping("/albums/band-names/keyword={keyword}")
    public ResponseEntity<List<Album>> getAllAlbumsByBandName(@PathVariable("keyword") String keyword ){
        return ResponseEntity.ok(business.readAlbumByBandName(keyword));
    }

    @GetMapping(path = "/photos/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<?> getPhotos(@PathVariable("id") Long id) {
        byte[] file;
        try {
            Album album = business.readAlbumById(id);
            if (album.getPhoto()==null)album.setPhoto("unknown.png");
            file = Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/desktop/musicproject/musical/images/"+album.getPhoto()));
        }catch (Exception e){
            log.error("problème lors du download de l'image correspondant à l'album d'id : {}", id);
            return ResponseEntity.internalServerError().body(e.getCause());
        }
        return ResponseEntity.ok().body(file);
    }

    @PostMapping(path="/photos/{id}")
    public ResponseEntity<?> uploadPhoto(MultipartFile file, @PathVariable("id")Long id) {
        try {
            Album album = business.readAlbumById(id);
            album.setPhoto(file.getOriginalFilename());
            Files.write(Paths.get(System.getProperty("user.home")+"/desktop/musicproject/musical/images/"+album.getPhoto()),file.getBytes());
            business.saveAlbum(album);
        }catch (Exception e){
            log.error("problème lors de l'upload de l'image correspondant à l'album d'id : {}", id);
            return ResponseEntity.internalServerError().body(e.getCause());
        }
        log.info("file upload ok {}",id);
        return ResponseEntity.ok().build();
    }
}
