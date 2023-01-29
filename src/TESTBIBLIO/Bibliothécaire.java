package TESTBIBLIO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Bibliothécaire extends JFrame implements ActionListener {
    //JLabel icon=new JLabel(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\Application java\\src\\Applicationjava\\Bibliothécaire.java"));
	
	JPanel contenu= new JPanel();
	JPanel contenant= new JPanel();
	JButton btnconsulteretat = new JButton("Consulter etat des prets",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\consulterpret1.png"));
	JButton btndeconnecter = new JButton("DECONNECTER",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\Logout.png"));
	JButton btnenvoyerrelance = new JButton("Envoyer relance",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\envoyer-le-message.png"));
	Bibliothécaire(){
		contenant.setLayout(null);		
		contenu.setLayout(null);
		setSize(700,500);
		setTitle("ESPACE BIBLIOTHECAIRE :");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//btnconsulteretat.setPreferredSize(new Dimension(50,50));
		contenant.setBackground(Color.decode("#444f70"));
		//contenu.setBackground(Color.decode("#9683ec") );
		contenu.setBackground(Color.decode("#925aa9"));
		btndeconnecter.setBorder(BorderFactory.createBevelBorder(0));
		//contenu.setBackground(Color.LIGHT_GRAY);
		btnconsulteretat.setBorder(BorderFactory.createBevelBorder(0));
		btnenvoyerrelance.setBorder(BorderFactory.createBevelBorder(0));
		btndeconnecter.setBackground(Color.decode("#925aa9"));
		btnconsulteretat.setBackground(Color.decode("#925aa9"));
		contenu.setBorder(new TitledBorder("ESPACE BIBLIOTHECAIRE "));
		contenu.add(btndeconnecter);
		this.setLocationRelativeTo(null);
		//contenu.setBounds(200, 200,400, 300);
		//contenu.setPreferredSize(new Dimension(600,350));
		btnconsulteretat.setBounds(200, 180, 300, 60);
	    btnenvoyerrelance.setBounds(200, 260,300, 60);
	    btndeconnecter.setBounds(500, 30, 200, 47);
	    
	    contenu.setBounds(0, 0,700, 80);
	    
	    btndeconnecter.addActionListener(this);

	    btnconsulteretat.addActionListener(this);
	    btnenvoyerrelance.addActionListener(this);
		contenant.add(btnenvoyerrelance);
		contenant.add(btnconsulteretat);
		contenant.add(contenu);
		
		
		//GridLayout L =new GridLayout(2,1);
		//L.setVgap(100);
		//L.setHgap(100);
		//contenu.setLayout(L);
      //contenant.add(contenu);

	add(contenant);
	
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Bibliothécaire bibliothécaire= new Bibliothécaire();
bibliothécaire.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btndeconnecter) {
			
		}
if(e.getSource()==btnconsulteretat) {
	dispose();
	Consulteretatpret c= new Consulteretatpret();
	c.setVisible(true);
		}
if(e.getSource()==btnenvoyerrelance) {
	dispose();
	Envoyerrelance r=new Envoyerrelance();
	r.setVisible(true);
}
if(e.getSource()==btndeconnecter) {
	dispose();
	Bibliothecaire r=new Bibliothecaire();
	r.setVisible(true);
}
	}

}
