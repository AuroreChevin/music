package fr.fms.music.repositories;
import fr.fms.music.entities.Album;
import fr.fms.music.entities.MusicalGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicalGenreRepository extends JpaRepository<MusicalGenre, Long> {
    List<MusicalGenre> findAllByOrderByNameAsc();
}
