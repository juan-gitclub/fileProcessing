
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import static java.util.stream.Collectors.*;

public class FileProcessing {
	
	public ArrayList<String> readFileAsString(String fileName) {

		ArrayList<String> list = new ArrayList<String>();

		try {
			File file = new File(fileName);
			Scanner sc = new Scanner(file);

			while (sc.hasNext()) {

				list.add(sc.next());
			}

			list.replaceAll(String::toLowerCase); // Here I turned all the words from the list to lower cases so they could be sorted properly 

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return list;

	}

	public void analizeContent(ArrayList<String> list) {

		Map<String, Integer> wordsAnalysis = new HashMap<>();

		String temp1 = " ";
		Integer count = 0;

		for (String temp : list) { // This loop would determine whether a word is repited or not

			temp = temp.replaceAll("[”â€.,:;()?!\" \t\n\r\']+", ""); // Here I replaced all the unwanted characters and cleaned the inserted words

			if (temp1.equals(temp)) {

				count++;

			} else {

				wordsAnalysis.put(temp1, count);
				temp1 = temp;
				count = 1;
			}

		}

		Map<String, Integer> sortedMap = wordsAnalysis.entrySet().stream() // Here I sorted all the values per key from higher to lower
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				   .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		for (String words : sortedMap.keySet()) { // Here I formated the printing out so the output is understandable
			  String key = words.toString();
			    String value = sortedMap.get(words).toString();
			      System.out.println("The word \"" + key + "\" was mentioned: " + value + " times.");
		}

	}

	public void printToFile(ArrayList<String> list) {

		try {

			FileOutputStream fileByteStream = null;
			PrintWriter outFS = null;

			fileByteStream = new FileOutputStream("sortedWords.txt");
			outFS = new PrintWriter(fileByteStream);

			for (String temp : list) {

				outFS.println(temp);

			}

			outFS.flush();
			outFS.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void printToConsole(ArrayList<String> list) {

		for (String temp : list) {
			System.out.println(temp);

		}

	}

}