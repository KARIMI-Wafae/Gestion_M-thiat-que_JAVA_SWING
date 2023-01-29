package TESTBIBLIO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
public class Employe extends  JFrame  implements ItemListener, ActionListener {
    String[] demandes = {"les choix ","Créer un lecteur", "supprimer un lecteur", "Créer document ", "Supprimer document", "modifier fiches lecteurs","afficher la liste lecteurs"};
	Creeruser framecreeruser = new Creeruser();
	SupprimerUser framesupprimeruser = new SupprimerUser();
	Choixtypedocument framesChoixtypedocument = new Choixtypedocument();
	supprimerundocument supprimerundocument= new supprimerundocument();
	modifierfichlecteur modifierunefiche= new modifierfichlecteur();
	AfficherListeLecteurs liste_lecteurs= new AfficherListeLecteurs();
	
	
	 	JButton btn1 = new JButton("Livre",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\book-1.png"));
	    JButton btn2 = new JButton("CDRom",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\Cd_ROM.png")); 
	    JButton btn3 = new JButton("Journal",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\journal.png"));
	    JButton btn4 = new JButton("Micro Film",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\microfilm.png"));
	    JButton btn5 = new JButton("Déconnecter",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\Logout.png"));
	  
	    JButton btn6 = new JButton("Operation sur livre");
	    JButton btn7 = new JButton("Operation sur CDROM");
	    JButton btn8 = new JButton("Operation sur journal ");
	    JButton btn9 = new JButton("Operation sur microfilm ");
	
    JComboBox cb ;
   // Container c;
	
	
	Employe(){
		getContentPane().setBackground(Color.decode("#9683ec"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		setTitle("ESPACE EMPLOYE");
		setLayout(new BorderLayout(180,20));
		
		this.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("ESPACE EMPLOYE                                                                 ");
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel1.setBackground(Color.decode("#9683ec") );
		panel1.setBackground(Color.decode("#9683ec") );
		panel2.setBackground(Color.decode("#9683ec") );
		panel3.setBackground(Color.decode("#9683ec") );
		
	 panel.setLayout(new GridLayout(4, 1));
	GridLayout l= new GridLayout(4, 1);
	 l.setVgap(50);
	
	 panel2.setLayout(l);
	 
	   
	  btn6.setBorder(BorderFactory.createBevelBorder(0)); 
	  btn7.setBorder(BorderFactory.createBevelBorder(0)); 
	  btn8.setBorder(BorderFactory.createBevelBorder(0)); 
	  btn9.setBorder(BorderFactory.createBevelBorder(0)); 
	  btn5.setBorder(BorderFactory.createBevelBorder(0)); 
	 
	    btn1.addActionListener(this);
	    btn2.addActionListener(this);
	    btn3.addActionListener(this);
	    btn4.addActionListener(this);
	    btn5.addActionListener(this);
	    btn6.addActionListener(this);
	    btn7.addActionListener(this);
	    btn8.addActionListener(this);
	    btn9.addActionListener(this);
	   

	  
	    
	    panel.add(btn1); 
        panel.add(btn2);
        panel.add(btn3); 
        panel.add(btn4);
      
    	btn1.setBackground(Color.decode("#a9c4ff"));
    	btn2.setBackground(Color.LIGHT_GRAY);
    	btn4.setBackground(Color.WHITE);
    	btn3.setBackground(Color.decode("#87a4ee"));
    	//btn6.setBackground(Color.red);
    	btn6.setBackground(Color.decode("#9db9ff"));
    	btn5.setBackground(Color.decode("#444f70"));
    	
    	btn7.setBackground(Color.LIGHT_GRAY);
    	btn9.setBackground(Color.WHITE);
    	btn8.setBackground(Color.decode("#4672e5"));
    
     
        add(panel1,BorderLayout.NORTH);
        add(panel,BorderLayout.WEST);
        add(panel2,BorderLayout.CENTER);
        add(panel3,BorderLayout.EAST);
		cb=new JComboBox(demandes);
		
		
		panel1.add(label1);
		panel1.add(cb);
		panel1.add(btn5);
		panel2.add(btn6); 
	    panel2.add(btn7);
	    panel2.add(btn8); 
	    panel2.add(btn9);
	    
   	cb.addItemListener(this);
   	
	    
 
      //setBackground(Color.black);
  
   
     }
       public void itemStateChanged(ItemEvent i) {
    	   cb.setBackground(Color.red);
   		int choix =cb.getSelectedIndex();
   		switch(choix) {
   		case 0: ; break;
   		case 1: dispose();
   		framecreeruser.setVisible(true); break;
   		case 2: dispose();framesupprimeruser.setVisible(true); break;
   		case 3: framesChoixtypedocument.setVisible(true); break;
        case 4: supprimerundocument.setVisible(true); break;
        case 5: dispose();modifierunefiche.setVisible(true); break;
        case 6: dispose();liste_lecteurs.setVisible(true); break;
   		
   		}
		
	}
	
	
    public static void main(String[] args) 
    {
      Employe frame = new Employe();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        frame.setVisible(true);
        
       
     
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1){
			dispose();
			AfficherLivres lv=new AfficherLivres();
			lv.setVisible(true);
		}
		if(e.getSource()==btn2){
			dispose();
			AfficherCDrom cd=new AfficherCDrom();
			cd.setVisible(true);
		}
		if(e.getSource()==btn3){
			dispose();
			AfficherJournaux lv=new AfficherJournaux();
			lv.setVisible(true);
		}
		if(e.getSource()==btn4){
			dispose();
			AfficherMicroFilm lv=new AfficherMicroFilm();
			lv.setVisible(true);
		}
		
		if(e.getSource()==btn5){
			dispose();
			Employe_auth lv=new Employe_auth();
			lv.setVisible(true);
		}
		
		
		if(e.getSource()==btn6){
			dispose();
			Livre lv=new Livre();
			lv.setVisible(true);
		}
		if(e.getSource()==btn7){
			dispose();
			CDROM lv=new CDROM();
			lv.setVisible(true);
		}
		if(e.getSource()==btn8){
			dispose();
			OperationJournale lv=new OperationJournale();
			lv.setVisible(true);
		}
		if(e.getSource()==btn9){
			dispose();
			OperationMicroFilm lv=new OperationMicroFilm();
			lv.setVisible(true);
		}
		
	}




}
