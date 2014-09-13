package so.yang.wordsearch.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DAO {
	/**
	 * Precondition:
	 * 
	 * @param fileName
	 *            we expect this file exist.
	 * @return scanMyFile this may be none
	 */
	public static Scanner getFileScannerFromString(String fileName) {
		Scanner scanMyFile = null;
		try {
			FileReader myFile = new FileReader(fileName);
			scanMyFile = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

		}
		return scanMyFile;
	}
}
