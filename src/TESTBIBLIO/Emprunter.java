package TESTBIBLIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Emprunter extends JFrame implements ActionListener{
	
	java.sql.Statement st;
	ResultSet rst;
	static Connection connexion=null;
	static String databaseName="";
	static String url ="jdbc:mysql://localhost:3306/"+databaseName;
	static String username="root";
	static String password="ertdfgcvb";
	//Connec cn=new Connec();
	JComboBox jcb,jcb2;
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton bt,bt6,rch;
	
	public Emprunter(){
		this.setTitle("Espace employe");
		this.setSize(700,550);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(0xACA4FC));
		add(pn);
		
		//label
		lb3=new JLabel("Emprunter un livre");
		lb3.setBounds(262,20,180,25);
		lb3.setFont(new Font("Arial",Font.BOLD,18));
		pn.add(lb3);
				
		//
		lb1=new JLabel("Numero lecteur");
		lb1.setBounds(30,70,130,25);
		lb1.setFont(new Font("Arial",Font.BOLD,13));
		pn.add(lb1);
		 tf1=new JTextField();
		 tf1.setBounds(170,70,130,25);
		pn.add(tf1);
		//
		lb1=new JLabel("Nom lecteur");
		lb1.setBounds(30,120,130,25);
		lb1.setFont(new Font("Arial",Font.BOLD,13));
		pn.add(lb1);
		 tf2=new JTextField();
		 tf2.setBounds(170,120,130,25);
		pn.add(tf2);
		//
		lb1=new JLabel("Cote livre");
		lb1.setBounds(30,170,130,25);
		lb1.setFont(new Font("Arial",Font.BOLD,13));
				Icon icon = new ImageIcon("C:\\Users\\user\\Downloads\\1x\\Fichier 1.png");
				rch=new JButton(icon);
				rch.setBounds(315,170,30,25);
				rch.addActionListener(this);
				pn.add(rch);
		pn.add(lb1);
		 tf3=new JTextField();
		 tf3.setBounds(170,170,130,25);
		pn.add(tf3);
		//
		lb1=new JLabel("Titre");
		lb1.setBounds(30,220,130,25);
		lb1.setFont(new Font("Arial",Font.BOLD,13));
		pn.add(lb1);
		 tf4=new JTextField();
		 tf4.setBounds(170,220,130,25);
		pn.add(tf4);
		//
		lb1=new JLabel("Auteur");
		lb1.setBounds(30,270,130,25);
		lb1.setFont(new Font("Arial",Font.BOLD,13));
		pn.add(lb1);
		 tf5=new JTextField();
		 tf5.setBounds(170,270,130,25);
		pn.add(tf5);
		//
		lb1=new JLabel("Date Emprunt");
		lb1.setBounds(30,320,130,25);
		lb1.setFont(new Font("Arial",Font.BOLD,13));
		pn.add(lb1);
		 tf6=new JTextField();
		 tf6.setBounds(170,320,130,25);
		pn.add(tf6);
		//
		lb1=new JLabel("Date Fin Délai");
		lb1.setBounds(30,370,130,25);
		lb1.setFont(new Font("Arial",Font.BOLD,13));
		pn.add(lb1);
		 tf7=new JTextField();
		 tf7.setBounds(170,370,130,25);
		pn.add(tf7);
		//precedent
		bt6=new JButton("Précèdent");
		bt6.setBounds(440,460,110,30);
		bt6.addActionListener(this);
		pn.add(bt6);
		//acheter
		bt=new JButton("Emprunter");
		bt.setBounds(560,460,110,30);
		bt.addActionListener(this);
		pn.add(bt);
		
		
	

}

	@Override
	public void actionPerformed(ActionEvent e) {
if(e.getSource()==bt6){
			
			try{
				dispose();
				Livre ab=new Livre();
				ab.setVisible(true);
				
			}
			catch(Exception ex){
				
			}
				
			}
		if(e.getSource()==bt){
			String num,nom,cote,titre,auteur,dateA,dateF;
			num=tf1.getText();
			nom=tf2.getText();
			cote=tf3.getText();
			titre=tf4.getText();
			auteur=tf5.getText();
			dateA=tf6.getText();
			dateF=tf7.getText();
			String qr="SELECT * from `bibliotheque`.`livre` where `cote`="+cote+" and `etat`='disponible';";
			String qr1="INSERT INTO `bibliotheque`.`emprunt_livre`(`num_user`,`nom_user`,`cote`,`titre`,`auteur`,`date_emprunt`,`date_fin_delai`)"+"values('"+num+"','"+nom+"','"+cote+"','"+titre+"','"+auteur+"','"+dateA+"','"+dateF+"')";
			String qr2="UPDATE `bibliotheque`.`livre` SET `etat`='non disponible' where `cote`="+cote+";";
			// VALUES (1,'karimi',4,'pere riche','kiozaki','2022-01-24');";
					//
			if(num.length()==0 || nom.length()==0 || cote.length() ==0  || titre.length()==0 || auteur.length() ==0 || dateA.length() ==0 || dateF.length()==0)
			{
				JOptionPane.showMessageDialog(this,"Veuillez insérer tous les champs !",null,JOptionPane.WARNING_MESSAGE);
				return;
			}
			try{
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				connexion = DriverManager.getConnection(url,username,password);
				PreparedStatement ps= connexion.prepareStatement(qr);
				PreparedStatement ps1= connexion.prepareStatement(qr1);
				PreparedStatement ps2=connexion.prepareStatement(qr2);
				java.sql.Statement stmt = connexion.createStatement();
				ResultSet résultats = stmt.executeQuery(qr);;
				if(résultats.next()) {
					int status=ps1.executeUpdate();
					int status2=ps2.executeUpdate();
					if(status !=0)
					{
						JOptionPane.showMessageDialog(this,"Emprunt effectué !");	
					}
					
					if(status2 !=0)
					{
						JOptionPane.showMessageDialog(this,"Etat livre modifié !");
					}
				}
				else {
					JOptionPane.showMessageDialog(this,"Livre non disponible pour le moment !");
				}
						
			}
			catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex){
				JOptionPane.showMessageDialog(this,ex.getMessage(),null,JOptionPane.ERROR_MESSAGE);
			} 
		}
		//Boutton de recherche 
				if(e.getSource()==rch){
					String c=tf3.getText();
					try{
						if(c.length()==0) {
							JOptionPane.showMessageDialog(this,"Veuillez insérer le numéro de cote !");
						}
						else {
							String cote,titre,auteur;
							cote=c;
							String qr="SELECT * from `bibliotheque`.`livre` where `cote`="+cote+";";
							Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							connexion = DriverManager.getConnection(url,username,password);
							java.sql.Statement stmt = connexion.createStatement();
							ResultSet cds = stmt.executeQuery(qr);
							if(cds.next()){
								titre=cds.getString(3);tf4.setText(titre);
								auteur=cds.getString(4);tf5.setText(auteur);
							}
							else
							{
								JOptionPane.showMessageDialog(this,"Le livre recherché n'existe pas !");
							}
						}
					}
					catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex){
						JOptionPane.showMessageDialog(this,ex.getMessage(),null,JOptionPane.ERROR_MESSAGE);
					} 
						
					}
		
	}
	}
