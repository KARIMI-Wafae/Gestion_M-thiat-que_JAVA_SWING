package TESTBIBLIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class NotificationUser extends JFrame implements ActionListener {
	
	java.sql.Statement st;
	ResultSet rst;
	static Connection connexion=null;
	static String databaseName="";
	static String url ="jdbc:mysql://localhost:3306/"+databaseName;
	static String username="root";
	static String password="ertdfgcvb";
	JLabel lbtitre,lbtitre2,lbtitre1;
	JTable table;
	JScrollPane scroll;
	JButton btnPrecedent;
	JTextField text;
	JButton btnRech;
	DefaultTableModel df;
	
	public NotificationUser(){
		this.setTitle("Espace Employe");
		this.setSize(700,550);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		
		this.setLayout(null);
		
		setForeground(Color.black);
		//add(this);
		 btnPrecedent=new JButton("Précèdent");
		 btnPrecedent.setBounds(540,450,110,30);
		 btnPrecedent.addActionListener(this);
		 this.add(btnPrecedent);
		 add(pn);
		 //pn.setBackground(Color.DARK_GRAY);
		 this.getContentPane().setBackground(Color.decode("#bbae98") );
			
		
				text = new JTextField();this.add(text);text.setBounds(390,40,160,28);
				 btnRech=new JButton("",new ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\poo\\MonProjet\\src\\Search (2).png"));
				 this.add(btnRech);btnRech.setBounds(560,40,29,27);
				 btnRech.addActionListener(this);
				 lbtitre1=new JLabel("Entrer votre nom");lbtitre1.setBounds(280,40,300,30);lbtitre1.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
				 lbtitre1.setForeground(Color.BLACK);this.add(lbtitre1);
				
			     df=new  DefaultTableModel();
				 init();
				 
				 this.add(scroll);
				 df.addColumn("Titre document");
				 df.addColumn("Message");
				 table.setModel(df);}
	
	
				
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnPrecedent){
			
			try{
				dispose();
				InterfaceUser ab=new InterfaceUser();
				ab.setVisible(true);
				
			}
			catch(Exception ex){
				
			}}//FIN btnPrecedent
		if(e.getSource()==btnRech){	 
			 String nom=text.getText();
			 String req="select `titre`,`message` from `bibliotheque`.`relance` where `nom_user`='"+nom+"';";
			 
			 
			 try{
				 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					connexion = DriverManager.getConnection(url,username,password);
					java.sql.Statement stmt = connexion.createStatement();
					ResultSet résultats = stmt.executeQuery(req);
					
					
				 while(résultats.next()){
					
					 df.addRow(new Object[]{
							 résultats.getString("titre"),
							 résultats.getString("message")});
				 }
				 if(nom.equals(""))
						JOptionPane.showMessageDialog(null,"veuillez entrer ton nom!");
			
				 }
				 catch(Exception ex){
						
					}}//btnRecher
				}
	
	
	public static void main(String[] args) 
	      {
				NotificationUser a= new NotificationUser();
				a.setVisible(true);

          }
	private void init(){
		//table.setBackground(Color.green);
		
		table=new JTable();
		scroll=new JScrollPane();
		//scroll.setBounds(90,50,520,300);
		scroll.setBounds(90,80,500,250);
		scroll.setViewportView(table);
	}


}


