package fr.aragot.bookstore.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Utilisateur est un utilisateur du bookstore.
 * Il d�rive de la classe {@link Personne} 
 * @author Alexis RAGOT
 *
 */
public class Utilisateur extends Personne {
	
	/** Le(s) {@link Livre}(s) potentiellement emprunt�(s) par l'utilisateur */
	private ArrayList<Livre> livres = new ArrayList<>();
	/** L'identifiant interne a l'utilisateur */
	protected String id;
	/** En jours, la dur�e maximale d'un emprunt */
	private static int dureeMaxPret = 15;
	/** Nbr maximum de livres empruntable pour un utilisateur */
	private static int nbMaxPrets = 5;
	private static DateTimeFormatter dtf;
	/** Un compteur auto-incr�ment� qui sert � g�n�rer l'identifiant de l'utilisateur s'il n'est pas sp�cifi�. */
	private static int compteur = 0;
	
	// ===== CONSTRUCTEURS =====
	public Utilisateur() {
		this(null,null);
	}
	
	/**
	 * Constructeur de la classe Utilisateur
	 * @param nom Le nom propre de la {@link Personne} 
	 * @param prenom Le pr�nom de la {@link Personne} 
	 */
	public Utilisateur(String nom, String prenom) {
		this(nom,prenom,String.valueOf(compteur++));
	}
	/**
	 * Constructeur de la classe Utilisateur
	 * @param nom Le nom propre de la {@link Personne} 
	 * @param prenom Le pr�nom de la {@link Personne} 
	 * @param id Identifiant pour le r�f�rencement en interne
	 */
	public Utilisateur(String nom, String prenom, String id) {
		this(nom,prenom,id,null);
	}
	
	/**
	 * Constructeur de la classe Utilisateur
	 * @param nom Le nom propre de la {@link Personne} 
	 * @param prenom Le pr�nom de la {@link Personne} 
	 * @param livre Le {@link Livre} emprunt�
	 */
	public Utilisateur(String nom, String prenom, Livre livre) {
		this(nom,prenom,String.valueOf(compteur++),livre);
	}
	
	/**
	 * Constructeur de la classe Utilisateur
	 * @param nom Le nom propre de la {@link Personne} 
	 * @param prenom Le pr�nom de la {@link Personne} 
	 * @param id Identifiant pour le r�f�rencement en interne
	 * @param livre Le livre emprunt�
	 */
	public Utilisateur(String nom, String prenom, String id, Livre livre) {
		this(nom,prenom,String.valueOf(compteur++),livre,LocalDate.now());
	}
	
	/**
	 * Constructeur de la classe Utilisateur
	 * @param nom Le nom propre de la {@link Personne} 
	 * @param prenom Le pr�nom de la {@link Personne} 
	 * @param livre Le {@link Livre} emprunt�
	 * @param dateEmprunt La date � laquelle le livre a �t� emprunt�
	 */
	public Utilisateur(String nom, String prenom, Livre livre, LocalDate dateEmprunt) {
		this(nom,prenom,String.valueOf(compteur++),livre,dateEmprunt);
	}
	
	/**
	 * Constructeur de la classe Utilisateur
	 * @param nom Le nom propre de la {@link Personne} 
	 * @param prenom Le pr�nom de la {@link Personne} 
	 * @param id Identifiant pour le r�f�rencement en interne
	 * @param livre Le {@link Livre} emprunt�
	 * @param dateEmprunt La date � laquelle le livre a �t� emprunt�
	 */
	public Utilisateur(String nom, String prenom,  String id, Livre livre, LocalDate dateEmprunt) {
		super();
		((Utilisateur)this.setNom(nom)
			.setPrenom(prenom))
			.setIdUtilisateur(id);
		if(livre!=null) {
			this.addLivre(livre);
		}
		
	}
	// ===== METHODES =====
	
	public boolean isConditionsPretAcceptees() {
		boolean cond2 = getNbRetards() == 0;
		boolean cond1 = findAllLivres().size() < nbMaxPrets;
		return cond1 && cond2;
	}
	
	/**
	 * Retourne le nombre de livres dont le pr�t est en retard.
	 * @return un {@code int} repr�sentant nombre de livres dont le pr�t est en retard.
	 */
	public int getNbRetards() {		
		return (int) livres.stream().filter(x->isPretEnRetard(x)).count();
	}
	
	/**
	 * Retourne un bool�en {@code true} si l'utilisateur poss�de en emprunt le livre pass� en param�tre.
	 * @param livre
	 * @return {@code true} si la liste des livres emprunt�s par l'utilisateur contient le {@link Livre} pass� en param.
	 */
	public boolean containsLivre(Livre livre) {
		return livres.contains(livre);
	}
	
	/**
	 * Supprime le livre pass� en param�tre de la liste des livres emprunt�s, si l'utilisateur l'a bien emprunt�.
	 * @param livre Le {@link Livre} � supprimer
	 * @return Une r�f�rence vers l'objet
	 */
	public Utilisateur removeLivre(Livre livre) {
		livres.remove(livre);
		return this;
	}
	
	/**
	 * Retourne le premier livre contenant dans son titre le {@code String} pass� en param�tre.
	 * @param titre Le titre du livre � chercher
	 * @return Le premier {@link Livre} contenant dans son titre {@code titre}
	 */
	public Livre findLivreByTitre(String titre) {
		return livres.stream().filter(l -> l.getTitre().contains(titre)).findFirst().orElse(null);
	}
	
	/**
	 * Getter de l'attribut {@code livres}
	 * @return ArrayList<{@link Livre}> la liste des livres emprunt�s
	 */
	public ArrayList<Livre> findAllLivres() {
		return livres;
	}

	/**
	 * Permet de calculer si l'emprunt a d�pass� le temps autoris�.
	 * @return {@code true} si la date d'emprunt d�passe le temps autoris� pour l'utilisateur
	 * 
	 */
	private boolean isPretEnRetard(Livre livre) {
		if(livre==null || livre.getDateEmprunt() == null) {
			return false;
		}
		return livre.getDateEmprunt().plusDays(dureeMaxPret).isBefore(LocalDate.now());
	}

	/**
	 * Retourne la dur�e maximale d'un pr�t � l'utilisateur
	 * @return un {@code int} repr�sentant la dur�e maximale d'un pr�t
	 */
	public static int getDureeMaxPret() {
		return dureeMaxPret;
	}

	/** Ajoute un livre � la liste des livres emprunt�s par l'utilisateur
	 * Modifie en m�me temps le status du livre et son emprunteur.
	 * @param livre le livre � emprunter
	 * @return Une r�f�rence vers l'objet
	 */
	public Utilisateur addLivre(Livre livre) {
		if(this.livres.size() > Utilisateur.nbMaxPrets) {
			throw new BiblioException("L'utilisateur ne peut pas emprunter plus de livres");
		}
		if(livre != null) {
			livre.setStatus(Status.EMPRUNTE);
			livre.setEmprunteur(this);
		}
		livres.add(livre);
		return this;
	}

	/**
	 * Retourne l'identifiant interne de l'utilisateur
	 * @return l'identifiant interne de l'utilisateur
	 */
	public String getIdUtilisateur() {
		return id;
	}

	/**
	 * Change l'identifiant interne de l'utilisateur
	 * @param id Le nouvel identifiant � attribuer
	 * @return Une r�f�rence vers l'objet
	 */
	public Utilisateur setIdUtilisateur(String id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Vide proprement la liste des livres emprunt�s, en modifiant chaque attribut de chaque livre.
	 * @return Une r�f�rence vers l'objet
	 */
	public Utilisateur clearLivres() {
		this.livres.forEach(livre->{
			if(livre!=null) {
				livre.setEmprunteur(null);
				livre.setStatus(Status.DISPONIBLE);
			}
		});
		livres.removeAll(livres);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Utilisateur %s %s (%s) a emprunt� :\n", this.getNom(),this.getPrenom(),this.getIdUtilisateur()));
		if(livres.isEmpty()) {
			return sb.append("\t aucun livre.").toString();
		}
		livres.forEach(x->sb.append("\t" + x + "\n"));
		return sb.toString();
	}
	
	
	
	
}
