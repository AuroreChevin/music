package fr.fms.music;

import fr.fms.music.business.IbusinessImpl;
import fr.fms.music.entities.Album;
import fr.fms.music.entities.BandName;
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
		BandName yearOfNoLight = business.saveBandName(new BandName(null, "Year of no light", "France", null));
		BandName slayer = business.saveBandName(new BandName(null, "Slayer", "Usa", null));
		BandName clutch = business.saveBandName(new BandName(null, "Clutch", "Usa", null));
		BandName kyuss = business.saveBandName(new BandName(null, "Kyuss", "Usa", null));
		BandName theDillingerEscapePlan = business.saveBandName(new BandName(null, "The dillinger escape plan", "Usa", null));
		BandName cultOfLuna = business.saveBandName(new BandName(null, "Cult of Luna", "Sweden", null));
		BandName machineHead = business.saveBandName(new BandName(null, "Machine Head", "Usa", null));
		BandName pantera = business.saveBandName(new BandName(null, "Pantera", "Usa", null));
		BandName mastodon = business.saveBandName(new BandName(null, "Mastodon", "Usa", null));
		BandName melvins = business.saveBandName(new BandName(null, "Melvins", "Usa", null));
		BandName converge = business.saveBandName(new BandName(null, "Converge", "Usa", null));
		BandName amenra = business.saveBandName(new BandName(null, "Amenra", "Belgium", null));
		BandName corrosionOfConformity = business.saveBandName(new BandName(null, "Corrosion of conformity", "Usa", null));
		BandName down = business.saveBandName(new BandName(null, "Down", "Usa", null));
		BandName sepultura = business.saveBandName(new BandName(null, "Sepultura", "Usa", null));
		BandName russianCircles = business.saveBandName(new BandName(null, "Russian Circles", "Usa", null));
		business.saveAlbum(new Album(null,"Tocsin", 2013, "tocsin.png", postMetal, yearOfNoLight));
		business.saveAlbum(new Album(null,"Nord", 2006, "unknown.png", postMetal, yearOfNoLight));
		business.saveAlbum(new Album(null,"Ausserwelt", 2010, "unknown.png", postMetal, yearOfNoLight));

		business.saveAlbum(new Album(null,"Reign in blood", 1986, "reign in blood.png", trashMetal, slayer));
		business.saveAlbum(new Album(null,"Hell Awaits", 1985, "unknown.png", trashMetal, slayer));
		business.saveAlbum(new Album(null,"Show no mercy", 1983, "unknown.png", trashMetal, slayer));
		business.saveAlbum(new Album(null,"South of heaven", 1988, "unknown.png", trashMetal, slayer));
		business.saveAlbum(new Album(null,"Seasons in the Abyss", 1990, "unknown.png", trashMetal, slayer));

		business.saveAlbum(new Album(null,"From beale street of oblivion", 2007, "from beale street to oblivion.png", sludgeMetal, clutch));

		business.saveAlbum(new Album(null,"Blues for the red sun",  1992, "blues for the red sun.png", sludgeMetal, kyuss));

		business.saveAlbum(new Album(null,"One of us is the killer", 2013, "one of us is the killer.png", mathCore, theDillingerEscapePlan));
		business.saveAlbum(new Album(null,"Calculating infinity", 1999, "unknown.png", mathCore, theDillingerEscapePlan));
		business.saveAlbum(new Album(null,"Miss machine", 2004, "unknown.png", mathCore, theDillingerEscapePlan));
		business.saveAlbum(new Album(null,"Iron works", 2007, "unknown.png", mathCore, theDillingerEscapePlan));
		business.saveAlbum(new Album(null,"Option Paralysis", 2010, "unknown.png", mathCore, theDillingerEscapePlan));
		business.saveAlbum(new Album(null,"Dissociation", 2016, "unknown.png", mathCore, theDillingerEscapePlan));
		business.saveAlbum(new Album(null,"Somewhere along the way", 2006, "somewhere along the highway.png", postMetal, cultOfLuna));
		business.saveAlbum(new Album(null,"Cult of Luna", 2001, "unknown.png", postMetal, cultOfLuna));
		business.saveAlbum(new Album(null,"The beyond", 2003, "unknown.png", postMetal, cultOfLuna));
		business.saveAlbum(new Album(null,"Salvation", 2004, "unknown.png", postMetal, cultOfLuna));
		business.saveAlbum(new Album(null,"Burn my eyes", 1994, "burn my eyes.png", trashMetal, machineHead));
		business.saveAlbum(new Album(null,"Cowboys from hell", 1990, "cowboys from hell.png", trashMetal, pantera));
		business.saveAlbum(new Album(null,"The hunter", 2011, "the hunter.png", sludgeMetal, mastodon));
		business.saveAlbum(new Album(null,"Houdini", 1993, "unknown.png", sludgeMetal, melvins));
		business.saveAlbum(new Album(null,"All we love we leave behind", 2012, "unknown.png", mathCore, converge));
		business.saveAlbum(new Album(null,"Mass IIII", 2008, "unknown.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"Mass I", 2003, "unknown.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"Mass II", 2005, "unknown.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"Mass III", 2005, "unknown.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"Mass V", 2012, "unknown.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"Mass VI", 2017, "unknown.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"De doorn", 2021, "unknown.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"Delivrance", 1994, "unknown.png", sludgeMetal, corrosionOfConformity));
		business.saveAlbum(new Album(null,"Nola", 1995, "unknown.png", sludgeMetal, down));
		business.saveAlbum(new Album(null,"Roots", 1996, "unknown.png", trashMetal, sepultura));
		business.saveAlbum(new Album(null,"Station", 2008, "unknown.png", postMetal, russianCircles));
		business.saveAlbum(new Album(null,"Blood year", 2019, "unknown.png", postMetal, russianCircles));


	}
}
