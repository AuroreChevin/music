package fr.fms.music;

import fr.fms.music.business.IbusinessImpl;
import fr.fms.music.entities.Album;
import fr.fms.music.entities.MusicalGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicApplication implements CommandLineRunner {
	@Autowired
	IbusinessImpl business;
	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	generateData();
	}

	private void generateData() {
		MusicalGenre mathCore = business.saveMusicalGenre(new MusicalGenre(null,"Math Core", null));
		MusicalGenre sludgeMetal = business.saveMusicalGenre(new MusicalGenre(null,"Sludge/Stoner Metal", null));
		MusicalGenre trashMetal = business.saveMusicalGenre(new MusicalGenre(null,"Trash Metal", null));
		MusicalGenre postMetal =business.saveMusicalGenre(new MusicalGenre(null,"Post Metal", null));

		business.saveAlbum(new Album(null,"Tocsin", "Year of no light", 2013, "unknown.png", postMetal));
		business.saveAlbum(new Album(null,"Reign in blood", "Slayer", 1986, "unknown.png", trashMetal));
		business.saveAlbum(new Album(null,"From beale street of oblivion", "Clutch", 2007, "unknown.png", sludgeMetal));
		business.saveAlbum(new Album(null,"Blues for the red sun", "Kyuss", 1992, "unknown.png", sludgeMetal));
		business.saveAlbum(new Album(null,"One of us is the killer", "The dillinger escape plan", 2013, "unknown.png", mathCore));
		business.saveAlbum(new Album(null,"Somewhere along the way", "Cult of Luna", 2006, "unknown.png", postMetal));
		business.saveAlbum(new Album(null,"Burn my eyes", "Machine Head", 1994, "unknown.png", trashMetal));
		business.saveAlbum(new Album(null,"Cowboys from hell", "Pantera", 1990, "unknown.png", trashMetal));
		business.saveAlbum(new Album(null,"The hunter", "Mastodon", 2011, "unknown.png", sludgeMetal));
		business.saveAlbum(new Album(null,"Houdini", "Melvins", 1993, "unknown.png", sludgeMetal));
		business.saveAlbum(new Album(null,"All we love we leave behind", "Converge", 2012, "unknown.png", mathCore));
		business.saveAlbum(new Album(null,"Mass IIII", "Amenra", 2008, "unknown.png", postMetal));
		business.saveAlbum(new Album(null,"Delivrance", "Corrosion of conformity", 1994, "unknown.png", sludgeMetal));
		business.saveAlbum(new Album(null,"Nola", "Down", 1995, "unknown.png", sludgeMetal));
		business.saveAlbum(new Album(null,"Roots", "Sepultura", 1996, "unknown.png", trashMetal));
		business.saveAlbum(new Album(null,"Station", "Russian Circles", 2008, "unknown.png", postMetal));


	}
}
