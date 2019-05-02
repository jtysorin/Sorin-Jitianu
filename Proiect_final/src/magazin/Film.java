package magazin;

public class Film extends Media{
	
	protected String titlu;
	protected int an;
	protected String gen;
	protected String regizor;

	public Film(String suport, String titlu, int an, String gen, String regizor) {
		super(suport);
		this.titlu = titlu;
		this.an = an;
		this.gen = gen;
		this.regizor = regizor;
	}	
	
	@Override
	public String toString() {
		return +getId()+". "+suport+ "\t" + titlu + "\t" + an + "\t" + gen + "\t" + regizor;
	}

}
