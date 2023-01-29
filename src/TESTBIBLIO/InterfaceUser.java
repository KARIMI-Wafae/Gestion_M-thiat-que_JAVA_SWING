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
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class InterfaceUser extends JFrame implements ActionListener{
		
		JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
		JTextField tf1,tf2,tf3,tf4,tf5,tf6;
		JButton btnlogout,btnNotif,btnlivre,btncdrom,btnjournal,btnmicrof;
		
		public InterfaceUser(){
			 this.setTitle("Espace Utilisateur");
			 this.setLayout(null);
			 this.setLocation(340,90);
			 this.setVisible(true);
			 this.setSize(700, 550);
			  ImageIcon icone = new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\image_bib (1).jpg");
			  JLabel image = new JLabel(icone);
			  this.add(image);image.setBounds(350,62,300,280);
			
   btnlogout=new JButton("Log Out",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\log.png"));btnlogout.setBounds(540,20,110,30);this.add(btnlogout);
   btnlogout .setBackground(Color.lightGray);
   btnlogout.addActionListener(this);
   btnNotif=new JButton("Notify",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\notification (2).png"));btnNotif.setBounds(420,20,110,30);this.add(btnNotif);
   btnNotif.setBackground(Color.lightGray);
   btnNotif.addActionListener(this);
   //1
   btnlivre=new JButton("Livre",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\gnomebooks_104348.png"));
   btnlivre.setBounds(100,60,130,60);this.add(btnlivre);
   btnlivre.setBackground(Color.pink);
   btnlivre.addActionListener(this);
   //2
   btncdrom=new JButton("CDRom",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\CD.png"));
   btncdrom.setBounds(100,130,130,60);this.add(btncdrom);
   btncdrom.setBackground(Color.CYAN);
   btncdrom.addActionListener(this);
   //3
   btnjournal=new JButton("Journal",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\icone_journal.png"));
   btnjournal.setBounds(100,200,130,60);this.add(btnjournal);
   btnjournal.setBackground(Color.MAGENTA);
   btnjournal.addActionListener(this);
   //4
   btnmicrof=new JButton("MicroF",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\icone_micro.png"));
   btnmicrof.setBounds(100,270,130,60);this.add(btnmicrof);
   btnmicrof.setBackground(Color.LIGHT_GRAY);
   btnmicrof.addActionListener(this);
   

	}

		
	   
			@Override
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnlivre){
					
					try{
						dispose();
						InterfaceLivre ab=new InterfaceLivre();
						ab.setVisible(true);
						
					}
					catch(Exception ex){
						
					}     }
                      if(e.getSource()==btncdrom){
					
					try{
						dispose();
						InterfaceCDRom ab=new InterfaceCDRom();
						ab.setVisible(true);
						
					}
					catch(Exception ex){
						
					}     }
                      if(e.getSource()==btnjournal){
      					
      					try{
      						dispose();
      						InterfaceJournale ab=new InterfaceJournale();
      						ab.setVisible(true);
      						
      					}
      					catch(Exception ex){
      						
      					}     }
                      if(e.getSource()==btnmicrof){
      					
      					try{
      						dispose();
      						InterfaceMicrofilm ab=new InterfaceMicrofilm();
      						ab.setVisible(true);
      						
      					}
      					catch(Exception ex){
      						
      					}     }
	
                      if(e.getSource()==btnNotif){
        					
        					try{
        						dispose();
        						NotificationUser ab=new NotificationUser();
        						ab.setVisible(true);
        						
        					}
        					catch(Exception ex){
        						
        					}     }
                      if(e.getSource()==btnlogout){
      					
      					try{
      						dispose();
      						Lecteur ab=new Lecteur();
      						ab.setVisible(true);
      						
      					}
      					catch(Exception ex){
      						
      					}     }
  	
                      
	
	}

	public static void main(String[] args) {
		new InterfaceUser();	}

}

