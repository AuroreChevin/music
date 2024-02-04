package fr.rory.music.repositories;

import fr.rory.music.entities.BandName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandNameRepository extends JpaRepository <BandName, Long> {
}
