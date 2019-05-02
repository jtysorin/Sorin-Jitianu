package magazin;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import categorii.CategorieFilm;
import categorii.CategorieMuzica;
import categorii.CategoriePublicatie;

public class Biblioteca {
	
	private List<Media> media = new ArrayList<>();
	private List<Publicatie> publicatie = new ArrayList<>();
	public Biblioteca() {}
	
	public void adaugaMedia(Media media) {
		this.media.add(media);
	}
	
	public void catalogMedia() {
		for(Media m : media) {
			System.out.println(m);
		}
	}
	
	public void consultaMedia(int id) {
		for(int i = 0; i < media.size(); i++) {
			if(media.get(i).getId()==id) {
				media.get(i).consulta();
				System.out.println("Media "+id+" este in consultare.");
				break;
			}
			if(i==media.size()-1) {
				System.out.println("Media "+id+" nu a fost gasita!");
			}
		}	
	}
	
	public void elibereazaMedia(int id) {
		for(int i = 0; i < media.size(); i++) {
			if(media.get(i).getId()==id) {
				media.get(i).elibereaza();
				System.out.println("Media "+id+" este libera.");
				break;
			}
			if(i==media.size()-1) {
				System.out.println("Media "+id+" nu a fost gasita!");
			}
		}	
	}
	
	public void adaugaPublicatie(Publicatie publicatie){
		this.publicatie.add(publicatie);
	}
	
	public void catalogPublicatii() {
		for(Publicatie p : publicatie) {
			System.out.println(p);
		}
	}
	
	public void imprumutaPublicatie(int id, LocalDate dataImprumut) throws Exception{
		try {	
			for(int i = 0; i < publicatie.size(); i++) {
				if(publicatie.get(i).getId()==id) {
					if(publicatie.get(i).disponibil==true) {
						publicatie.get(i).imprumuta(dataImprumut);
						System.out.println("Publicatia "+id+" a fost imprumutata.");
						break;
					}else {
						throw new Exception();
					}
				}
				if(i==publicatie.size()-1) {
					System.out.println("Publicatia "+id+" nu a fost gasita!");
				}
			}
		}catch(Exception e) {
			System.out.println("Publicatia "+id+" este indisponibila!");
		}
	}	
	
	public void returneazaPublicatie(int id, LocalDate dataRetur) throws Exception{
		try {
			for(int i = 0; i < publicatie.size(); i++) {
				if(publicatie.get(i).getId()==id) {
					if(publicatie.get(i).disponibil==true) {
						throw new Exception("Publicatia "+id+" nu poate fi returnata (nu a fost imprumutata)!");
					}else {
						int termenImprumut=0;
						if(publicatie.get(i) instanceof Carte) {
							termenImprumut=Carte.TERMEN_IMPRUMUT;
						}else {
							if(publicatie.get(i) instanceof Articol){
								termenImprumut=Articol.TERMEN_IMPRUMUT;
							}
						}
						if(ChronoUnit.WEEKS.between(publicatie.get(i).dataImprumut,dataRetur)>=termenImprumut){
							publicatie.get(i).returneaza(dataRetur);
							throw new Exception("Termen depasit pentru publicatia "+id+"!\n"
									+ "Penalizare: "+(publicatie.get(i).calculPenalizare(dataRetur))+" lei");
						}else {
							publicatie.get(i).returneaza(dataRetur);
							System.out.println("Publicatia "+id+" a fost returnata.");
							break;
						}
					
					}
				}
				if(i==publicatie.size()-1) {
					System.out.println("Publicatia "+id+" nu a fost gasita!");
				}
			}	
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			}
	}

	public void publicatiiImprumutate() {
		System.out.println("Publicatii imprumutate:");
		for(Publicatie p : publicatie) {
			if(p.disponibil==false) {
				System.out.println(p);
			}
		}
	}
	

	public void publicatiiDisponibile() {
		System.out.println("Publicatii disponibile:");
		for(Publicatie p : publicatie) {
			if(p.disponibil==true) {
				System.out.println(p);
			}
		}
	}
	
	public void consultarePublicatieDupaCategorie(String categorie) {
		System.out.println("Publicatii din categoria "+"\"" + categorie +  "\":");
		for(int i = 0; i < publicatie.size(); i++) {
			if(publicatie.get(i).getCategorie()==categorie) {
				System.out.println(publicatie.get(i));
			}
		}
	}
	
	public void consultarePublicatieDupaAutor(String autor) {
		System.out.println("Publicatii scrise de "+"\"" + autor +  "\":");
		for(int i = 0; i < publicatie.size(); i++) {
			if(publicatie.get(i).getAutor().equals(autor)) {
				System.out.println(publicatie.get(i));
			}
		}
	}
	
	public void metodaDeTest(){
	//	System.out.println(publicatie.get(3).
	}
	
	protected static Biblioteca getBibliotecaPopulata() {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.adaugaPublicatie(new Carte("Jonathan Coe", "Casa somnului", 1997, CategoriePublicatie.FICTIUNE));
		biblioteca.adaugaPublicatie(new Carte("Anna Gavalda", "Impreuna", 2004, CategoriePublicatie.FICTIUNE));
		biblioteca.adaugaPublicatie(new Articol("Pavel Carol", "Scurta istorie a macaroanelor", CategoriePublicatie.STIINTA, "Good Food", LocalDate.of(2011, 10, 3)));
		biblioteca.adaugaPublicatie(new Articol("John Meyer", "Internetul in mileniul 3", CategoriePublicatie.STIINTA, "The Scientist", LocalDate.of(1999, 12, 1)));
		biblioteca.adaugaPublicatie(new Carte("Neagu Djuvara", "O scurta istorie ilustrata a romanilor", 2013, CategoriePublicatie.ISTORIE));
		biblioteca.adaugaPublicatie(new Carte("Frank Herbert", "Dune", 1965, CategoriePublicatie.SF));
		biblioteca.adaugaPublicatie(new Articol("Francois Auteuil", "Limba franceza a evului mediu", CategoriePublicatie.ISTORIE, "Journal de l'Academie Francaise", LocalDate.of(1867, 6, 17)));
		biblioteca.adaugaPublicatie(new Articol("Ygor Swozkowicz", "Plante farmaceutice", CategoriePublicatie.STIINTA, "British Journal of Natural History", LocalDate.of(1960, 10, 9)));
		biblioteca.adaugaPublicatie(new Carte("Franz Kafka", "Procesul", 1925, CategoriePublicatie.FICTIUNE));
		biblioteca.adaugaMedia(new Film("DVD", "Inglourious Basterds", 2009, CategorieFilm.ACTIUNE, "Quentin Tarantino"));
		biblioteca.adaugaMedia(new Film("Blu-Ray", "Casablanca", 1941, CategorieFilm.DRAMA, "Michael Curtiz"));
		biblioteca.adaugaMedia(new Film("Blu-Ray", "Superbad", 2007, CategorieFilm.COMEDIE, "Greg Mottola"));
		biblioteca.adaugaMedia(new Film("HDDVD", "BD la munte si la mare", 1971, CategorieFilm.COMEDIE, "Mircea Dragan"));
		biblioteca.adaugaMedia(new AlbumMuzica("CD", "Pink Floyd", "The Wall", CategorieMuzica.ROCK));
		biblioteca.adaugaMedia(new AlbumMuzica("Vinil", "Orchestra Filarmonica Viena", "Beethoven - Simfonia nr. 5", CategorieMuzica.CLASICA));
		biblioteca.adaugaMedia(new AlbumMuzica("CD", "Stromae", "Racine Carree", CategorieMuzica.POP));
		biblioteca.adaugaMedia(new AlbumMuzica("CD", "Satyricon", "The Age of Nero", CategorieMuzica.ROCK));
		return biblioteca;
		}
}

