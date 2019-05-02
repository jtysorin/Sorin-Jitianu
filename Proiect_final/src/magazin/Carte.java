package magazin;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Carte extends Publicatie{
	
	public static int TERMEN_IMPRUMUT=4;;
	public static double PENALIZARE=0.5;
	protected int anPublicatie;

	public Carte(String autor, String titlu, int anPublicatie, String categorie) {
		super(autor, titlu, categorie);
		this.anPublicatie=anPublicatie;
	}

	@Override
	public String toString() {
		return getId()+". " +autor+ "\t" +titlu+ "\t" + anPublicatie + "\t"+categorie;
	}
	
	@Override
	public double calculPenalizare(LocalDate dataRetur) {
		return PENALIZARE*(ChronoUnit.DAYS.between(dataImprumut,dataRetur)-7*TERMEN_IMPRUMUT);
	}
	
}
