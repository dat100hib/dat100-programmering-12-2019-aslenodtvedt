package no.hvl.dat100.jplab12.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



import no.hvl.dat100.jplab12.oppgave3.*;
import no.hvl.dat100.jplab12.common.TODO;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) {
		String path = MAPPE + filnavn;
		File file = new File(path);
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(samling.toString());
			fileWriter.close();
		} catch (Exception ex) {
			System.out.println("Feilet når vi prøvde å skrive til fil: " + path);
			ex.printStackTrace();
			return false;
		} 
		return true;
		
	}
}
