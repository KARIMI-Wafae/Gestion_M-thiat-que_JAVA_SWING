package TESTBIBLIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CDROM extends JFrame implements ActionListener {
	JLabel lb1,lb2,lb3,lb4,lb5,lbtitre;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JButton bt1,bt2,bt3,bt4,bt5,bt6,babonne,bpret;
	ResultSet rst;
	Statement st;

	
	public CDROM(){
		this.setTitle("Espace Employe");
		this.setSize(700,550);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(0xF0EEBD));
		//setForeground(Color.black);
		add(pn);
		//titre
				lbtitre=new JLabel("Operations sur CD-ROM");
				lbtitre.setBounds(232,10,300,30);
				lbtitre.setFont(new Font("Arial",Font.BOLD,20));
				pn.add(lbtitre);
		//label
/*		lb1=new JLabel("Identifiant");
		lb1.setBounds(30,50,100,30);
		pn.add(lb1);
		tf1=new JTextField();
		tf1.setBounds(100,50,100,30);
		pn.add(tf1);
		//
		lb2=new JLabel("Titre");
		lb2.setBounds(30,90,100,30);
		pn.add(lb2);
		
		tf2=new JTextField();
		tf2.setBounds(100,90,200,30);
		pn.add(tf2);
		//
		pn.add(tf2);
		//button
		bt1=new JButton("Insertion");
		bt1.setBounds(50,130,90,30);
		bt1.addActionListener(this);
		pn.add(bt1);
*/		
		bt2=new JButton("Acheter");
		bt2.setBounds(250,90,110,30);
		bt2.setSize(200,50);
		bt2.addActionListener(this);
		pn.add(bt2);
		
		bt5=new JButton("Emprunter");
		bt5.setBounds(250,175,110,30);
		bt5.setSize(200,50);
		bt5.addActionListener(this);
		pn.add(bt5);
		
		bt3=new JButton("Restituer");
		bt3.setBounds(250,260,110,30);
		bt3.setSize(200,50);
		bt3.addActionListener(this);
		pn.add(bt3);
		
		
		
		bt4=new JButton("Lire");
		bt4.setBounds(250,345,110,30);
		bt4.setSize(200,50);
		bt4.addActionListener(this);
		pn.add(bt4);
		
	/*	bt4=new JButton("Emprunter");
		bt4.setBounds(200,50,100,30);
		bt4.addActionListener(this);
		pn.add(bt4);
	*/	
		
		
		bt6=new JButton("Précèdent");
		bt6.setBounds(540,450,110,30);
		bt6.addActionListener(this);
		pn.add(bt6);
		}
		

	/*public static void main(String[] args) {
		 CDROM cd=new CDROM();
		    cd.setVisible(true);

	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt2){
			
			try{
				dispose();
				AcheterCDrom ab=new AcheterCDrom();
				ab.setVisible(true);
				
			}
			catch(Exception ex){
				
			}
				
			}
		//Emprunter
		if(e.getSource()==bt5){
			
			try{
				dispose();
				EmprunterCDrom ab=new EmprunterCDrom();
				ab.setVisible(true);
				
			}
			catch(Exception ex){
				
			}
				
			}
		//RestituerCDrom
	if(e.getSource()==bt3){
			
			try{
				dispose();
				RestituerCDrom ab=new RestituerCDrom();
				ab.setVisible(true);
				
			}
			catch(Exception ex){
				
			}
	}
	//Lecture CD-ROM 
	if(e.getSource()==bt4){
		
		try{
			dispose();
			LireCDrom ab=new LireCDrom();
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
