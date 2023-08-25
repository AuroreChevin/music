package fr.fms.music.repositories;

import fr.fms.music.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByAlbumNameContains(String albumName);
    List<Album> findAllByOrderByAlbumNameAsc();
    List<Album> findByMusicalGenreId(Long id);
    List<Album> findByBandNameNameContains(String name);
}
