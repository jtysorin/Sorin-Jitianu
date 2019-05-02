package magazin;

import java.time.LocalDate;

import categorii.CategoriePublicatie;

public class App {

	public static void main(String[] args) throws Exception {

		Biblioteca biblioteca = Biblioteca.getBibliotecaPopulata();
		
		System.out.println("Cazul 1:");
//		biblioteca.catalogPublicatii();
//		biblioteca.imprumutaPublicatie(3, LocalDate.of(2017, 12, 20));
//		biblioteca.returneazaPublicatie(3, LocalDate.of(2018, 1, 3));
		
		System.out.println();
		System.out.println("Cazul 2:");
		
//		biblioteca.imprumutaPublicatie(3, LocalDate.of(2017, 12, 20));
//		biblioteca.publicatiiImprumutate();
//		biblioteca.returneazaPublicatie(4, LocalDate.of(2018, 1, 3));
		
		System.out.println();
		System.out.println("Cazul 3:");
		
//		LocalDate data = LocalDate.of(2017, 11, 1);
//		biblioteca.imprumutaPublicatie(1, data);
//		biblioteca.imprumutaPublicatie(2, data);
//		biblioteca.imprumutaPublicatie(3, data);
//		biblioteca.imprumutaPublicatie(4, data);
//		biblioteca.imprumutaPublicatie(5, data);
//		biblioteca.publicatiiDisponibile();
		
		System.out.println();
		System.out.println("Cazul 4:");
		
		biblioteca.imprumutaPublicatie(3, LocalDate.of(2017, 12, 1));
		biblioteca.publicatiiImprumutate();
		biblioteca.returneazaPublicatie(3, LocalDate.of(2018, 2, 2));
		
		System.out.println();
		System.out.println("Cazul 5:");
		
//		biblioteca.consultarePublicatieDupaCategorie(CategoriePublicatie.FICTIUNE);
//		biblioteca.imprumutaPublicatie(2, LocalDate.now());
//		biblioteca.imprumutaPublicatie(2, LocalDate.now());
		
		System.out.println();
		System.out.println("Cazul 6:");
		
		biblioteca.consultarePublicatieDupaAutor("Neagu Djuvara");
		biblioteca.imprumutaPublicatie(10, LocalDate.now());
		biblioteca.returneazaPublicatie(11, LocalDate.now());
		
		System.out.println();
		System.out.println("Cazul 7:");
		
		biblioteca.imprumutaPublicatie(1, LocalDate.of(2017, 12, 10));
		biblioteca.returneazaPublicatie(1, LocalDate.of(2017, 1, 3));
		biblioteca.imprumutaPublicatie(2, LocalDate.of(2018, 1, 1));
		biblioteca.returneazaPublicatie(2, LocalDate.of(2018, 3, 1));
		
		System.out.println();
		System.out.println("Cazul 8:");
		
		biblioteca.catalogMedia();
		biblioteca.consultaMedia(10);
		biblioteca.elibereazaMedia(10);
		
		System.out.println();
		System.out.println("Cazul 9:");
		
		biblioteca.consultaMedia(20);
		biblioteca.elibereazaMedia(21);
		
		System.out.println();
		System.out.println("Cazul 10:");
		
		biblioteca.consultaMedia(14);
		biblioteca.elibereazaMedia(15);
		biblioteca.consultaMedia(16);
		biblioteca.elibereazaMedia(16);
	}
}
