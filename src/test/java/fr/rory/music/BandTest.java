package fr.rory.music;

import fr.rory.music.entities.Album;
import fr.rory.music.entities.BandName;
import fr.rory.music.repositories.AlbumRepository;
import fr.rory.music.repositories.BandNameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BandTest {
    @Autowired
    BandNameRepository bandNameRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Test
    void should_find_band_by_name(){
        BandName wormrot = bandNameRepository.save(new BandName(null, "wormrot", "Sigapour",null));
        assertThat(wormrot.getName()).isEqualTo("wormrot");
    }
    @Test
    void should_find_band_by_country(){
        BandName wormrot = bandNameRepository.save(new BandName(null, "wormrot", "Singapour",null));
        assertThat(wormrot.getCountry()).isEqualTo("Singapour");
    }
    @Test
    void should_find_band_by_albums() {
        Album album = albumRepository.save(new Album(null, "babar",  1985, "unknown.png", null, null));
        Collection<Album> albums = albumRepository.findAll();
        BandName wormrot = bandNameRepository.save(new BandName(null, "wormrot", "Singapour",albums));
        assertThat(wormrot.getAlbumsCollection()).isNotEmpty();
    }
    @Test
    void should_find_band_to_string(){
        BandName wormrot = bandNameRepository.save(new BandName(null, "wormrot", "Singapour",null));
        assertTrue(wormrot.toString().contains("wormrot"));
    }
}
