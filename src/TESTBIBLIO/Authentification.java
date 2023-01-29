package TESTBIBLIO;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Authentification extends JFrame implements ActionListener {
	
	JLabel lbtitre;
	JButton btn;
	JPanel pn,pn2,pn3,pn4;
	final JComboBox<String> cb ;
	
	public Authentification(){
		this.setTitle("Gestion Médiathèque");
		this.setSize(700,550);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(0x81F6AF));
		
		   ImageIcon icone = new ImageIcon("C:\\Users\\user\\Downloads\\livre.jpg");
	       JLabel image = new JLabel(icone);
	       image.setPreferredSize(new Dimension(400,300));
	       
	       
		pn=new JPanel();
		pn2=new JPanel();
		pn3=new JPanel();
		pn4=new JPanel();
		pn2.setPreferredSize(new Dimension(400,400));
		pn2.setBackground(new Color(0xCEF0BD));//EAE796
		
		pn3.setPreferredSize(new Dimension(400,300));
		pn3.setBackground(new Color(0xCEF0BD));
		pn4.setPreferredSize(new Dimension(400,10));
		pn4.setBackground(new Color(0xCEF0BD));//EAE796
		
		pn.setBounds(500, 500, 500, 500);
		pn.setPreferredSize(new Dimension(700,500));

		pn.setBackground(new Color(0xF0EEBD));
		pn3.add(image);
		Border myborder = BorderFactory.createLineBorder(Color.black, 1); 
		pn3.setBorder(myborder);
		
		
		
		//titre
				lbtitre=new JLabel("Veuillez choisir votre profil pour se connecter");
				lbtitre.setAlignmentX(Component.CENTER_ALIGNMENT);
				lbtitre.setFont(new Font("Arial",Font.BOLD,20));
				lbtitre.setBackground(Color.black);
				pn.add(lbtitre);
				this.add(pn);
				pn2.add(pn3);
				pn.add(pn2);
		
		String[] choices = {"Admin","Employé","Lecteur","Bibliothécaire"};
		cb = new JComboBox<String>(choices);
		cb.setPreferredSize(new Dimension(200,40));
		cb.setBackground(new Color(0xCEF0BD));
	    cb.setForeground(Color.black);
	    cb.setFont(new Font("ITALIC",Font.BOLD,15));
		cb.setMaximumSize(cb.getPreferredSize());
		cb.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		cb.setAlignmentX(Component.CENTER_ALIGNMENT);
		pn2.add(cb);
		pn2.add(pn4);
		
	    
		btn = new JButton("Se connecter");
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn.setBounds(60,300,300,30);
		btn.addActionListener(this);
		pn2.add(btn);
		
	}

	public static void main(String[] args) throws IOException {
		Authentification cd=new Authentification();
		    cd.setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn){
		String t =cb.getSelectedItem().toString();
			if( t.equals("Admin")) {
				dispose();
				Administrateur ab=new Administrateur();
				ab.setVisible(true);
			}
			else if(t.equals("Employé")) {
				dispose();
				Employe_auth ab=new Employe_auth();
				ab.setVisible(true);
			}
			else if(t.equals("Lecteur")) {
				dispose();
				Lecteur ab=new Lecteur();
				ab.setVisible(true);
			}
			else if(t.equals("Bibliothécaire")) {
				dispose();
				Bibliothecaire ab=new Bibliothecaire();
				ab.setVisible(true);
			}
		}
		
	}

}
