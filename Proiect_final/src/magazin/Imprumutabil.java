package magazin;

import java.time.LocalDate;

public interface Imprumutabil {
	
	public void imprumuta(LocalDate dataImprumut) throws Exception;
	public void returneaza(LocalDate dataRetur) throws Exception;
	public double calculPenalizare(LocalDate dataRetur);
}
