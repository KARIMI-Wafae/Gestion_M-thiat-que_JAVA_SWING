package TESTBIBLIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreerEmploye extends JFrame implements ActionListener {
	static Connection connexion=null;
	static String databaseName="";
	static String url ="jdbc:mysql://localhost:3306/"+databaseName;
	static String username="root";
	static String password="ertdfgcvb";
	
	JLabel lb1,lb2,lb3,lb4,lb5,lbtitre;
	JTextField tf1,tf3,tf4;
	JButton bt1,bt2,bt3,bt4,bt5,bt6,babonne,bt;
	JPasswordField tf2,tf5;
	ResultSet rst;
	Statement st;
	JPanel pn4;
	
	public CreerEmploye(){
		this.setTitle("Espace Administrateur");
		this.setSize(700,550);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(0xCEF0BD));
		add(pn);
		//titre
				lbtitre=new JLabel("Création d'un nouveau employé");
				lbtitre.setBounds(202,10,300,30);
				lbtitre.setFont(new Font("Arial",Font.BOLD,20));
				pn.add(lbtitre);
				
				lb1=new JLabel("Nom employe :");
				lb1.setBounds(170,120,130,25);
				lb1.setFont(new Font("Arial",Font.BOLD,13));
				pn.add(lb1);
				 tf3=new JTextField();
				 tf3.setBounds(290,120,130,25);
				pn.add(tf3);
				
				lb1=new JLabel("Prenom employe :");
				lb1.setBounds(150,170,130,25);
				lb1.setFont(new Font("Arial",Font.BOLD,13));
				pn.add(lb1);
				 tf4=new JTextField();
				 tf4.setBounds(290,170,130,25);
				pn.add(tf4);
				
				lb1=new JLabel("Login :");
				lb1.setBounds(220,220,130,25);
				lb1.setFont(new Font("Arial",Font.BOLD,13));
				pn.add(lb1);
				 tf1=new JTextField();
				 tf1.setBounds(290,220,130,25);
				pn.add(tf1);
				//
				lb1=new JLabel("Mot de passe :");
				lb1.setBounds(170,270,130,25);
				lb1.setFont(new Font("Arial",Font.BOLD,13));
				pn.add(lb1);
				 tf2 = new JPasswordField(50);
				 tf2.setBounds(290,270,130,25);
				 pn.add(tf2);
				 
				 lb1=new JLabel("Retaper le mot de passe :");
				 lb1.setBounds(100,320,230,25);
				 lb1.setFont(new Font("Arial",Font.BOLD,13));
				 pn.add(lb1);
				 tf5 = new JPasswordField(50);
				 tf5.setBounds(290,320,130,25);
				 pn.add(tf5);
				 
				 bt6=new JButton("Précèdent");
				 bt6.setBounds(440,460,110,30);
				 bt6.addActionListener(this);
				 pn.add(bt6);
					
				bt=new JButton("Créer");
				bt.setBounds(560,460,110,30);
				bt.addActionListener(this);
				pn.add(bt);
	}

	public static void main(String[] args) {
		CreerEmploye cd=new CreerEmploye();
	    cd.setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt6){
			dispose();
			EspaceAdmin cd=new EspaceAdmin();
		    cd.setVisible(true);
		}
		String nom_emp=tf3.getText();
		String prenom_emp=tf4.getText();
		String log=tf1.getText();
		String mdp1= new String(tf2.getPassword());
		String mdp2= new String(tf5.getPassword());
		if(e.getSource()==bt){
			String qr="INSERT INTO `bibliotheque`.`employe`(`nom_employe`,`prenom_employe`,`login`,`motDePasse`)"+"values('"+nom_emp+"','"+prenom_emp+"','"+log+"','"+mdp1+"')";
			if( nom_emp.length()==0 || prenom_emp.length()==0 ||log.length()==0  || mdp1.length() ==0 || mdp2.length()==0)
			{
				JOptionPane.showMessageDialog(this,"Veuillez insérer tous les champs !",null,JOptionPane.WARNING_MESSAGE);
				return;
			}
			try{
				 if(log.length()==0 || mdp1.length()==0 || nom_emp.length()==0 || prenom_emp.length()==0 || mdp2.length()==0) {
					 JOptionPane.showMessageDialog(null,"Veuillez saisir tous les champs demandé !",null,JOptionPane.WARNING_MESSAGE);

				 }else if(mdp1.equals(mdp2) == false){
					 JOptionPane.showMessageDialog(null,"Veuillez saisir le même mot de passe !",null,JOptionPane.WARNING_MESSAGE);

				 }
				 else{
				 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					connexion = DriverManager.getConnection(url,username,password);
					PreparedStatement ps= connexion.prepareStatement(qr);
					int status=ps.executeUpdate();
				 if(status != 0){
					 JOptionPane.showMessageDialog(null,"Employé créé avec succès"); 
				 }
				 }
				 }		 
			 catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex){
			    	JOptionPane.showMessageDialog(null,ex.getMessage(),null,JOptionPane.ERROR_MESSAGE);	
			    }
			 
			 }
		
	}

}
