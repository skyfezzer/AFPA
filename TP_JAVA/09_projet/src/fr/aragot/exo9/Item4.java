package fr.aragot.exo9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item4 {

	public static void main(String[] args) {
		String regex = "(?<prot>\\S+):\\/\\/(?<server>\\S*?)\\/(?<file>.+)";
		String url;
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une URL > ");
		url = sc.nextLine();
		sc.close();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);
		while(matcher.find()) {
			System.out.printf("Protocole : %s\n",matcher.group("prot"));
			System.out.printf("Serveur : %s\n",matcher.group("server"));
			System.out.printf("Fichier : %s\n",matcher.group("file"));
		}
	}
	

}
