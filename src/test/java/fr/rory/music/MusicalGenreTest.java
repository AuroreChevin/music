package fr.rory.music;

import fr.rory.music.entities.MusicalGenre;
import fr.rory.music.repositories.MusicalGenreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MusicalGenreTest {
    @Autowired
    MusicalGenreRepository musicalGenreRepository;
    @Test
    void should_find_musical_genre_by_name(){
        MusicalGenre grind = musicalGenreRepository.save(new MusicalGenre(null, "grind",null));
        assertThat(grind.getName()).isEqualTo("grind");
    }
}
