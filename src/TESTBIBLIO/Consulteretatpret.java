package TESTBIBLIO;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Consulteretatpret extends JFrame implements ActionListener{
	
	
	static Connection conction=null;
	static String databaseName="";
	static String url="jdbc:mysql://localhost:3306/"+databaseName;
	static String username="root";
     static String password="ertdfgcvb";
     JPanel contenu= new JPanel();
  JButton btnprécedent =new JButton("Précedent",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\precedentbiblio.png"));
  JButton btnenvoyerrelance =new JButton("Envoyer relance",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\envoyerelan.png"));
  
     JTable tableau1 ;
     JScrollPane scroll1;
     JTable tableau2 ;
     JScrollPane scroll2;
     Consulteretatpret(){
    	 setTitle("ESPACE PRETS :");
 		setSize(700, 500);
 		contenu.setLayout(null);
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		contenu.setBackground(Color.decode("#925aa9") );
 		contenu.add(btnprécedent);
 		contenu.add(btnenvoyerrelance);
 		btnenvoyerrelance.addActionListener(this);
 		btnprécedent.addActionListener(this);
 		btnenvoyerrelance.setBounds(160, 410, 190,33);
 		btnprécedent.setBounds(390, 410, 180, 31);
 		btnenvoyerrelance.setBorder(BorderFactory.createBevelBorder(0));
 		btnprécedent.setBorder(BorderFactory.createBevelBorder(0));
 		btnenvoyerrelance.setBackground(Color.decode("#e2e2e2"));
 		btnprécedent.setBackground(Color.decode("#e2e2e2"));
 		this.setLocationRelativeTo(null);
 DefaultTableModel defaulttable=new DefaultTableModel();
          tableau1=new JTable();
          scroll1=new JScrollPane();
          scroll1.setBounds(60, 30, 570, 200);
          scroll1.setViewportView(tableau1);
 DefaultTableModel defaulttable2=new DefaultTableModel();

           tableau2=new JTable();
           scroll2=new JScrollPane();
           scroll2.setBounds(60, 240, 570, 160);
           scroll2.setViewportView(tableau2);
contenu.add(scroll1);
contenu.add(scroll2);
 defaulttable.addColumn("Numero lecteur");
 defaulttable.addColumn("Nom lecteur");
 defaulttable.addColumn("Cote");
 defaulttable.addColumn("Titre");
 defaulttable.addColumn("Auteur");
 defaulttable.addColumn("date Fin DELAI");
 tableau1.setModel(defaulttable);
 
 defaulttable2.addColumn("Numero lecteur");
 defaulttable2.addColumn("Nom lecteur");
 defaulttable2.addColumn("Cote");
 defaulttable2.addColumn("Titre");
 defaulttable2.addColumn("Auteur");
 defaulttable2.addColumn("Caution");
 defaulttable2.addColumn("date Fin DELAI");
 tableau2.setModel(defaulttable2);
 		
 add(contenu);
 		String query = "SELECT `num_user`,`nom_user`,`cote`,`titre`,`auteur`,`date_fin_delai` FROM `bibliotheque`.`emprunt_livre`";
 		String query2 = "SELECT `num_user`,`nom_user`,`cote`,`titre`,`auteur`,`caution`,`date_fin_delai` FROM `bibliotheque`.`emprunt_cdrom`";
 		int i=0;
 		int j=0;
 		try{
 		 	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
 			conction=DriverManager.getConnection(url,username,password);
 			Statement stm = conction.createStatement();
 		    ResultSet res = stm.executeQuery(query);
 		   
 		    while(res.next()) {
 		    	i++;
 		    	defaulttable.addRow(new Object[]{
res.getInt("num_user"),res.getString("nom_user"),res.getInt("cote"),res.getString("titre"),res.getString("auteur"),res.getDate("date_fin_delai")
 		    		
 		    	});
 		    	
 		    } 
 		   res= stm.executeQuery(query2);
 		   while(res.next()) {
		    	j++;
		    	defaulttable2.addRow(new Object[]{
res.getInt("num_user"),res.getString("nom_user"),res.getInt("cote"),res.getString("titre"),res.getString("auteur"),res.getFloat("caution"),res.getDate("date_fin_delai")
		    		
		    	});
		    }
 			
 		}catch(Exception e){
 	
 			JOptionPane.showConfirmDialog(this,"ERROR ");
 		}
 		

 		
     }
	
	
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consulteretatpret c= new Consulteretatpret();
		c.setVisible(true);
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnprécedent) {
			dispose();
			Bibliothécaire bibliothécaire= new Bibliothécaire();
			bibliothécaire.setVisible(true);
		}
if(e.getSource()==btnenvoyerrelance) {
	dispose();
	Envoyerrelance r=new Envoyerrelance();
	r.setVisible(true);
		}
	}
	
}
