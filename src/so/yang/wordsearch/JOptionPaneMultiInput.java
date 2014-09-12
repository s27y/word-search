package so.yang.wordsearch;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JOptionPaneMultiInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	JPanel myPanel = new JPanel();
	JTextField filenameField = new JTextField(15);
	JTextField wordField = new JTextField(15);

	public JOptionPaneMultiInput() {
		this.initJPanel();
	}
	
	/**
	 * Initialise JPanel with all necessary components
	 */
	private void initJPanel() {
		
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
		myPanel.add(new JLabel("Please enter:"));
		myPanel.add(new JLabel("File name:"));
		myPanel.add(filenameField);
		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		myPanel.add(new JLabel("Word:"));
		myPanel.add(wordField);
	}
	/**
	 * Display pane
	 */
	public void showPane()
	{
		int result = JOptionPane.showConfirmDialog(null, myPanel,
				"Please Enter X and Y Values", JOptionPane.OK_OPTION);
	}

}
