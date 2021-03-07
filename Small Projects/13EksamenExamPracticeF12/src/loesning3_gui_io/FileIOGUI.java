package loesning3_gui_io;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileIOGUI extends JFrame {
	private JRadioButton txtRadio;
	private JRadioButton objRadio;
	private ButtonGroup bg;

	private JButton writeButton;
	private JButton readButton;
	private JTextField inputText;
	private JTextArea outputText;


	public FileIOGUI(String title) {
		super(title);
		makeComponents();
	}

	private void makeComponents() {
		this.setLayout(new BorderLayout());

		txtRadio = new JRadioButton("Text", true);
		objRadio = new JRadioButton("Object", false);
		bg = new ButtonGroup();
		bg.add(txtRadio);
		bg.add(objRadio);

		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.setBorder(BorderFactory.createTitledBorder("File"));
		radioPanel.add(txtRadio);
		radioPanel.add(objRadio);
		this.add(radioPanel, BorderLayout.EAST);

		inputText = new JTextField(12);
		inputText.setBorder(BorderFactory.createTitledBorder("Input: "));
		this.add(inputText, BorderLayout.NORTH);

		outputText = new JTextArea(12, 20);
		outputText.setLineWrap(true);
		outputText.setWrapStyleWord(true);
		outputText.setEditable(false);
		JScrollPane jScroll = new JScrollPane(outputText);
		jScroll.setBorder(BorderFactory.createTitledBorder("Output: "));
		this.add(jScroll, BorderLayout.CENTER);

		ButtonListener buttonListener = new ButtonListener();
		writeButton = new JButton("Write to file");
		writeButton.addActionListener(buttonListener);
		readButton = new JButton("Read from file");
		readButton.addActionListener(buttonListener);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(writeButton);
		buttonPanel.add(readButton);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}

	private class ButtonListener implements ActionListener {
		private FileIOInterface fileIO;
		@Override
		public void actionPerformed(ActionEvent e) {

			if (txtRadio.isSelected()){
				fileIO = new TextFile();
			}
			else {
				fileIO = new ObjFile();
			}
			
			Object src = e.getSource();
			if (src == readButton) {
				outputText.setText(fileIO != null ? fileIO.readFromFile() : "No File Found");
			} else {
				fileIO.writeToFile(inputText.getText());
				inputText.setText("");
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new FileIOGUI("Opg 3 IO og GUI");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);

	}

}
