package fr.rory.music.business;

import fr.rory.music.entities.Album;
import fr.rory.music.entities.BandName;
import fr.rory.music.entities.MusicalGenre;
import fr.rory.music.repositories.AlbumRepository;
import fr.rory.music.repositories.BandNameRepository;
import fr.rory.music.repositories.MusicalGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IbusinessImpl implements Ibusiness{
    @Autowired
    MusicalGenreRepository musicalGenreRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    BandNameRepository bandNameRepository;
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
    public Page<Album> getAllAlbumsPagination(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        return albumRepository.findAllByOrderByAlbumNameAsc(paging);
    }

    @Override
    public List<MusicalGenre> getAllMusicalGenres() {
        return musicalGenreRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Album readAlbumById(Long id){
        Optional<Album> optional = albumRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public MusicalGenre readMusicalGenreById(Long id) {
        Optional<MusicalGenre> optional = musicalGenreRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Album> readAlbumByMusicalGenreId(Long id) {
        return albumRepository.findByMusicalGenreId(id);
    }

    @Override
    public BandName saveBandName(BandName bandName) {
        return bandNameRepository.save(bandName);
    }

    @Override
    public List<Album> readAlbumByBandName(String keyword) {
        if(albumRepository.findByBandNameNameContains(keyword) == null) {
            return new ArrayList<>();
        }
        else{
            return albumRepository.findByBandNameNameContains(keyword);
        }
    }

}
