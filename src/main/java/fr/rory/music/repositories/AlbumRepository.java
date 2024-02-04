package fr.rory.music.repositories;

import fr.rory.music.entities.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByAlbumNameContains(String albumName);
    List<Album> findAllByOrderByAlbumNameAsc();
    Page<Album> findAllByOrderByAlbumNameAsc(Pageable pageable);
    List<Album> findByMusicalGenreId(Long id);
    List<Album> findByBandNameNameContains(String name);
}
