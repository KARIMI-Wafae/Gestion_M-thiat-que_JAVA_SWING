package TESTBIBLIO;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class EspaceAdmin extends JFrame implements ActionListener{

	static Connection connexion=null;
	static String databaseName="";
	static String url ="jdbc:mysql://localhost:3306/"+databaseName;
	static String username="root";
	static String password="ertdfgcvb";
	
	JLabel lbtitre;
	JButton btn,btn2,logout;
	JPanel pn,pn2,pn3,pn4;
	
	public EspaceAdmin(){
		this.setTitle("Espace Administrateur");
		this.setSize(700,550);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(0x81F6AF));
		
		   ImageIcon icone = new ImageIcon("C:\\Users\\user\\Downloads\\admin3.jpg");
	       JLabel image = new JLabel(icone);
	       image.setPreferredSize(new Dimension(400,200));
	       
	       
		pn=new JPanel();
		pn2=new JPanel();
		pn3=new JPanel();
		pn4=new JPanel();
		pn2.setPreferredSize(new Dimension(400,400));
		pn2.setBackground(new Color(0xCEF0BD));//EAE796
		
		pn3.setPreferredSize(new Dimension(400,200));
		pn3.setBackground(new Color(0xCEF0BD));
		pn4.setPreferredSize(new Dimension(400,100));
		pn4.setBackground(new Color(0xCEF0BD));//EAE796  
		
		pn.setBounds(500, 500, 500, 500);
		pn.setPreferredSize(new Dimension(700,500));

		pn.setBackground(new Color(0xF0EEBD));
		pn3.add(image);
		Border myborder = BorderFactory.createLineBorder(Color.black, 1); 
		pn3.setBorder(myborder);
		logout=new JButton("logout");
		logout.addActionListener(this);
		
		
		
		//titre
				lbtitre=new JLabel("                 Administration    ");
				
				  logout=new JButton("Log Out",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\logout.png"));
			//	  logout.setBounds(540,20,110,30);
				  this.add(logout);
				  logout .setBackground(Color.lightGray);
				  logout.addActionListener(this);
				   
				   
				lbtitre.setAlignmentX(Component.CENTER_ALIGNMENT);
				lbtitre.setFont(new Font("Arial",Font.BOLD,20));
				lbtitre.setBackground(Color.black);
				pn2.add(lbtitre);
				pn2.add(logout);
				logout.setBounds(600,20,5,10);
		
		this.add(pn);
		pn2.add(pn3);
		pn.add(pn2);
	         	pn2.add(pn4);
				btn2 = new JButton("Créer bibliothécaire");
				btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
				btn2.setBounds(60,500,400,50);
				btn2.addActionListener(this);
				pn2.add(btn2);
						
				btn = new JButton("    Créer employe    ");
				btn.setAlignmentX(Component.CENTER_ALIGNMENT);
				btn.setBounds(60,500,400,50);
				btn.addActionListener(this);
				pn2.add(btn);
				
				
				
    }
    
	public static void main(String[] args) {
		EspaceAdmin cd=new EspaceAdmin();
	    cd.setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn2){
			dispose();
			CreerBibliothecaire ab=new CreerBibliothecaire();
			ab.setVisible(true);
		}
		if(e.getSource()==btn){
			dispose();
			CreerEmploye ab=new CreerEmploye();
			ab.setVisible(true);
		}
		if(e.getSource()==logout){
			dispose();
			Administrateur ab=new Administrateur();
			ab.setVisible(true);
		}
		
		}
	
		
	}
  

