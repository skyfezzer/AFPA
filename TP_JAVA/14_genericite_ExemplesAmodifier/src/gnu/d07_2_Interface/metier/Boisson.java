package gnu.d07_2_Interface.metier;

public class Boisson implements Payable
{
  private String nom;  // Champ memorisant le nom d'une boisson
  private float  prix; // Champ memorisant le prix d'une boisson

  public Boisson (String nom, float prix)
  {
    this.nom  = nom;
    this.prix = prix;
  }

  public String getNom ()
  {
    return this.nom;
  }

  public float getPrix ()
  {
    return this.prix;
  }
}