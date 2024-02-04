package fr.rory.music.business;

import fr.rory.music.entities.Album;
import fr.rory.music.entities.BandName;
import fr.rory.music.entities.MusicalGenre;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface Ibusiness {
    MusicalGenre saveMusicalGenre(MusicalGenre musicalGenre);

    Album saveAlbum(Album album);
    List<Album> getAllAlbums();
    Page<Album> getAllAlbumsPagination(int page, int size);

    List<MusicalGenre> getAllMusicalGenres();

    Album readAlbumById(Long id);

    MusicalGenre readMusicalGenreById(Long id);

    List<Album> readAlbumByMusicalGenreId(Long id);

    BandName saveBandName(BandName bandName);

    List<Album> readAlbumByBandName(String keyword);
}
