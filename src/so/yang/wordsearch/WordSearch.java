package so.yang.wordsearch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

import so.yang.wordsearch.util.DAO;
import so.yang.wordsearch.util.MyQueue;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new WordSearch().startApp();
	}

	String fileName;
	String word;
	MyQueue myQueue;
	Scanner myScanner;
	String result;

	public WordSearch() {
		myQueue = new MyQueue(3);
	}

	/**
	 * two JOptionPane: fileName and word.
	 */
	public void startApp() {

		do {
			fileName = JOptionPane.showInputDialog(null,
					"What is your file name?", "myNovel.txt");
			myScanner = DAO.getFileScannerFromString(fileName);
		} while (myScanner == null);

		//
		word = JOptionPane.showInputDialog(null, "In " + fileName
				+ "\nWhich word you want to search?", "I");

		result = this.searchWordInFile(word);
		if (result.length() < 6) {
			result = "There is no such word in the file: " + fileName;
		}
		JOptionPane.showConfirmDialog(null, result);
		System.exit(0);
	}

	

	/**
	 * Search a word in the file
	 * 
	 * @param word
	 * @return the result
	 */
	private String searchWordInFile(String word) {
		StringBuilder sb = new StringBuilder();
		boolean isLastElementTarget = false;
		while (myScanner.hasNext()) {
			String aString = myScanner.next();
			myQueue.enqueue(aString);
			System.out.println(myQueue.toString(" "));

			if (isLastElementTarget) {
				// System.out.println("Found one");
				sb.append(myQueue.toString(" ") + "\n");
				isLastElementTarget = false;
			} else if (aString.equals(this.word)) {
				isLastElementTarget = true;
			}
		}
		return sb.toString();
	}

}
