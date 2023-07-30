package fr.fms.music.business;

import fr.fms.music.entities.Album;
import fr.fms.music.entities.MusicalGenre;

import java.util.List;
import java.util.Optional;

public interface Ibusiness {
    MusicalGenre saveMusicalGenre(MusicalGenre musicalGenre);

    Album saveAlbum(Album album);

    List<Album> getAllAlbums();

    List<MusicalGenre> getAllMusicalGenres();

    Optional readAlbumById(Long id);

    Optional readMusicalGenreById(Long id);

    List<Album> readAlbumByMusicalGenreId(Long id);
}
