package fr.fms.music.business;

import fr.fms.music.entities.Album;
import fr.fms.music.entities.BandName;
import fr.fms.music.entities.MusicalGenre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface Ibusiness {
    MusicalGenre saveMusicalGenre(MusicalGenre musicalGenre);

    Album saveAlbum(Album album);
    List<Album> getAllAlbums();
    Page<Album> getAllAlbumsPagination(int page, int size);

    List<MusicalGenre> getAllMusicalGenres();

    Optional readAlbumById(Long id);

    Optional readMusicalGenreById(Long id);

    List<Album> readAlbumByMusicalGenreId(Long id);

    BandName saveBandName(BandName bandName);

    List<Album> readAlbumByBandName(String keyword);
}
