package TESTBIBLIO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class supprimerundocument  extends JFrame implements ItemListener{
	supprimerunlivre livre=new supprimerunlivre();
	supprimeruncdrom cdrom=new supprimeruncdrom();
	supprimerunjournal journal =new supprimerunjournal();
	supprimerunmicrofilm microfilm =new supprimerunmicrofilm();
	JPanel panel1 =new JPanel();
	JPanel panel =new JPanel();
	ImageIcon icon = new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\fichier.png");
	JLabel label = new JLabel();
    JComboBox cb ;
    String[] demandes = {"les choix ","Supprimer un livre", "Supprimer un CD-Rom", "Supprimer un microfilm ","Supprimer un journal"};
	supprimerundocument(){
		 
		 panel1.setLayout(null);
		label.setIcon(icon);
		panel.add(label);
		setTitle("ESPACE DOCUMENT:");
		panel.add(panel1);
		setSize(300, 400);
		
		panel1.setBackground(Color.decode("#1f7690") );
		//add(panel1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cb=new JComboBox(demandes);
		cb.setBackground(Color.decode("#1f7690"));
		cb.setBounds(45,60, 205, 30);
	 	cb.addItemListener(this);
		add(cb);
		add(panel);
		this.setLocationRelativeTo(null);
	
	}
	 public void itemStateChanged(ItemEvent i) {
  	   cb.setBackground(Color.red);
 		int choix =cb.getSelectedIndex();
 		switch(choix) {
 		case 0: ; break;
 		case 1: dispose();
 		livre.setVisible(true);break;
 		case 2: dispose();cdrom.setVisible(true); break;
 		case 3: dispose();microfilm.setVisible(true); break;
 		case 4: dispose();journal.setVisible(true); break;
 		default: ; break;
 		
 		}
	


	 }
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			supprimerundocument C = new supprimerundocument();
			C.setVisible(true);
			

		}
}
