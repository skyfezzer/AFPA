package fr.aragot.main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class WriteInfos {

	static Properties properties = null;
	public static void main(String[] args) {
		
		Path file = null;
		try {
			file = Path.of(ClassLoader.getSystemResource("infos.properties").toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		properties = System.getProperties();
		writeInfos(file.toFile());
		System.out.println("Done.");
	}

	private static void writeInfos(File file) {
		
		try (Writer writer = new FileWriter(file)) {
			properties.store(writer, "test");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readInfos(File file) {
		try (Reader reader = new FileReader(file)) {
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
