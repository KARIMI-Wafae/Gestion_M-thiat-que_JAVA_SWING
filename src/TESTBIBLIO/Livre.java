package TESTBIBLIO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Livre extends JFrame implements ActionListener {
	JLabel lb1,lb2,lb3,lb4,lb5,lbtitre;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JButton bt1,bt2,bt3,bt4,bt5,bt6,babonne,bpret;
	ResultSet rst;
	Statement st;
	JPanel j1,pn1;
	
	public Livre(){
		this.setTitle("Espace Employe");
		this.setSize(700,550);
		this.setLocationRelativeTo(null);
		
		ImageIcon icone = new ImageIcon("C:\\Users\\user\\Downloads\\livre.jpg");
	     JLabel image = new JLabel(icone);
	     image.setPreferredSize(new Dimension(200,200)); 
	     
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(0xF0EEBD));
		
		//titre
				lbtitre=new JLabel("Operations sur livres");
				lbtitre.setBounds(250,10,300,30);
				lbtitre.setFont(new Font("Arial",Font.BOLD,20));
				pn.add(lbtitre);
				add(pn);
				
				
				
		bt2=new JButton("Acheter");
		bt2.setBounds(250,120,110,30);
		bt2.setSize(200,50);
		bt2.addActionListener(this);
		pn.add(bt2);
		
		bt3=new JButton("Restituer");
		bt3.setBounds(250,300,110,30);
		bt3.setSize(200,50);
		bt3.addActionListener(this);
		pn.add(bt3);
		
		bt5=new JButton("Emprunter");
		bt5.setBounds(250,205,110,30);
		bt5.setSize(200,50);
		bt5.addActionListener(this);
		pn.add(bt5);
		
		bt6=new JButton("Précèdent");
		bt6.setBounds(540,450,110,30);
		bt6.addActionListener(this);
		pn.add(bt6);
	
		
	}

	public static void main(String[] args) {
	
    Livre lv=new Livre();
    lv.setVisible(true);
	}
@Override
	public void actionPerformed(ActionEvent e) {
			//Acheter
			if(e.getSource()==bt2){
				
				try{
					dispose();
					Acheter ab=new Acheter();
					ab.setVisible(true);
					
				}
				catch(Exception ex){
					
				}
					
				}
			//Emprunter
			if(e.getSource()==bt5){
				
				try{
					dispose();
					Emprunter ab=new Emprunter();
					ab.setVisible(true);
					
				}
				catch(Exception ex){
					
				}
					
				}
		if(e.getSource()==bt3){
				
				try{
					dispose();
					Restituer ab=new Restituer();
					ab.setVisible(true);
					
				}
				catch(Exception ex){
					
				}
					
				}
		if(e.getSource()==bt6){
			
			try{
				dispose();
				Employe ab=new Employe();
				ab.setVisible(true);
				
			}
			catch(Exception ex){
				
			}
				
			}
		}

}
