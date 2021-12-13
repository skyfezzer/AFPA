package fr.aragot.bookshop.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Livre {

    private String titre;
    private String auteur;
    private String editeur;
    private int nbPages;
    private boolean disponible;
    private LocalDate dateEmprunt;

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static int countNew;

    public static void main(String[] args) {
        Livre m_Livre = new Livre();
        System.out.println(m_Livre);
    }

    public Livre(){
    	this(null);
    }
    
    public Livre(String titre) {
    	this(titre,null);
    }

	public Livre(String titre, String auteur) {
    	this(titre,auteur,null);
    }
    
    public Livre(String titre, String auteur, String editeur) {
    	this(titre,auteur,editeur,0);
    }
    
    public Livre(String titre, String auteur, String editeur, int nbPages) {
    	this(titre,auteur,editeur,nbPages,null);
    }
    
    public Livre(String titre, String auteur, String editeur, int nbPages, LocalDate dateEmprunt) {
    	this(titre,auteur,editeur,nbPages,dateEmprunt,false);
    }
    
	public Livre(String titre, String auteur, String editeur, int nbPages, LocalDate dateEmprunt, boolean disponible) {
		super();
		this.setTitre(titre);
		this.setAuteur(auteur);
		this.setEditeur(editeur);
		this.setNbPages(nbPages);
		this.setDateEmprunt(dateEmprunt);
		this.setDisponible(disponible);
		countNew++;
	}

	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", auteur=" + auteur + ", editeur=" + editeur + ", nbPages=" + nbPages
				+ ", disponible=" + disponible + ", dateEmprunt=" + dateEmprunt + "]";
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre==null?"Titre inconnu":titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur==null?"Auteur inconnu":auteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur==null?"Editeur inconnu":editeur;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		if(nbPages < 0)
			throw new IllegalArgumentException("Nombre de pages doit être sup. à 0");
		this.nbPages = nbPages;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	
	public static int getCountNew() {
		return countNew;
	}
	
	
}
