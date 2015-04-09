import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.GroupLayout.Alignment;
public class main{
    static JFrame frmDbdMonitor = new JFrame("DBD Monitor");
    public static void main( String [] args ) throws InterruptedException{
        frmDbdMonitor.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
        frmDbdMonitor.setForeground(new Color(255, 255, 255));
        frmDbdMonitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmDbdMonitor.pack();
        frmDbdMonitor.setBounds(200, 200, 650, 364);
        frmDbdMonitor.setModalExclusionType(ModalExclusionType.NO_EXCLUDE);
        frmDbdMonitor.setFont(new Font("Tahoma", Font.PLAIN, 12));
        frmDbdMonitor.getContentPane().setLayout(new CardLayout(0, 0));
    
        JTextArea ta = new JTextArea();
        ta.setColumns(45);
        ta.setRows(18);
        ta.setEditable(false);
        JScrollPane scrollPane = new JScrollPane( ta );
        scrollPane.setViewportBorder(UIManager.getBorder("TextArea.border"));
        ta.setForeground(Color.WHITE);
        ta.setBackground(Color.BLACK);
        ta.setFont(new Font("SansSerif", Font.PLAIN, 12));
        TextAreaOutputStream taos = new TextAreaOutputStream( ta, 99999 );
        frmDbdMonitor.getContentPane().add(scrollPane, "name_65750613215587");
       
        PrintStream ps = new PrintStream( taos );
        System.setOut( ps );
        System.setErr( ps );
        frmDbdMonitor.setVisible( true );

         
       try {
    	 
	  MainRun m =new MainRun();
       m.Run();

       } catch (Exception e) {
	  
       }
    }
 
}