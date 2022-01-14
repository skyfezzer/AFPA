package fr.aragot.webmail;

import java.nio.charset.Charset;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Charset.availableCharsets();
		for(Map.Entry<String,Charset> e : Charset.availableCharsets().entrySet()) {
			System.out.println(e.getKey() + " - " + e.getValue().displayName());
		}
	}
}
