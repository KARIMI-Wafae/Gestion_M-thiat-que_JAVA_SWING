package TESTBIBLIO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Creerunlivre extends JFrame implements ActionListener{

	

	
	//BASE DE DONNEE
	
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
	//JButton  btnvalider = new JButton("Valider",new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\Application java\\src\\Applicationjava\\jaccepte.png"));

//	JButton btnannuler = new JButton("Annuler",new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\Application java\\src\\Applicationjava\\annulation.png"));
	JPanel BTNcon= new JPanel();
	JPanel textecon= new JPanel();
	JPanel contenu= new JPanel();
	JButton btnAjouter = new JButton("AJOUTER");
	JButton btnprecedent = new JButton("PRECEDENT");
	
	Creerunlivre(){
		setTitle("ESPACE CREATION :");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BTNcon.add(btnAjouter);
		BTNcon.add(btnprecedent);
		   btnAjouter.addActionListener(this);
		  
		  btnprecedent.addActionListener(this);
		
		
		contenu.add(BTNcon);
		BTNcon.setBackground(Color.decode("#444f70") );
		contenu.setBackground(Color.decode("#444f70") );
		contenu.setBorder(new TitledBorder("CREER UN LIVRE "));
		add(contenu);
		textecon.setPreferredSize(new Dimension(400,250));
		textecon.setBackground(Color.decode("#9683ec"));
		textecon.setBorder(new TitledBorder("REMPLIRE LES CHAMPS "));
	
			
		
		textecon.add(ltitre);
		textecon.add(ttitre);
		textecon.add(lauteur);
		textecon.add(tauteur);
		textecon.setLayout(null);
		ltitre.setBounds(90, 30, 90, 20);
		ttitre.setBounds(155, 30, 120, 20);
		lauteur.setBounds(90, 80, 90, 20);
		tauteur.setBounds(155, 80, 120, 20);
		
		contenu.add(textecon);
		this.setLocationRelativeTo(null);
		 GridLayout gb=new GridLayout(1,2);
		 gb.setHgap(5);
		 BTNcon.setLayout(gb);
		 BTNcon.setPreferredSize(new Dimension(250,40));  
		
		
		
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Creerunlivre cr= new Creerunlivre();
		cr.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnAjouter) {
			 try {
				 
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					conction=DriverManager.getConnection(url,username,password);
					if(ttitre.getText().equals("")||tauteur.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs" );}
					else {
					PreparedStatement ps=conction.prepareStatement("INSERT INTO `bibliotheque`.`document`(`type`,`titre`,`auteur`) VALUES('LIVRE',?,?);");
					ps.setString(1, ttitre.getText());
					ps.setString(2, tauteur.getText());
					ps.execute();
					conction.close();
					JOptionPane.showMessageDialog(null,"livre crée" );}
				
					
				 }catch(Exception ev){
					JOptionPane.showConfirmDialog(null,"livre non crée ");
						
				 }
		}
	if(e.getSource()==btnprecedent) {
		 Employe employe=new Employe();
		  dispose();
   
	employe.setVisible(true);
		}
	}

}
