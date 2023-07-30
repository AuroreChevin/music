package fr.fms.music.business;

import fr.fms.music.entities.Album;
import fr.fms.music.entities.MusicalGenre;
import fr.fms.music.repositories.AlbumRepository;
import fr.fms.music.repositories.MusicalGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IbusinessImpl implements Ibusiness{
    @Autowired
    MusicalGenreRepository musicalGenreRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Override
    public MusicalGenre saveMusicalGenre(MusicalGenre musicalGenre) {
        return musicalGenreRepository.save(musicalGenre);
    }

    @Override
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAllByOrderByAlbumNameAsc();
    }

    @Override
    public List<MusicalGenre> getAllMusicalGenres() {
        return musicalGenreRepository.findAll();
    }

    @Override
    public Optional<Album> readAlbumById(Long id) {
        return albumRepository.findById(id);
    }

    @Override
    public Optional<MusicalGenre> readMusicalGenreById(Long id) {
        return musicalGenreRepository.findById(id);
    }

    @Override
    public List<Album> readAlbumByMusicalGenreId(Long id) {
        return albumRepository.findByMusicalGenreId(id);
    }

}