package TESTBIBLIO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class modifierfichlecteur  extends JFrame implements ActionListener{
	static Connection conction=null;
	static String databaseName="";
	static String url="jdbc:mysql://localhost:3306/"+databaseName;
	static String username="root";
	static String password="ertdfgcvb";
	///
	

JLabel lnum = new  JLabel("NUMERO DE FICHE :") ;
JTextField tnum=new  JTextField();
JLabel lnom = new  JLabel("NOM LECTEUR:") ;
JTextField tnom=new  JTextField();
JLabel lprenom = new  JLabel("PRENOM LECTEUR:") ;
JTextField tprenom=new  JTextField();
JLabel ladresse = new  JLabel("ADRESSE :") ;
JTextField tadresse=new  JTextField();
JLabel lemail = new  JLabel("EMAIL :") ;
JTextField temail=new  JTextField();
JLabel llogin = new  JLabel("LOGIN :") ;
JTextField tlogin=new  JTextField();
JLabel lmotdepasse = new  JLabel("MOT DE PASSE:") ;
JTextField tmotdepasse=new  JTextField();

JPanel BTNcon= new JPanel();
JPanel textecon= new JPanel();
JPanel contenu= new JPanel();
JButton btnmodifier = new JButton("MODIFIER",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\bouton-modifier.png"));
JButton btnprecedent = new JButton("PRECEDENT",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\precedent.png"));
JButton btnrechercher = new JButton("RECHERCHER",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\moteur-de-recherche.png"));
modifierfichlecteur(){
	setTitle("ESPACE CREATION :");
	setSize(700, 500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	btnmodifier.setBackground(Color.LIGHT_GRAY);
	btnprecedent.setBackground(Color.LIGHT_GRAY);
	btnmodifier.setBorder(BorderFactory.createBevelBorder(0)); 
	btnprecedent.setBorder(BorderFactory.createBevelBorder(0)); 
	btnrechercher.setBorder(BorderFactory.createBevelBorder(0)); 
	BTNcon.add(btnmodifier);
	BTNcon.add(btnprecedent);
	
	  btnprecedent.addActionListener(this);
	
	
	contenu.add(BTNcon);
	BTNcon.setBackground(Color.decode("#444f70") );
	contenu.setBackground(Color.decode("#444f70") );
	contenu.setBorder(new TitledBorder("CREER UN LIVRE "));
	add(contenu);
	textecon.setPreferredSize(new Dimension(600,350));
	textecon.setBackground(Color.decode("#9683ec"));
	textecon.setBorder(new TitledBorder("REMPLIRE LES CHAMPS "));

		
	textecon.add(btnrechercher);
	textecon.add(lnum);
	textecon.add(tnum);
	textecon.add(lnom);
	textecon.add(tnom);
	textecon.add(lprenom);
	textecon.add(tprenom);
	textecon.add(ladresse);
	textecon.add(tadresse);
	
	textecon.add(lemail);
	textecon.add(temail);
	textecon.add(llogin);
	textecon.add(tlogin);
	textecon.add(lmotdepasse);
	textecon.add(tmotdepasse);
	textecon.setLayout(null);
	btnrechercher.setBounds(430, 30, 140, 30);
	lnum.setBounds(90, 30, 120, 20);
	tnum.setBounds(270, 30, 140, 30);
	lnom.setBounds(90, 80, 120, 20);
	tnom.setBounds(270, 80, 140, 30);
	lprenom.setBounds(90, 120, 120, 20);
	tprenom.setBounds(270, 120, 140, 30);
	ladresse.setBounds(90, 160, 120, 20);
	tadresse.setBounds(270, 160, 140, 30);
	lemail.setBounds(90, 200,120 , 20);
	temail.setBounds(270, 200,140 , 30);
	llogin.setBounds(90,  240,120, 20);
	tlogin.setBounds(270, 240,140 , 30);
	lmotdepasse.setBounds(90, 280, 120, 20);
	tmotdepasse.setBounds(270, 280, 140, 30);
	contenu.add(textecon);
	
	
	 GridLayout gb=new GridLayout(1,2);
	 gb.setHgap(5);
	 BTNcon.setLayout(gb);
	 BTNcon.setPreferredSize(new Dimension(350,40)); 
	 btnmodifier.addActionListener(this);
	 btnrechercher.addActionListener(this);
	 this.setLocationRelativeTo(null);
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	modifierfichlecteur cr= new modifierfichlecteur();
	cr.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource()==btnmodifier) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conction=DriverManager.getConnection(url,username,password);
			int jml = Integer.parseInt(tnum.getText());
			PreparedStatement ps=conction.prepareStatement("UPDATE  `bibliotheque`.`fiche_lecteur`  SET `nom_user`='"+tnom.getText()+"',`prenom_user`='"+tprenom.getText()+"', `adresse`='"+tadresse.getText()+"', `email`='"+temail.getText()+"', `login`='"+tlogin.getText()+"', `motDePasse`='"+tmotdepasse.getText()+"' where `id_fiche`="+jml+";");
			
			ps.execute();
			conction.close();
			JOptionPane.showMessageDialog(null,"la fiche modifiée" );
			
			
		 }catch(Exception ev){
			JOptionPane.showConfirmDialog(null,"la fiche non modifié ");
			//System.out.println(e.getMessage());	
		 }
	}
if (e.getSource()==btnrechercher) {
	try {
		 
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		conction=DriverManager.getConnection(url,username,password);
		int jml = Integer.parseInt(tnum.getText());
		String qr="select * FROM `bibliotheque`.`fiche_lecteur` WHERE `id_fiche`="+jml+";";
		
		java.sql.Statement rs=conction.createStatement();
		ResultSet resultat=rs.executeQuery(qr);
		if(resultat.next()) {
			tnum.setText(resultat.getString(1)); 
			tnom.setText(resultat.getString(2));
			tprenom.setText(resultat.getString(3));
			tadresse.setText(resultat.getString(4));
			temail.setText(resultat.getString(5));
			tlogin.setText(resultat.getString(6));
			tmotdepasse.setText(resultat.getString(7));
		}
		else {
			JOptionPane.showMessageDialog(null,"la fiche n'éxiste pas ");
		}
	
		conction.close();
	 }catch(Exception ex){
		JOptionPane.showMessageDialog(null,"la fiche n'éxiste pas");
			
	 }
		
	}
if (e.getSource()==btnprecedent) {
	Employe employe=new Employe();
	  dispose();

employe.setVisible(true);
}
}

}
