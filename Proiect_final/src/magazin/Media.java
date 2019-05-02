package magazin;

public abstract class Media extends Item implements Consultabil {
	
	protected String suport;
	
	public Media(String suport) {
		super();
		this.suport = suport;
	}
	
	@Override
	public void consulta() {
		if(disponibil==true) {
			disponibil=false;
		}
	}

	@Override
	public void elibereaza() {
		if(disponibil==false) {
			disponibil=true;
		}
	}
}
