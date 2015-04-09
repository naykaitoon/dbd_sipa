import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.JPanel;


public class Running extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The text area which is used for displaying logging information.
	 */
	private JTextArea textArea;


	private static PrintStream standardOut;

	public Running() {
		
		super("Sipa DBD");
		setResizable(false);
		setForeground(Color.BLACK);
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		textArea = new JTextArea(14, 10);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textArea.setBackground(Color.DARK_GRAY);
		
		textArea.setEditable(false);
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));

		// keeps reference of standard output stream
	

		// re-assigns standard output stream and error output stream
		System.setOut(printStream);
        System.setErr(printStream);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 40, 454, 240);
		getContentPane().add(scrollPane);
		
		JButton button = new JButton("เริ่มการทำงาน");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					printLog();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(21, 11, 127, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("ล้าง");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					textArea.getDocument().remove(0,
					textArea.getDocument().getLength());
			
				
					
				} catch (BadLocationException ex) {
					ex.printStackTrace();
				}
	
			
				
			
			}
		});
		button_1.setBounds(158, 11, 83, 23);
		getContentPane().add(button_1);
		
		


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480, 320);
		setLocationRelativeTo(null);	// centers on screen
	}

	/**
	 * Prints log statements for testing in a thread
	 */
	private void printLog() throws  InterruptedException{
		Thread thread = new Thread(new Runnable() {

			public void run() {
			
					try {
						MainRun runs = new MainRun();
						runs.Run();
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			
		});
		thread.start();
	}

	/**
	 * Runs the program
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Running r = new Running();
			
				r.setVisible(true);
			}
		});
	}
	
	public static void printing(String str){
		standardOut = System.out;
		standardOut.println(str);
	}
}