package fr.aragot.main;

import java.util.Properties;

public class MainApp {

	public static void main(String[] args) {
		Properties properties = System.getProperties();
		
		System.out.println("Informations sur le système d'exploitation");
		properties.entrySet().stream().filter(x -> ((String)x.getKey()).contains("os.")).forEach(System.out::println);
		
		System.out.println("\nInformations sur la machine virtuelle java :");
		properties.entrySet().stream().filter(x -> ((String)x.getKey()).contains("java.vm.")).forEach(System.out::println);
		
		System.out.println("\nInformations sur la machine virtuelle java :");
		properties.entrySet().stream().filter(x -> ((String)x.getKey()).contains("user.")).forEach(System.out::println);
		
		
		// OLD WAY :
		/*for(Entry<Object, Object> entry : properties.entrySet()) {
			String key = (String)entry.getKey();
			String value = (String)entry.getValue();
			if(key.contains("os.")) {
				System.out.println(entry);
			}
			
		}
		// ...
		*/

	}
	
	

}
