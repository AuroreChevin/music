package fr.fms.music;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AlbumJpaTest {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    MusicalGenreRepository musicalGenreRepository;
    @Test
    void should_find_all_albums(){
       albumRepository.save(new Album(null, "babar", "personnage", 0, 0, null));
        Iterable<Record> records = albumRepository.findAll();
        assertThat(records).isNotEmpty();
    }
    @Test
    void should_find_all_musicalGenres(){
        musicalGenreRepository.save(new MusicalGenre(null, "rnb",null));
        Iterable<MusicalGenre> musicalGenres = musicalGenreRepository.findAll();
        assertThat(musicalGenres).isNotEmpty();
    }
    @Test
    void should_add_alum(){
        MusicalGenre musicalGenre = musicalGenreRepository.save(new MusicalGenre(null, "anonymous", null));
        albumRepository.save(new Album(null, "incognito", "bidule", 1960, 0, null));
        Album album = albumRepository.findByAlbumNameContains("incognitp").get(0);
        assertEquals("bidule", album.getBandName());
    }
}
