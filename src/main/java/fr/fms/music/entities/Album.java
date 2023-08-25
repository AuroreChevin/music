package fr.fms.music.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Album implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String albumName;
    private int releaseYear;
    private String photo;
    @ManyToOne
    MusicalGenre musicalGenre;
    @ManyToOne
    BandName bandName;

}
