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

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AlbumJpaTest {
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
    void should_find_albums_by_albumName_contains(){
        Album album = albumRepository.save(new Album(null, "babar",  0, null, null, null));
        Iterable<Album> albums = albumRepository.findByAlbumNameContains("b");
        assertThat(albums).isNotEmpty();
    }
    @Test
    void should_find_album_by_albumName(){
        Album album = albumRepository.save(new Album(null, "babar",  0, null, null, null));
        assertThat(album.getAlbumName()).isEqualTo("babar");
    }
    @Test
    void should_find_album_by_releaseYear(){
        Album album = albumRepository.save(new Album(null, "babar",  1985, null, null, null));
        assertThat(album.getReleaseYear()).isEqualTo(1985);
    }
    @Test
    void should_find_album_by_photo(){
        Album album = albumRepository.save(new Album(null, "babar",  1985, "unknown.png", null, null));
        assertThat(album.getPhoto()).isEqualTo("unknown.png");
    }
    @Test
    void should_find_album_by_musical_genre(){
        MusicalGenre grind = musicalGenreRepository.save(new MusicalGenre(null, "grind",null));
        Album album = albumRepository.save(new Album(null, "babar",  1985, "unknown.png", grind, null));
        assertThat(album.getMusicalGenre()).isEqualTo(grind);
    }
    @Test
    void should_find_album_by_band_name(){
        MusicalGenre grind = musicalGenreRepository.save(new MusicalGenre(null, "grind",null));
        BandName wormrot = bandNameRepository.save(new BandName(null, "wormrot", "singapour", null));
        Album album = albumRepository.save(new Album(null, "babar",  1985, "unknown.png", grind, wormrot));
        assertThat(album.getBandName()).isEqualTo(wormrot);
    }
   /* @Test
    void should_find_all_musicalGenres(){
        musicalGenreRepository.save(new MusicalGenre(null, "rnb",null));
        Iterable<MusicalGenre> musicalGenres = musicalGenreRepository.findAll();
        assertThat(musicalGenres).isNotEmpty();
    }*/


}
