package TESTBIBLIO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Creeruser extends JFrame implements ActionListener {
	

	
	//BASE DE DONNEE
	
			static Connection conction=null;
			static String databaseName="";
			static String url="jdbc:mysql://localhost:3306/"+databaseName;
			static String username="root";
			static String password="ertdfgcvb";
			///
			
	
	JLabel lnom = new  JLabel("NOM :") ;
	JTextField tnom=new  JTextField();
	JLabel lprenom = new  JLabel("PRENOM :") ;
	JTextField tprenom=new  JTextField();
	JLabel ladresse = new  JLabel("ADRESSE :") ;
	JTextField tadresse=new  JTextField();
	 JLabel lemail= new  JLabel("EMAIL :") ;
	JTextField temail=new  JTextField();
	JLabel llogin = new  JLabel("LOGIN :") ;
	JTextField tlogin=new  JTextField();
	JLabel lmotdepasse = new  JLabel("MOT DE PASSE :") ;
	JPasswordField tmotdepasse=new  JPasswordField(50);;
	JButton  btnvalider = new JButton("Valider",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\jaccepte.png"));
	JButton btnannuler = new JButton("Annuler",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\annulation.png"));
	JPanel BTNcon= new JPanel();
	JPanel textecon= new JPanel();
	JPanel contenu= new JPanel();
	
	
	
	Creeruser(){
		setTitle("ESPACE CREATION :");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		  btnannuler.setBorder(BorderFactory.createBevelBorder(0)); 
		  btnvalider.setBorder(BorderFactory.createBevelBorder(0)); 
		  btnvalider.setBackground(Color.LIGHT_GRAY);
		  btnannuler.setBackground(Color.LIGHT_GRAY);
		  btnvalider.addActionListener(this);
		  btnannuler.addActionListener(this);
		  GridLayout gr=new GridLayout(6,2);
		  this.setLocationRelativeTo(null);
	
		gr.setVgap(25);
		textecon.setLayout(gr);
		contenu.setBackground(Color.decode("#444f70") );
		contenu.setBorder(new TitledBorder("CREER UN LECTEUR "));
		add(contenu);
		textecon.setPreferredSize(new Dimension(600,350));
		textecon.setBackground(Color.decode("#9683ec"));
		textecon.setBorder(new TitledBorder("REMPLIRE LES CHAMPS "));
	
		
		
		textecon.add(lnom);
		textecon.add(tnom);
		textecon.add(lprenom);
		textecon.add(tprenom);
		textecon.add(ladresse);
		textecon.add(tadresse);
		textecon.add(lemail);
		textecon.add(temail);
		textecon.add(llogin);
		textecon.add(tlogin);
		textecon.add(lmotdepasse);
		textecon.add(tmotdepasse);
		contenu.add(textecon);
		
		 GridLayout gb=new GridLayout(1,2);
		 gb.setHgap(5);
		 BTNcon.setLayout(gb);
		 BTNcon.setPreferredSize(new Dimension(250,40));  
		
		
		 BTNcon.add(btnannuler);
		 BTNcon.add(btnvalider);
		 contenu.add(BTNcon);
		
	}
		
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Creeruser frame1 = new Creeruser();
	        ///frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame1.setVisible(true);
	       
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource()==btnvalider) {
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				conction=DriverManager.getConnection(url,username,password);
				if(tnom.getText().equals("") || tprenom.getText().equals("") || tadresse.getText().equals("") || temail.getText().equals("")|| tlogin.getText().equals("")|| tmotdepasse.getText().equals("")) {
					JOptionPane.showMessageDialog(this,"Veuillez remplir tous les champs" );}
					
				else {
					String pwd=new String(tmotdepasse.getPassword());
					PreparedStatement ps=conction.prepareStatement("INSERT INTO `bibliotheque`.`lecteur`(`nom_lecteur`,`prenom_lecteur`,`adresse`,`email`,`login`,`motdepasse`) VALUES(?,?,?,?,?,'"+pwd+"');");
					ps.setString(1, tnom.getText());
					ps.setString(2, tprenom.getText());
					ps.setString(3, tadresse.getText());
					ps.setString(4, temail.getText());
					ps.setString(5, tlogin.getText());
		
					PreparedStatement ps2=conction.prepareStatement("INSERT INTO `bibliotheque`.`fiche_lecteur`(`nom_user`,`prenom_user`,`adresse`,`email`,`login`,`motDePasse`) VALUES(?,?,?,?,?,'"+pwd+"');");
					ps2.setString(1, tnom.getText());
					ps2.setString(2, tprenom.getText());
					ps2.setString(3, tadresse.getText());
					ps2.setString(4, temail.getText());
					ps2.setString(5, tlogin.getText());
					ps.execute();
					ps2.execute();
					conction.close();
					JOptionPane.showMessageDialog(this,"lecteur crée" );}
			
				
			
				
			 }catch(Exception ev){
				JOptionPane.showConfirmDialog(this,"lecteur non crée ");
					
			 }}
			 
			 if(e.getSource()==btnannuler) {
				 Employe employe=new Employe();
				  dispose();
		    
	   	employe.setVisible(true);
			 }
			 
	}

}
