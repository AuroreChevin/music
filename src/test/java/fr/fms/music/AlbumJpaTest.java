package fr.fms.music;

import fr.fms.music.entities.Album;
import fr.fms.music.entities.BandName;
import fr.fms.music.entities.MusicalGenre;
import fr.fms.music.repositories.AlbumRepository;
import fr.fms.music.repositories.BandNameRepository;
import fr.fms.music.repositories.MusicalGenreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AlbumJpaTest {
   @Autowired
    AlbumRepository albumRepository;
    @Autowired
    MusicalGenreRepository musicalGenreRepository;
    @Autowired
    BandNameRepository bandNameRepository;
    @Test
    void should_find_all_albums(){
       albumRepository.save(new Album(null, "babar",  0, null, null, null));
        Iterable<Album> albums = albumRepository.findAll();
        assertThat(albums).isNotEmpty();
    }
    @Test
    void should_find_all_musicalGenres(){
        musicalGenreRepository.save(new MusicalGenre(null, "rnb",null));
        Iterable<MusicalGenre> musicalGenres = musicalGenreRepository.findAll();
        assertThat(musicalGenres).isNotEmpty();
    }


}
