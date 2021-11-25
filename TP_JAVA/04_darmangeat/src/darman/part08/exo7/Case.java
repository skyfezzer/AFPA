package darman.part08.exo7;

public class Case {
	private Pion pion;
	
	public Case(Pion p) {
		this.pion = p;
	}
	public Case() {
		this(null);
	}
	
	public Pion getPion() {
		return pion;
	}
	
	public void setPion(Pion p) {
		this.pion = p;
	}
}
