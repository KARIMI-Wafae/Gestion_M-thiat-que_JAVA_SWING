package TESTBIBLIO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Créerunmicrofilm extends JFrame implements ActionListener{

	static Connection conction=null;
	static String databaseName="";
	static String url="jdbc:mysql://localhost:3306/"+databaseName;
	static String username="root";
	static String password="ertdfgcvb";
	///
	
	

JLabel ltitre = new  JLabel("TITRE :") ;
JTextField ttitre=new  JTextField();
JLabel ldate = new  JLabel("DATE:") ;
JTextField tdate=new  JTextField();
//JButton  btnvalider = new JButton("Valider",new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\Application java\\src\\Applicationjava\\jaccepte.png"));

//JButton btnannuler = new JButton("Annuler",new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\Application java\\src\\Applicationjava\\annulation.png"));
JPanel BTNcon= new JPanel();
JPanel textecon= new JPanel();
JPanel contenu= new JPanel();
JButton btnAjouter = new JButton("AJOUTER");
JButton btnprecedent = new JButton("PRECEDENT");

Créerunmicrofilm(){
setTitle("ESPACE CREATION MICRO FILM :");
setSize(700, 500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
BTNcon.add(btnAjouter);
BTNcon.add(btnprecedent);
btnAjouter.addActionListener(this);
btnprecedent.addActionListener(this);
  
  
contenu.add(BTNcon);
BTNcon.setBackground(Color.decode("#444f70") );
contenu.setBackground(Color.decode("#444f70") );
contenu.setBorder(new TitledBorder("CREER UN MICRO FILM "));
add(contenu);
textecon.setPreferredSize(new Dimension(400,250));
textecon.setBackground(Color.decode("#9683ec"));
textecon.setBorder(new TitledBorder("REMPLIRE LES CHAMPS "));

	

textecon.add(ltitre);
textecon.add(ttitre);
textecon.add(ldate);
textecon.add(tdate);
textecon.setLayout(null);
ltitre.setBounds(90, 30, 90, 20);
ttitre.setBounds(155, 30, 120, 20);
ldate.setBounds(90, 80, 90, 20);
tdate.setBounds(155, 80, 120, 20);

contenu.add(textecon);

 GridLayout gb=new GridLayout(1,2);
 gb.setHgap(5);
 BTNcon.setLayout(gb);
 BTNcon.setPreferredSize(new Dimension(250,40));  
 this.setLocationRelativeTo(null);


}


public static void main(String[] args) {
// TODO Auto-generated method stub
Créerunmicrofilm cr= new Créerunmicrofilm();
cr.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==btnAjouter) {
		 try {
			 
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				conction=DriverManager.getConnection(url,username,password);
				if(ttitre.getText().equals("")||tdate.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs" );}
				else {
				PreparedStatement ps=conction.prepareStatement("INSERT INTO `bibliotheque`.`document`(`type`,`titre`,`date`) VALUES('MICROFILM',?,?);");
				ps.setString(1, ttitre.getText());
				ps.setDate(2, java.sql.Date.valueOf(tdate.getText()));
				ps.execute();
				conction.close();
				JOptionPane.showMessageDialog(null,"microfilm crée" );
				}
				
			 }catch(Exception ev){
				JOptionPane.showConfirmDialog(null,"microfilm non crée  verifier format date yyyy-mm-dd ");
					
			 }
	}
if(e.getSource()==btnprecedent) {
	 Employe employe=new Employe();
	  dispose();

employe.setVisible(true);
	}
}



}
