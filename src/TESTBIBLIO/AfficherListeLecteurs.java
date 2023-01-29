package TESTBIBLIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AfficherListeLecteurs extends JFrame implements ActionListener {
	
	java.sql.Statement st;
	ResultSet rst;
	static Connection connexion=null;
	static String databaseName="";
	static String url ="jdbc:mysql://localhost:3306/"+databaseName;
	static String username="root";
	static String password="ertdfgcvb";
	JLabel lbtitre,lbtitre2;
	JButton bt1;
	JTable table;
	JScrollPane scroll;
	JButton bt6;
	public AfficherListeLecteurs(){
		this.setTitle("Espace Employe");
		this.setSize(700,550);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		
		pn.setLayout(null);
		pn.setBackground(Color.GRAY);
		//setForeground(Color.black);
		add(pn);
		//titre
				lbtitre=new JLabel("Liste des lecteurs");
				lbtitre.setBounds(272,10,300,30);
				lbtitre.setFont(new Font("Arial",Font.BOLD,20));
				pn.add(lbtitre);
			/*	bt1=new JButton("Lecteurs");
				bt1.setBounds(250,90,110,30);
				bt1.setSize(200,50);
				bt1.addActionListener(this);
				pn.add(bt1);*/
				
				bt6=new JButton("Précèdent");
				bt6.setBounds(540,450,110,30);
				bt6.addActionListener(this);
				pn.add(bt6);
				
				DefaultTableModel df=new  DefaultTableModel();
				  init();
				  pn.add(scroll);
				 df.addColumn("Numero");
				 df.addColumn("Nom");
				 df.addColumn("Prenom");
				 df.addColumn("Adresse");
				 df.addColumn("email");
				 df.addColumn("login");
				 df.addColumn("MotDePasse");
				 df.addColumn("Nbre d'emprunts");
				 table.setModel(df);
				    lbtitre2=new JLabel("TOTAL :");
					lbtitre2.setBounds(460,360,300,30);
					lbtitre2.setFont(new Font("Arial",Font.BOLD,20));
					pn.add(lbtitre2);
					//
					lbtitre2=new JLabel("ffff");
					lbtitre2.setBounds(560,360,300,30);
					lbtitre2.setFont(new Font("Arial",Font.ITALIC,20));
					lbtitre2.setForeground(new Color(255,255,255));
					pn.add(lbtitre2);
				 String req="select * from `bibliotheque`.`lecteur`;";
				 int i=0;
				 try{
					 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
						connexion = DriverManager.getConnection(url,username,password);
						java.sql.Statement stmt = connexion.createStatement();
						ResultSet résultats = stmt.executeQuery(req);
					 while(résultats.next()){
						 i++;
						 df.addRow(new Object[]{
								 résultats.getString("num_lecteur"),résultats.getString("nom_lecteur"),résultats.getString("prenom_lecteur"),
								 résultats.getString("adresse"),résultats.getString("email"),résultats.getString("login"),résultats.getString("motDePasse"),
								 résultats.getString("nbre_emprunts")});
					 }
					 lbtitre2.setText(String.valueOf(i));
					 }		 
				 catch(SQLException ex){
				    	JOptionPane.showMessageDialog(null,"Erreur !",null,JOptionPane.ERROR_MESSAGE);	
				    } catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
							

	public static void main(String[] args) {
		AfficherListeLecteurs a= new AfficherListeLecteurs();
		a.setVisible(true);

	}
	private void init(){
		table=new JTable();
		scroll=new JScrollPane();
		scroll.setBounds(90,50,520,300);
		scroll.setViewportView(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt6) {
			dispose();
			Employe ev=new Employe();
			ev.setVisible(true);
		}
	}

}
