package TESTBIBLIO;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Choixtypedocument extends JFrame implements ItemListener {
	Creerunlivre livre=new Creerunlivre();
	Creeruncdrom cdrom=new Creeruncdrom();
	Créerunjournal journal =new Créerunjournal();
	Créerunmicrofilm microfilm =new Créerunmicrofilm();
	JPanel panel1 =new JPanel();
	JPanel panel =new JPanel();
	ImageIcon icon = new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\fichier.png");
	JLabel label = new JLabel();
    JComboBox cb ;
    String[] demandes = {"les choix ","Créer un livre", "Créer un CD-Rom", "Créer microfilm ","Créer un journal"};
	Choixtypedocument(){
		 
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
		add(panel);this.setLocationRelativeTo(null);
	
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
		Choixtypedocument C = new Choixtypedocument();
		C.setVisible(true);
		

	}

}
