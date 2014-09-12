package so.yang.wordsearch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new WordSearch().startApp();
	}
	
	String fileName;
	String word;
	Scanner myScanner;
	MyQueue myQueue;
	
	public WordSearch()
	{
		myQueue = new MyQueue(3);
	}
	/**
	 * Main logic behind the screen, two JOptionPane: fileName and word.
	 */
	public void startApp()
	{
		do{
			fileName = JOptionPane.showInputDialog(null, "What is your file name?");
			myScanner = this.getFileScannerFromString(fileName);
		}while(myScanner == null);
		
		//
		word = JOptionPane.showInputDialog(null, "In "+ fileName +"\nWhich word you want to search?");
	}
	
	/**
	 * Precondition: 
	 * @param fileName we expect this file exist.
	 * @return scanMyFile this may be none
	 */
	private Scanner getFileScannerFromString(String fileName)
	{
		Scanner scanMyFile = null;
		try {
			FileReader myFile = new FileReader(fileName);
			scanMyFile = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scanMyFile;
		
	}
	
	private String searchFileUseScanner(Scanner scanner)
	{
		while(scanner.hasNext()){
			myQueue.enqueue(scanner.next());
			
		}
		
		return null;
		
	}

}
