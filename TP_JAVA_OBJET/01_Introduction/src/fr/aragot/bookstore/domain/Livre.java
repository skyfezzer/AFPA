package fr.aragot.bookstore.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

enum Status{
	DISPONIBLE,EMPRUNTE,SUPPRIME
};

public class Livre implements Comparable<Livre>{

	public static double PRIX_INCONNU = -1.;
	public static double PRIX_GRATUIT = 0.;
	
	private static Comptable comptable = Comptable.getInstance();
	
    private String titre;
    private String auteur;
    private String editeur;
    private int nbPages;
    private double prix;
    private boolean prixFixe;
    private LocalDate dateEmprunt;
    private Status status;
    private TypeDonneesAnnee anneeParution;
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static int countNew;

    // ===== MAIN =====
    public static void main(String[] args) {
    

        
    }

    // ===== CONSTRUCTEURS =====
    public Livre(){
    	this(null);
    }
    
    public Livre(String titre) {
    	this(titre,null);
    }
    
	public Livre(String titre, String auteur) {
    	this(titre,auteur,null);
    }
	
	public Livre(String titre, int nbPages) {
		this(titre,null,null,nbPages);
	}
	
	public Livre(String titre, double prix) {
		this(titre,null,null,prix);
	}
	
	public Livre(String titre, int nbPages, double prix) {
		this(titre,null,nbPages,prix);
	}
	
	public Livre(String titre, String auteur, int nbPages) {
		this(titre,auteur,null,nbPages);
	}
	
	public Livre(String titre, String auteur, String editeur) {
		this(titre,auteur,editeur,PRIX_INCONNU);
	}
	
	public Livre(String titre, String auteur, double prix) {
		this(titre,auteur,null,prix);
	}
	
	public Livre(String titre, String auteur, int nbPages, double prix) {
		this(titre,auteur,null,nbPages,prix);
	}
	
	public Livre(String titre, String auteur, String editeur, double prix) {
		this(titre,auteur,editeur,0,prix);
	}
	
	public Livre(String titre, String auteur, String editeur, int nbPages) {
		this(titre,auteur,editeur,nbPages,PRIX_INCONNU);
	}
	
	public Livre(String titre, String auteur, String editeur, int nbPages, Double prix) {
		this(titre,auteur,editeur,nbPages,prix,false);
	}
	
	public Livre(String titre, String auteur, String editeur, int nbPages, Double prix, boolean prixFixe) {
		this(titre,auteur,editeur,nbPages,prix,prixFixe,Status.DISPONIBLE);
	}
	
	public Livre(String titre, String auteur, String editeur, int nbPages, Double prix, boolean prixFixe, Status status) {
		this(titre,auteur,editeur,nbPages,prix,prixFixe,status,null);
	}
	
	public Livre(String titre, String auteur, String editeur, int nbPages, Double prix, boolean prixFixe, Status status, TypeDonneesAnnee anneeParution) {
		super();
		this.setTitre(titre)
			.setAuteur(auteur)
			.setEditeur(editeur)
			.setNbPages(nbPages)
			.setPrix(prix==null?PRIX_INCONNU:prix)
			.setStatus(status==null?status.DISPONIBLE:status)
			.setAnneeParution(anneeParution);
		comptable.comptabilise(this);
			
		countNew++;
	}

	// ===== METHODES =====
	// ===== GETTERS =====
	public String getTitre() {
		return titre;
	}
	
	public String getAuteur() {
		return auteur;
	}
	
	public String getEditeur() {
		return editeur;
	}
	
	public double getPrix() {		
		return Double.parseDouble(String.format("%.2f", prix).replace(',', '.'));
	}
	
	public static int getCountNew() {
		return countNew;
	}
	
	public int getNbPages() {
		return nbPages;
	}
	
	public boolean isPrixFixe() {
		return prixFixe;
	}
	
	private String getTextePrix() {
		if(prix < 0.) {
			return "Prix inconnu";
		}
		if(PRIX_GRATUIT==prix) {
			return "Gratuit";
		}
		return ""+prix;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public TypeDonneesAnnee getAnneeParution() {
		return this.anneeParution;
	}
	// ===== SETTERS =====

	public boolean isDisponible() {
		return this.status.equals(Status.DISPONIBLE);
	}

	public LocalDate getDateAchat() {
		return dateEmprunt;
	}

	public Livre setAuteur(String auteur) {
		this.auteur = auteur==null?"Auteur inconnu":auteur;
		return this;
	}

	public Livre setTitre(String titre) {
		this.titre = titre==null?"Titre inconnu":titre;
		return this;
	}
	
	public Livre setEditeur(String editeur) {
		this.editeur = editeur==null?"Editeur inconnu":editeur;
		return this;
	}
	
	public Livre setDisponible(boolean dispo) {
		if(dispo) {
			this.status = Status.DISPONIBLE;
		}else {
			this.status = Status.EMPRUNTE;
		}
		return this;
	}

	public Livre setNbPages(int nbPages) {
		if(nbPages < PRIX_INCONNU)
			throw new IllegalArgumentException("Nombre de pages doit être sup. à 0");
		this.nbPages = nbPages;
		return this;
	}	
	
	public Livre setPrix(double prix) {
		if(isPrixFixe()) {
			throw new UnsupportedOperationException("Le prix ne peut être changé qu'une fois.");
		}
		if(prix < PRIX_INCONNU) {
			throw new IllegalArgumentException("Le prix doit être sup. ou égal à 0");
		}
		this.prix = Double.parseDouble(String.format("%.2f", prix).replace(',', '.'));
		this.prixFixe = true;
		return this;
	}

	public Livre setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
		return this;
	}
	
	public Livre setStatus(Status status) {
		this.status = status;
		return this;
	}
	
	public Livre setAnneeParution(TypeDonneesAnnee anneeParution) {
		this.anneeParution = anneeParution;
		return this;
	}
	public Livre setAnneeParution(int anneeParution) {
		this.anneeParution = new TypeDonneesAnnee(anneeParution,this);
		return this;
	}

	// ===== COMPARATEURS =====
	public int compare(Livre l) {
		if(this.getNbPages() < l.getNbPages())
			return -1;
		else if(this.getNbPages() > l.getNbPages())
			return 1;
		else
			return 0;
	}
	
	public static int compare2(Livre l1, Livre l2) {
		if(l1.getNbPages() < l2.getNbPages())
			return -1;
		else if(l1.getNbPages() > l2.getNbPages())
			return 1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return "Livre [titre=" + getTitre() 
				+ ", auteur=" + getAuteur() 
				+ ", editeur=" + getEditeur() 
				+ ", nbPages=" + getNbPages()
				+ ", prix=" + getTextePrix()
				+ ", status=" + status
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nbPages, titre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		return nbPages == other.nbPages && Objects.equals(titre, other.titre);
	}

	@Override
	public int compareTo(Livre o) {
		return compare(o);
	}
	
}
