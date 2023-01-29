package TESTBIBLIO;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AcheterJournal extends JFrame {

	
	public AcheterJournal() {
	this.setLayout(null);
	this.setLocation(340,90);
	JButton btnAcheter=new JButton("Acheter");
	JButton btnPrecedent=new JButton("Précédent");
	JLabel label1=new JLabel();       
	JLabel label2=new JLabel();       
	JLabel label3=new JLabel();
	JLabel label4=new JLabel();
	JLabel label5=new JLabel();
	JLabel label6=new JLabel();
	JLabel lb=new JLabel();
	lb.setFont(new Font("Arial",Font.BOLD,20));
	lb.setText("Acheter Journal");
	label1.setText("N° Lecteur :");
	label2.setText("Nom Lecteur :");
	label3.setText("Cote :");
	label4.setText("Titre :");
	label5.setText("Auteur :");
	label6.setText("Date :");
	
	btnAcheter.setBounds(560,400,100,30);
	btnPrecedent.setBounds(450,400,100,30);

	this.add(btnAcheter) ;
	this.add(btnPrecedent) ;
	

    final JTextField text1 = new JTextField();
    final JTextField text2 = new JTextField();
    final JTextField text3 = new JTextField();
    final JTextField text4 = new JTextField();
    final JTextField text5 = new JTextField();
    final JTextField text6 = new JTextField();
    text1.setBounds(200,70,200,28);
    text2.setBounds(200,110,200,28);
    text3.setBounds(200,150,200,28);
    text4.setBounds(200,190,200,28);
    text5.setBounds(200,230,200,28);
    text6.setBounds(200,270,200,28);
    
    label1.setBounds(110,70,200,28);
    label2.setBounds(110,110,200,28);
    label3.setBounds(110,150,200,28);
    label4.setBounds(110,190,200,28);
    label5.setBounds(110,230,200,28);
    label6.setBounds(110,270,200,28);
    
    lb.setBounds(260,20,180,25);
    
    this.add(text1); 
    this.add(text2);
    this.add(text3); 
    this.add(text4); 
    this.add(text5); 
    this.add(text6); 
    
    this.add(label1);
    this.add(label2);
    this.add(label3);
    this.add(label4);
    this.add(label5);
    this.add(label6);
    this.add(lb);
    
     
	
	 this.setVisible(true);
	 this.setSize(700, 550);
	 
	 this.getContentPane().setBackground(Color.LIGHT_GRAY);
	 btnPrecedent.addActionListener(
			 new ActionListener()
	  {
	   public void actionPerformed(ActionEvent e)
	   {   dispose();
		   OperationJournale f1=new OperationJournale();
	  
	   }
	  } );//fin listener
	 
	 btnAcheter.addActionListener(
			 new ActionListener()
	  {
				 public void actionPerformed(ActionEvent e) {
					 String num,nom,cote,titre,auteur,date;
						num=text1.getText();
						nom=text2.getText();
						cote=text3.getText();
						titre=text4.getText();
						auteur=text5.getText();
						date=text6.getText();
						String qr3="SELECT * from `bibliotheque`.`journal` where`cote`="+cote+" ;";;
						String qr="INSERT INTO  `bibliotheque`.`achat_journal`(`num_user`,`nom_user`,`cote`,`titre`,`auteur`,`date_achat`)"+"values('"+num+"','"+nom+"','"+cote+"','"+titre+"','"+auteur+"','"+date+"')";
						String qr2="DELETE from bibliotheque.journal where cote=cote";
						if(num.equals("")||nom.equals("")||cote.equals("")||titre.equals("")||date.equals("")) {
							JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs!!" );}
	 try
     {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","ertdfgcvb");
  
            PreparedStatement ps= con.prepareStatement(qr);
			PreparedStatement ps2= con.prepareStatement(qr2);
			java.sql.Statement stmt = con.createStatement();
			ResultSet résultats = stmt.executeQuery(qr3);
			if(résultats.next()) {
				int status=ps.executeUpdate();
				int status2=ps2.executeUpdate();
				if(status !=0)
				{
					JOptionPane.showMessageDialog(null,"Achat effectué !");
					
				}
				if(status2 !=0)
				{
					JOptionPane.showMessageDialog(null,"JOURNAL supprimé !");
					
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"JOURNAL n'existe pas !");
			}
       
     }
     catch(Exception ex)
     {
         System.out.println(ex);
     }
				 }});
	
	

	 
	
}
	
	public static void main(String[] args) {
		
		AcheterJournal op=new AcheterJournal();
	}

}
