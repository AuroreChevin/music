package fr.fms.music.repositories;
import fr.fms.music.entities.MusicalGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicalGenreRepository extends JpaRepository<MusicalGenre, Long> {
}
