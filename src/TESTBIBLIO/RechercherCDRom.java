package TESTBIBLIO;

import java.awt.event.*;

import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class RechercherCDRom extends JFrame implements ActionListener{
	

		java.sql.Statement st;
		ResultSet rst;
		static Connection connexion=null;
		static String databaseName="";
		static String url ="jdbc:mysql://localhost:3306/"+databaseName;
		static String username="root";
		static String password="ertdfgcvb";
		//Connec cn=new Connec();
		
		JLabel lbtitre,lbtitre1,lbtitre2;;
		JTextField JtfTitre,JtfAuteur;
		JButton btnRech,btnRech1,btnPrecedent;
		JScrollPane scroll;
		JTable table;
		DefaultTableModel df;
		
		public RechercherCDRom(){
			 this.setTitle("Espace Utilisateur");
			 JPanel pn=new JPanel();
			 pn.setSize(500,300);
			 
             this.setLayout(null);
		     this.setLocation(340,90);
			 this.setVisible(true);
			 this.setSize(700, 550);
			 this.getContentPane().setBackground(Color.LIGHT_GRAY);
			 btnPrecedent=new JButton("Précèdent");
			 btnPrecedent.setBounds(540,450,110,30);
			 btnPrecedent.addActionListener(this);
			 this.add(btnPrecedent);
			
		
			 lbtitre1=new JLabel("TITRE");lbtitre1.setBounds(40,10,300,30);lbtitre1.setFont(new Font("Arial",Font.ITALIC,14));
			 lbtitre1.setForeground(Color.darkGray);this.add(lbtitre1);
			 lbtitre2=new JLabel("AUTEUR");lbtitre2.setBounds(300,10,300,30);lbtitre2.setFont(new Font("Arial",Font.ITALIC,14));
			 lbtitre2.setForeground(Color.darkGray);this.add(lbtitre2);
			 JtfTitre = new JTextField();this.add(JtfTitre);JtfTitre.setBounds(93,10,160,28);
			 JtfAuteur = new JTextField();this.add(JtfAuteur);JtfAuteur.setBounds(370,10,160,28);
			 btnRech=new JButton("",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\Search (2).png"));
			 this.add(btnRech);btnRech.setBounds(258,10,29,27);
			 btnRech.addActionListener(this);
			 btnRech1=new JButton("",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\Search (2).png"));
			 this.add(btnRech1);btnRech1.setBounds(535,10,29,27);
			 btnRech1.addActionListener(this);
			 df=new  DefaultTableModel();
		
			 init();
			 this.add(scroll);
			 df.addColumn("Numero");
		     df.addColumn("Cote");
			 df.addColumn("Titre");
			 df.addColumn("Auteur");
			 df.addColumn("Etat");
			 df.addColumn("Caution");
			 table.setModel(df);
			
			 

	}

		@Override
		public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnPrecedent){
				
				try{
					dispose();
					InterfaceUser ab=new InterfaceUser();
					ab.setVisible(true);
					
				}
				catch(Exception ex){
					
				}}//FIN btnPrecedent
            //traitement btnRecher par titre 
              if(e.getSource()==btnRech){
				
            	  String titre=JtfTitre.getText();
            	  String req="select * from `bibliotheque`.`cdrom` where `titre`='"+titre+"'order by titre ;";
				try{Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				connexion = DriverManager.getConnection(url,username,password);
				java.sql.Statement stmt = connexion.createStatement();
				ResultSet résultats = stmt.executeQuery(req);
				while(résultats.next()){
					
					 df.addRow(new Object[]{
							 résultats.getString("num_cdrom"),résultats.getString("cote"),résultats.getString("titre"),
							 résultats.getString("auteur"),résultats.getString("etat"),résultats.getString("caution")});
				 }
				if(titre.equals(""))
				JOptionPane.showMessageDialog(null,"veuillez entrer le titre!");
	
				}
				catch(Exception ex){
					
				}}//btnRecher
              
              
              //traitement btnRecher par auteur
              if(e.getSource()==btnRech1){
				
            	  String auteur=JtfAuteur.getText();
            	  String req="select * from `bibliotheque`.`cdrom` where `auteur`='"+auteur+"'order by titre ;";
				try{Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				connexion = DriverManager.getConnection(url,username,password);
				java.sql.Statement stmt = connexion.createStatement();
				ResultSet résultats = stmt.executeQuery(req);
				while(résultats.next()){
					
					 df.addRow(new Object[]{
							 résultats.getString("num_cdrom"),résultats.getString("cote"),résultats.getString("titre"),
							 résultats.getString("auteur"),résultats.getString("etat"),résultats.getString("caution")});
				 }
				if(auteur.equals(""))
				JOptionPane.showMessageDialog(null,"veuillez entrer l'auteur!");
			
				
					
				}
				catch(Exception ex){
					
				}}//btnRecher1
              
              
              
              
              
	
	
	}

	public static void main(String[] args) {
		new RechercherCDRom();	}
	private void init(){
		table=new JTable();
		scroll=new JScrollPane();
		scroll.setBounds(90,50,520,300);
		scroll.setViewportView(table);
	}


}

