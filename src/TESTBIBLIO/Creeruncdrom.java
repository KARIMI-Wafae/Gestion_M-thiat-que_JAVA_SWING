package TESTBIBLIO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Creeruncdrom extends JFrame implements ActionListener {
	static Connection conction=null;
	static String databaseName="";
	static String url="jdbc:mysql://localhost:3306/"+databaseName;
	static String username="root";
	static String password="ertdfgcvb";
	///
	

JLabel ltitre = new  JLabel("TITRE :") ;
JTextField ttitre=new  JTextField();
JLabel lauteur = new  JLabel("AUTEUR:") ;
JTextField tauteur=new  JTextField();
JLabel lcaution = new  JLabel("CAUTION:") ;
JTextField tcaution=new  JTextField();
//JButton  btnvalider = new JButton("Valider",new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\Application java\\src\\Applicationjava\\jaccepte.png"));

//JButton btnannuler = new JButton("Annuler",new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\Application java\\src\\Applicationjava\\annulation.png"));
JPanel BTNcon= new JPanel();
JPanel textecon= new JPanel();
JPanel contenu= new JPanel();
JButton btnAjouter = new JButton("AJOUTER");
JButton btnprecedent = new JButton("PRECEDENT");

Creeruncdrom(){

setTitle("ESPACE CREATION :");
setSize(700, 500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
BTNcon.add(btnAjouter);
BTNcon.add(btnprecedent);
 /*  btnAjouter.addActionListener(e ->{
	JButtonActionPerformed(e);
  }
  );
  btnprecedent.addActionListener(e ->{
	  Employe employe=new Employe();
			  dispose();
	    
    	employe.setVisible(true);
  }
  );*/
btnAjouter.addActionListener(this);
btnprecedent.addActionListener(this);
contenu.add(BTNcon);
BTNcon.setBackground(Color.decode("#444f70") );
contenu.setBackground(Color.decode("#444f70") );
contenu.setBorder(new TitledBorder("CREER UN CDRom "));
add(contenu);
textecon.setPreferredSize(new Dimension(400,250));
textecon.setBackground(Color.decode("#9683ec"));
textecon.setBorder(new TitledBorder("REMPLIRE LES CHAMPS "));

	
this.setLocationRelativeTo(null);
textecon.add(ltitre);
textecon.add(ttitre);
textecon.add(lauteur);
textecon.add(tauteur);
textecon.add(lcaution);
textecon.add(tcaution);
textecon.setLayout(null);
ltitre.setBounds(90, 30, 90, 20);
ttitre.setBounds(155, 30, 120, 20);
lauteur.setBounds(90, 80, 90, 20);
tauteur.setBounds(155, 80, 120, 20);
lcaution.setBounds(90, 120, 90, 20);
tcaution.setBounds(155, 120, 120, 20);


contenu.add(textecon);
// contenu.setLayout(null);
 GridLayout gb=new GridLayout(1,2);
 gb.setHgap(5);
 BTNcon.setLayout(gb);
 BTNcon.setPreferredSize(new Dimension(250,40));  



}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	Creeruncdrom cr= new Creeruncdrom ();
	cr.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==btnAjouter) {
		try {
			 
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conction=DriverManager.getConnection(url,username,password);
			if(ttitre.getText().equals("")||tauteur.getText().equals("")||tcaution.getText().equals("")) {
				
				JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs" );}
			else {
			PreparedStatement ps=conction.prepareStatement("INSERT INTO `bibliotheque`.`document`(`type`,`titre`,`auteur`,`caution`) VALUES('CDROM',?,?,"+Float.parseFloat(tcaution.getText())+");");
			ps.setString(1, ttitre.getText());
			ps.setString(2, tauteur.getText());
			ps.execute();
			conction.close();
			JOptionPane.showMessageDialog(null,"cdrom crée" );}
			
		 }catch(Exception ev){
			JOptionPane.showConfirmDialog(null,"cdrom non crée ");
				
		 }
		
	}
if(e.getSource()==btnprecedent) {
	 Employe employe=new Employe();
	  dispose();

     employe.setVisible(true);
	}
	
}
}
