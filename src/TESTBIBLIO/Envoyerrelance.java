package TESTBIBLIO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Envoyerrelance extends JFrame implements ActionListener{
	static Connection conction=null;
	static String databaseName="";
	static String url="jdbc:mysql://localhost:3306/"+databaseName;
	static String username="root";
     static String password="ertdfgcvb";
	///
	

JLabel lnum = new  JLabel("Numero User :") ;
JTextField tnum=new  JTextField();
JLabel lnom = new  JLabel("Nom User:") ;
JTextField tnom=new  JTextField();
JLabel lmessage = new  JLabel("Message:") ;
JTextField tmessage=new  JTextField();
JLabel ltitredocument = new  JLabel("Titre document:") ;
JTextField ttitredocument=new  JTextField();


JPanel BTNcon= new JPanel();
JPanel textecon= new JPanel();
JPanel contenu= new JPanel();
JButton btnAjouter = new JButton("Envoyer",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\envoyerelan.png"));
JButton btnprecedent = new JButton("Précedent",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\precedentbiblio.png"));

Envoyerrelance(){
setTitle("ESPACE RELANCE :");
setSize(700, 500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
BTNcon.add(btnAjouter);
BTNcon.add(btnprecedent);
  
btnAjouter.addActionListener(this);
btnprecedent.addActionListener(this);


contenu.add(BTNcon);
BTNcon.setBackground(Color.decode("#925aa9") );
contenu.setBackground(Color.decode("#925aa9") );
contenu.setBorder(new TitledBorder("CREER UN LIVRE "));
add(contenu);
this.setLocationRelativeTo(null);

textecon.setPreferredSize(new Dimension(600,300));
textecon.setBackground(Color.decode("#dabab9"));
textecon.setBorder(new TitledBorder("REMPLIRE LES CHAMPS "));

btnAjouter.setBackground(Color.decode("#e2e2e2"));
btnprecedent.setBackground(Color.decode("#e2e2e2"));
textecon.add(lnum);
textecon.add(tnum);
textecon.add(lnom);
textecon.add(tnom);
textecon.add(lmessage);
textecon.add(tmessage);
textecon.add(ltitredocument);
textecon.add(ttitredocument);
textecon.setLayout(null);
lnum.setBounds(170, 40, 100, 20);
tnum.setBounds(280, 40, 140, 20);
lnom.setBounds(170, 90, 90, 20);
tnom.setBounds(280, 90, 140, 20);
lmessage.setBounds(170, 140, 90, 20);
tmessage.setBounds(280, 140, 140, 20);
ltitredocument.setBounds(170, 190, 90, 20);
ttitredocument.setBounds(280, 190, 140, 20);
btnAjouter.setBorder(BorderFactory.createBevelBorder(0));
btnprecedent.setBorder(BorderFactory.createBevelBorder(0));
contenu.add(textecon);
// contenu.setLayout(null);
 GridLayout gb=new GridLayout(1,2);
 gb.setHgap(20);
 BTNcon.setLayout(gb);
 BTNcon.setPreferredSize(new Dimension(350,50));  


}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Envoyerrelance r=new Envoyerrelance();
r.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnprecedent) {
			dispose();
			Bibliothécaire bibliothécaire= new Bibliothécaire();
			bibliothécaire.setVisible(true);
		}
		if(e.getSource()==btnAjouter) {
			try {
				 
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				conction=DriverManager.getConnection(url,username,password);
				if(tnum.getText().equals("")||tnom.getText().equals("")||tmessage.getText().equals("")||ttitredocument.getText().equals("")) {
					
					JOptionPane.showMessageDialog(this,"Veuillez remplir tous les champs" );}
				else {
				PreparedStatement ps=conction.prepareStatement("INSERT INTO `bibliotheque`.`relance`(`message`,`num_user`,`nom_user`,`titre`) VALUES('"+tmessage.getText()+"',"+Integer.parseInt(tnum.getText())+",'"+tnom.getText()+"','"+ttitredocument.getText()+"');");
			
				ps.execute();
				conction.close();
				JOptionPane.showMessageDialog(this," relance envoyée" );}
				
			 }catch(Exception ev){
				JOptionPane.showConfirmDialog(this,"relance non envoyée");
				//System.out.println(ev.getMessage());	
			 }
			
		}
		
	}

}
