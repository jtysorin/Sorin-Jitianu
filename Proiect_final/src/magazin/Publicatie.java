package magazin;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public abstract class Publicatie extends Item implements Imprumutabil{
	
	protected String autor;
	protected String titlu;
	protected String categorie;
	protected LocalDate dataImprumut;

	public Publicatie(String autor, String titlu, String categorie) {
		super();
		this.autor = autor;
		this.titlu = titlu;
		this.categorie = categorie;
	}

	public boolean isDisponibil() {
		return true;
	}
	
	public String getAutor() {
		return autor;
	}

	public String getCategorie() {
		return categorie;
	}

	@Override
	public void imprumuta(LocalDate dataImprumut) throws Exception {
			if(disponibil==isDisponibil()) {
				disponibil=false;
				this.dataImprumut = dataImprumut;
			}
	}
	
	@Override
	public void returneaza(LocalDate dataRetur) throws Exception {
		if(disponibil==false) {
			disponibil=isDisponibil();
		}
	}
	
}
