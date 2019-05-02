package magazin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Articol extends Publicatie{

	public static int TERMEN_IMPRUMUT=2;
	public static double PENALIZARE=0.1;
	protected String publicatie;
	protected LocalDate dataPublicatie;
	
	public Articol(String autor, String titlu, String categorie, String publicatie, LocalDate dataPublicatie) {
		super(autor, titlu, categorie);
		this.publicatie=publicatie;
		this.dataPublicatie=dataPublicatie;
	}
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY"); 
	
	@Override
	public String toString() {
		return getId()+". " +autor+ "\t" +titlu+ "\t" +publicatie+ "\t" +  formatter.format(dataPublicatie);
	}
	
	@Override
	public double calculPenalizare(LocalDate dataRetur) {
		return PENALIZARE*(ChronoUnit.DAYS.between(dataImprumut,dataRetur)-7*TERMEN_IMPRUMUT);
	}

}
