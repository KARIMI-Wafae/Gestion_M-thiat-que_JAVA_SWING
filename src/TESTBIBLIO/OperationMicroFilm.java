package TESTBIBLIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.awt.GridLayout;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class OperationMicroFilm extends JFrame implements ActionListener{
	 JButton btnLire=new JButton("Lire");
	 JButton btnAcheter=new JButton("Acheter");
	 JButton btnPrecedent=new JButton("Précédent");
	public OperationMicroFilm() {
	super("Espace employe");
	
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Espace Emplyé");

	 //panel.setLayout(new GridLayout(2,1)) ;
	 this.setContentPane(panel);
	 this.add(label);
    ImageIcon icone = new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\microfilm.jpeg");
     panel.setLayout(null);
	 JLabel image = new JLabel(icone);
	 this.add(image);
	 
	 btnPrecedent.addActionListener(this);
	 

	 btnLire.setBounds(400,150,150,30);
	 btnAcheter.setBounds(400,200,150,30);
	 btnPrecedent.setBounds(500,400,150,30);
	 image.setBounds(100,80,250,250);
	 //btnLire.setForeground(Color.BLACK);pour changer la couleur de l'ecreture a l'interirur de btn
	 //btnLire.setBackground(Color.lightGray );
	 
	 panel.add(btnLire) ;
	 panel.add(btnAcheter) ;
	 panel.add(btnPrecedent) ;
	
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	 this.setSize(700, 550);
	 this.setLocation(340,90);
	 this.setVisible(true);
	 panel.setBackground(Color.LIGHT_GRAY);
	 btnLire.addActionListener(new ActionListener()
	 {
	   public void actionPerformed(ActionEvent e)
	   {
		   AchatMicrofilm f1=new AchatMicrofilm();
	  
	   }
	 } );//fin listener
	 
	 btnAcheter.addActionListener(new ActionListener()
	 {
	   public void actionPerformed(ActionEvent e)
	   {
		   AchatMicrofilm f1=new AchatMicrofilm();
	  
	   }
	 } );
	}

	public static void main(String[] args) {
		new OperationMicroFilm();	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPrecedent){
			dispose();
			Employe lv=new Employe();
			lv.setVisible(true);
		}
		
	}

}

