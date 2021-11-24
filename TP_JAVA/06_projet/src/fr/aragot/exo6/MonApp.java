package fr.aragot.exo6;

public class MonApp {
	// Constante pour d�clarer si l'on veut chercher un caract�re COMPOSANT une variable ou COMMENCANT une variable.
	private static final boolean STARTING_IDENTIFIER_ONLY = false;
	
	public static void main(String[] args) {
		// On r�cup�re tous les caract�res ascii dans un string.
		char[] tableASCII = getAllASCIIChars();
		System.out.printf("Liste des caract�res pouvant %sune variable :\n",STARTING_IDENTIFIER_ONLY?"commencer ":"faire partie d'");
		System.out.println("DISPLAY\tHEX\tVAL");
		
		// Pour chacun des caract�res dans la table ASCII
		int cpt = 0;
		for(Character c : tableASCII) {
			// Selon la constante d�clar�e en t�te du fichier, on va chercher soit "JavaIdentifierPART" soit "JavaIdentifierSTART"
			if(STARTING_IDENTIFIER_ONLY?Character.isJavaIdentifierStart(c):Character.isJavaIdentifierPart(c)) {
				// Formatage pour l'affichage en tableau dans la console.
				System.out.printf("%s\t%s\t%d\t| "
									// Si le caract�re n'est pas affichable, affiche "ND?" (Ne devrait jamais arriver)
									,Character.isISOControl(c)?"ND?":c
									// Valeur HEX sous forme 0x00
									,"0x" + Integer.toHexString(c)
									// Valeur num�rique du caract�re
									,(int)c
								);
				cpt++;
				if(cpt%4==0) {
					System.out.println();
				}
			}
		}
		
	}
	
	private static char[] getAllASCIIChars() {
		char[] result = new char[127];
		// Table ASCII jusqu'� 127
		for( var i = 0; i <= 126; i++ )
		{
			// R�cup�re le caract�re qui a pour valeur i, et l'ajoute � String s.
		    result[i] = (char)i;
		}
		return result;
	}

}

