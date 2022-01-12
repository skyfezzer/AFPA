//Source file: E:\\22_ETUDE_CONCEPTOBJET_UMLDiagDeClasse__CUs__ROSE\\269_DEMO_20211222_Rose_PresentationDesDiagrammes_saufCU_LesCommandes\\java\\commande\\domain\\TypeAge.java

package commande.domain;


/**
 * {age >=0 and ag<130}
 */
public class TypeAge 
{
   private Integer age;
   
   /**
    * @roseuid 61D415850322
    */
   public TypeAge(Integer age) 
   {
    this.age = age;
   }

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}
   
}
