package fr.rory.music;

import fr.rory.music.business.IbusinessImpl;
import fr.rory.music.entities.Album;
import fr.rory.music.entities.BandName;
import fr.rory.music.entities.MusicalGenre;
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
		business.saveAlbum(new Album(null,"Nord", 2006, "nord.png", postMetal, yearOfNoLight));
		business.saveAlbum(new Album(null,"Ausserwelt", 2010, "ausserwelt.png", postMetal, yearOfNoLight));

		business.saveAlbum(new Album(null,"Reign in blood", 1986, "reign in blood.png", trashMetal, slayer));
		business.saveAlbum(new Album(null,"Hell Awaits", 1985, "unknown.png", trashMetal, slayer));
		business.saveAlbum(new Album(null,"Show no mercy", 1983, "unknown.png", trashMetal, slayer));
		business.saveAlbum(new Album(null,"South of heaven", 1988, "unknown.png", trashMetal, slayer));
		business.saveAlbum(new Album(null,"Seasons in the Abyss", 1990, "unknown.png", trashMetal, slayer));

		business.saveAlbum(new Album(null,"From beale street of oblivion", 2007, "from beale street to oblivion.png", sludgeMetal, clutch));

		business.saveAlbum(new Album(null,"Blues for the red sun",  1992, "blues for the red sun.png", sludgeMetal, kyuss));

		business.saveAlbum(new Album(null,"One of us is the killer", 2013, "one of us is the killer.png", mathCore, theDillingerEscapePlan));
		business.saveAlbum(new Album(null,"Calculating infinity", 1999, "calculating infinity.png", mathCore, theDillingerEscapePlan));
		business.saveAlbum(new Album(null,"Miss machine", 2004, "miss machine.png", mathCore, theDillingerEscapePlan));
		business.saveAlbum(new Album(null,"Iron works", 2007, "iron works.png", mathCore, theDillingerEscapePlan));
		business.saveAlbum(new Album(null,"Option Paralysis", 2010, "option paralysis.png", mathCore, theDillingerEscapePlan));
		business.saveAlbum(new Album(null,"Dissociation", 2016, "dissociation.png", mathCore, theDillingerEscapePlan));
		business.saveAlbum(new Album(null,"Somewhere along the way", 2006, "somewhere along the highway.png", postMetal, cultOfLuna));
		business.saveAlbum(new Album(null,"Cult of Luna", 2001, "cult of luna.png", postMetal, cultOfLuna));
		business.saveAlbum(new Album(null,"The beyond", 2003, "the beyond.png", postMetal, cultOfLuna));
		business.saveAlbum(new Album(null,"Salvation", 2004, "salvation.png", postMetal, cultOfLuna));
		business.saveAlbum(new Album(null,"Burn my eyes", 1994, "burn my eyes.png", trashMetal, machineHead));
		business.saveAlbum(new Album(null,"Cowboys from hell", 1990, "cowboys from hell.png", trashMetal, pantera));
		business.saveAlbum(new Album(null,"The hunter", 2011, "the hunter.png", sludgeMetal, mastodon));

		business.saveAlbum(new Album(null,"Houdini", 1993, "houdini.png", sludgeMetal, melvins));

		business.saveAlbum(new Album(null,"All we love we leave behind", 2012, "all we love we leave behind.png", mathCore, converge));
		business.saveAlbum(new Album(null, "Jane Doe", 2002, "jane doe.png", mathCore, converge));
		business.saveAlbum(new Album(null, "You fail me", 2004, "you fail me.png", mathCore, converge));
		business.saveAlbum(new Album(null, "No heroes", 2006, "no heroes.png", mathCore, converge));
		business.saveAlbum(new Album(null, "Axe to fall", 2009, "axe to fall.png", mathCore, converge));

		business.saveAlbum(new Album(null,"Mass IIII", 2008, "mass IIII.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"Mass I", 2003, "mass I.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"Mass II", 2005, "mass II.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"Mass III", 2005, "mass III.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"Mass V", 2012, "mass V.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"Mass VI", 2017, "mass VI.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"De doorn", 2021, "de doorn.png", postMetal, amenra));
		business.saveAlbum(new Album(null,"Delivrance", 1994, "delivrance.png", sludgeMetal, corrosionOfConformity));
		business.saveAlbum(new Album(null,"Nola", 1995, "NOLA.png", sludgeMetal, down));
		business.saveAlbum(new Album(null,"Roots", 1996, "roots.png", trashMetal, sepultura));
		business.saveAlbum(new Album(null,"Station", 2008, "station.png", postMetal, russianCircles));
		business.saveAlbum(new Album(null,"Blood year", 2019, "blood year.png", postMetal, russianCircles));


	}
}
