package so.yang.numbersearch;

import java.util.Scanner;

import javax.swing.JOptionPane;

import so.yang.wordsearch.util.DAO;
import so.yang.wordsearch.util.MyQueue;

public class NumberSearch {

	public static void main(String[] args) {
		new NumberSearch().startApp();
	}
	
	String fileName;
	MyQueue myQueue;
	Scanner myScanner;
	String result;
	
	public NumberSearch()
	{
		myQueue = new MyQueue(3);
	}
	
	
	/**
	 * two JOptionPane: fileName and word.
	 */
	public void startApp() {

		do {
			fileName = JOptionPane.showInputDialog(null,
					"What is your file name?", "cakeQuestion.txt");
			myScanner = DAO.getFileScannerFromString(fileName);
		} while (myScanner == null);

		result = this.findAllNumberInFile();
		if (result.length() < 6) {
			result = "There is no number in the file: " + fileName;
		}
		JOptionPane.showConfirmDialog(null, result);
		System.exit(0);
	}
	
	/**
	 * Find all number  in the file
	 * 
	 * @return the result
	 */
	private String findAllNumberInFile() {
		StringBuilder sb = new StringBuilder();
		boolean isLastElementTarget = false;
		while (myScanner.hasNext()) {
			String aString = myScanner.next();
			myQueue.enqueue(aString);

			if (isLastElementTarget) {
				sb.append(myQueue.toString(" ") + "\n");
				isLastElementTarget = false;
			} else if (isStringParsableToInt(aString)) {
				isLastElementTarget = true;
			} else if(isStringParsableToDouble(aString)) {
				isLastElementTarget = true;
			}
			
		}
		return sb.toString();
	}
	
	
	private boolean isStringParsableToInt(String str) {
		boolean flag = true;
		try {
			int i = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			flag = false;
		}

		return flag;
	}
	private boolean isStringParsableToDouble(String str){
		boolean flag = true;
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			flag = false;
		}

		return flag;
	}
	
}
