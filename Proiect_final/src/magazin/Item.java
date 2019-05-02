package magazin;

public abstract class Item {

	private int id;
	private static int numarPozitie;
	protected boolean disponibil = true;
	
	public Item() {
		++numarPozitie;
		id=numarPozitie;
	}
	
	public int getId() {
		return id;
		}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
