package gnu.d07_2_Interface.metier;


public class BoissonAlcoolisee extends Boisson
{
  private int degreAlcool; // Champ memorisant le degre d'alcool d'une boisson alcoolisee

  public BoissonAlcoolisee (String nom, float prix, int degreAlcool)
  {
    // Initialisation de l'objet Boisson
    super (nom, prix);
    // Initialisation de l'objet BoissonAlcoolisee
    this.degreAlcool = degreAlcool;
  }

  public int getDegreAlcool ()
  {
    return this.degreAlcool;
  }
}