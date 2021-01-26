import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

		public static void main(String[] args) throws FileNotFoundException {
			
			FileProcessing fp = new FileProcessing();
			
			ArrayList <String> s = fp.readFileAsString("readandsortwords.txt");
		     
			Collections.sort(s); // This sorts all the words first
				
			//fp.printToConsole(s); // This prints all sorted words on the console
						
			fp.analizeContent(s); // After all the words are sorted this analyzes and orders all the information 
			
			//fp.printToFile(s); // This prints all the sorted words on a file
			 
			
		}

	}

