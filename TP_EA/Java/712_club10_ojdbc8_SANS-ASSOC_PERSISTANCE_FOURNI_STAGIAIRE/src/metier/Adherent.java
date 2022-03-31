package metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Adherent
{
	private int idA;
	private String nom;
	private String prenom;
	private Date dateNaiss;
	private String libelleSport;

	//CONSTRUCTEURS
	//Constructeur sans le passage de la clef
	public Adherent(String nom, String prenom, Date dateNaiss, String libelleSport) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setDateNaiss(dateNaiss);
		this.setLibelleSport(libelleSport);
	}
	
	public Adherent(String nom, String prenom, Date dateNaiss)
	{
		this(nom,  prenom,  dateNaiss, "inconnu");
//		this.setNom(nom);
//		this.setPrenom(prenom);
//		this.setDateNaiss(dateNaiss);
//		this.libelleSport = "inconnu";
	}

	public Adherent(){	}


	//REDEFINITION DE toString()
	public String toString()
	{
		return idA + " nom :<" +nom+ "> prenom :<" +prenom+ "> dateNaiss :" +dateNaiss + " sport :<" + libelleSport +">";
	}
	
	//GETTEURs SETTEURs
	public String getLibelleSport() {
		return libelleSport;
	}
	public void setLibelleSport(String libelleSport) {
		this.libelleSport = libelleSport;
	}
	
	public int getIdA() {
		return idA;
	}
	private void setIdA(int idA) {
		this.idA = idA;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nomA) {
		this.nom = nomA;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenomA) {
		this.prenom = prenomA;
	}
	public Date getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(Date dateNaissA) {
		this.dateNaiss = dateNaissA;
	}
	public static void main(String[] args) throws ParseException {
		System.out.println("\nLISTE DES Adherents :");
		System.out.println("-----------------------");
		System.out.println(new Adherent("Bichon","Simone", new SimpleDateFormat("dd/mm/yyyy").parse("04/03/1981"),"Equitation"));
		System.out.println(	new Adherent("Abicol","Nicole",new SimpleDateFormat("dd/mm/yyyy").parse("15/12/1951"),"Equitation"));
		System.out.println(	new Adherent("Dupuis","Gary",new SimpleDateFormat("dd/mm/yyyy").parse("17/10/2000"),"Natation"));
		
	}

}
