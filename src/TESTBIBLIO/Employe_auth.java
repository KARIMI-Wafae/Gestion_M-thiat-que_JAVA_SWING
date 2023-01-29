package TESTBIBLIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Employe_auth extends JFrame implements ActionListener {
	
	static Connection connexion=null;
	static String databaseName="";
	static String url ="jdbc:mysql://localhost:3306/"+databaseName;
	static String username="root";
	static String password="ertdfgcvb";
	
	JLabel lb1,lb2,lb3,lb4,lb5,lbtitre;
	JTextField tf1,tf3,tf4,tf5;
	JButton bt1,bt2,bt3,bt4,bt5,bt6,babonne,bt;
	JPasswordField tf2;
	ResultSet rst;
	Statement st;

	public Employe_auth(){
		this.setTitle("Gestion Médiathèque");
		this.setSize(700,550);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(0xCEF0BD));
		//setForeground(Color.black);
		add(pn);
		//titre
				lbtitre=new JLabel("Employe");
				lbtitre.setBounds(272,10,300,30);
				lbtitre.setFont(new Font("Arial",Font.BOLD,20));
				pn.add(lbtitre);
				
				lb1=new JLabel("Login");
				lb1.setBounds(220,180,130,25);
				lb1.setFont(new Font("Arial",Font.BOLD,13));
				pn.add(lb1);
				 tf1=new JTextField();
				 tf1.setBounds(290,180,130,25);
				pn.add(tf1);
				//
				lb1=new JLabel("Mot de passe");
				lb1.setBounds(170,230,130,25);
				lb1.setFont(new Font("Arial",Font.BOLD,13));
				pn.add(lb1);
				// tf2=new JTextField();
				 tf2 = new JPasswordField(50);
				 tf2.setBounds(290,230,130,25);
				 pn.add(tf2);
				 
				 bt6=new JButton("Précèdent");
				 bt6.setBounds(440,460,110,30);
				 bt6.addActionListener(this);
				 pn.add(bt6);
					
				bt=new JButton("Se connecter");
				bt.setBounds(560,460,110,30);
				bt.addActionListener(this);
				pn.add(bt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String log=tf1.getText();
		//char[] mdpc=;
		String mdp= new String(tf2.getPassword());
		if(e.getSource()==bt){
			String qr="SELECT * from `bibliotheque`.`employe` where `login`='"+log+"' and `motDePasse`='"+mdp+"';";
			 try{
				 if(log.length()==0 || mdp.length()==0) {
					 JOptionPane.showMessageDialog(null,"Veuillez saisir le login et le mot de passe !",null,JOptionPane.WARNING_MESSAGE);

				 }else {
				 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					connexion = DriverManager.getConnection(url,username,password);
					java.sql.Statement stmt = connexion.createStatement();
					ResultSet résultats = stmt.executeQuery(qr);
				 if(résultats.next()){
					 JOptionPane.showMessageDialog(null,"Vous êtes connecté");
					   dispose();
					   Employe ab=new Employe();
						ab.setVisible(true);
					 
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null,"login ou mot de passe incorrect !",null,JOptionPane.ERROR_MESSAGE);
				 }
				 }
				 }		 
			 catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex){
			    	JOptionPane.showMessageDialog(null,ex.getMessage(),null,JOptionPane.ERROR_MESSAGE);	
			    }
			 
			 }
		if(e.getSource()==bt6){
			dispose();
			Authentification cd=new Authentification();
		    cd.setVisible(true);
		}
		}
		
	}

