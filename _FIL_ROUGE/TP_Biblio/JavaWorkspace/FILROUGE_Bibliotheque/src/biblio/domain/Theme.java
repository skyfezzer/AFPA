/***********************************************************************
 * Module:  Theme.java
 * Author:  Sk
 * Purpose: Defines the Class Theme
 ***********************************************************************/

package biblio.domain;


/** @pdOid 880a7a76-e034-4bc3-93b2-47ec73ee7d19 */
public class Theme {
	public Theme(String noTheme, String intituleTheme, Theme themeParent) {
		super();
		this.setNoTheme(noTheme);
		this.setIntituleTheme(intituleTheme);
		this.setThemeParent(themeParent);
	}
	public Theme(String noTheme, String intituleTheme){
		this(noTheme, intituleTheme, null);
	}

	/** @pdOid 8c519983-fabb-404e-86db-fd30c2671c7f */
	private String noTheme;
	/** @pdOid d2006ee4-8b7e-4e3d-8bfc-c51b11ecce66 */
	private String intituleTheme;
	private Theme themeParent;

	/**
	 * Un emplacement est attribué pour un Thème. Un thème peut être attribué à 0 ou
	 * plusieurs emplacements.
	 */

	// getters and setters
	public Theme getThemeParent() {
		return themeParent;
	}

	public void setThemeParent(Theme themeParent) {
		this.themeParent = themeParent;
	}
	 
	/**
	 * @return the noTheme
	 */
	public String getNoTheme() {
		return noTheme;
	}

	/**
	 * @param noTheme the noTheme to set
	 */
	public void setNoTheme(String noTheme) {
		this.noTheme = noTheme;
	}

	/**
	 * @return the intituleTheme
	 */
	public String getIntituleTheme() {
		return intituleTheme;
	}

	/**
	 * @param intituleTheme the intituleTheme to set
	 */
	public void setIntituleTheme(String intituleTheme) {
		this.intituleTheme = intituleTheme;
	}
	
	// toString
	@Override
	public String toString() {
		return "Theme [noTheme=" + noTheme + ", intituleTheme=" + intituleTheme + "]";
	}
	

}