package gnu.d07_2_Interface.metier;


/**
 * Service avec un intitule et un prix.
 */
public class Service implements Payable
{
  private java.lang.String intitule; // Champ memorisant l'intitule du service
  private float            prix;     // Champ memorisant le prix du service

  /**
   * Initialise un service avec son intitule.
   */
  public Service (java.lang.String intitule, float prix)
  {
    this.intitule = intitule; // Modifie le champ intitule avec le parametre intitule
    this.prix     = prix;     // Modifie le champ prix avec la valeur en parametre
  }
  /**
   * Renvoie l'intitule de ce service.
   */
  public java.lang.String getIntitule()
  {
    return this.intitule;
  }

  /**
   * Modifie le prix de ce service.
   */
  public void setPrix(float prix)
  {
    this.prix = prix;
  }

  /**
   * Renvoie le prix de ce service.
   */
  public float getPrix()
  {
    return this.prix;
  }
}
