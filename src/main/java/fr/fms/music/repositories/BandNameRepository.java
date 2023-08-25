package fr.fms.music.repositories;

import fr.fms.music.entities.BandName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandNameRepository extends JpaRepository <BandName, Long> {
}
