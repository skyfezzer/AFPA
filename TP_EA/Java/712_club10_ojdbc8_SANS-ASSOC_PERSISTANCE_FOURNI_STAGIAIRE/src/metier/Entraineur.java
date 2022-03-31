package metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Entraineur
{
	private int idE;
	private String nom;
	private String prenom;
	private Date dateEmb;
	
	//CONSTRUCTEURS
	//Constructeur sans le passage de la clef
	public Entraineur(String nom, String prenom, Date dateEmb)
	{
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setDateEmb(dateEmb);
	}
	public Entraineur(){ }
	
	//REDEFINITION DE toString()
	public String toString()
	{
		return "id :"+idE + " nom :<" + nom + "> prenom :<" + prenom + "> dateEmb :" + dateEmb;
	}
	
	//GETTEURs SETTEURs
	public int getIdE() {
		return idE;
	}
	@SuppressWarnings("unused")
	private void setIdE(int idE) {
		this.idE = idE;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nomE) {
		this.nom = nomE;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenomE) {
		this.prenom = prenomE;
	}
	public Date getDateEmb() {
		return dateEmb;
	}
	public void setDateEmb(Date dateEmbE) {
		this.dateEmb = dateEmbE;
	}
	
	public static void main(String[] args) throws ParseException {

	System.out.println("\nLISTE DES ENTRAINEURS :");
	System.out.println("-----------------------");
	System.out.println(new Entraineur("Dupont","Jean", new SimpleDateFormat("dd/MM/yyyy").parse("15/10/2005")));
	System.out.println(new Entraineur("Dubois","Marie",new SimpleDateFormat("dd/mm/yyyy").parse("16/12/1995")));
	System.out.println(new Entraineur("Durant","Patrick",new SimpleDateFormat("dd/mm/yyyy").parse("04/05/2000")));

	}
	
}
