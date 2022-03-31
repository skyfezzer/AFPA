package metier;


public class Sport
{
	private int idS;
	private String libelle;
	private String nomEntraineur;
	
	//CONSTRUCTEURS
	//Constructeur sans le passage de la clef
	public Sport(String libelle, String nomEntraineur) {
		this.setLibelle(libelle);
		this.setNomEntraineur(nomEntraineur);
	}
	public Sport(String libelle){
		this( libelle, "inconnu");
	}
	public Sport(){}

	//REDEFINITION DE toString()
	public String toString()
	{
		return "id :" + idS + " libelle :<" + libelle + ">" + " entraineur :<" + nomEntraineur +">";
	}
	
	
	// GETTEURs ET SETTEURs
	public String getNomEntraineur() {
		return nomEntraineur;
	}
	public void setNomEntraineur(String nomEntraineur) {
		this.nomEntraineur = nomEntraineur;
	}

	public int getIdS() {
		return idS;
	}
	private void setIdS(int idS) {
		this.idS = idS;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelleS) {
		this.libelle = libelleS;
	}

	public static void main(String[] args) {
		System.out.println("\nLISTE DES SPORTS :");
		System.out.println("-----------------------");
		System.out.println(new Sport("Equitation", "Dupont"));
		System.out.println(new Sport("Natation", "Dubois"));
		System.out.println(new Sport("Boxe", "Durant"));
		
	}

}
