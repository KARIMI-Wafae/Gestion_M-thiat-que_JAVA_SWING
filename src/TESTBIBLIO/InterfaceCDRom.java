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
import javax.swing.table.DefaultTableModel;

public class InterfaceCDRom extends JFrame implements ActionListener {
	
	java.sql.Statement st;
	ResultSet rst;
	static Connection connexion=null;
	static String databaseName="";
	static String url ="jdbc:mysql://localhost:3306/"+databaseName;
	static String username="root";
	static String password="ertdfgcvb";
	JLabel lbtitre,lbtitre2;
	JButton bt1,bt2;
	JTable table;
	JScrollPane scroll;
	
	public InterfaceCDRom(){
		this.setTitle("Espace Utilisateur");
		this.setSize(700,550);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		
		pn.setLayout(null);
		pn.setBackground(Color.GRAY);
		//setForeground(Color.black);
		add(pn);
		//titre
				lbtitre=new JLabel("Liste des CDROMS");
				lbtitre.setBounds(272,10,300,30);
				lbtitre.setFont(new Font("Arial",Font.BOLD,20));
				pn.add(lbtitre);
				bt2=new JButton("",new ImageIcon("C:\\Users\\user\\eclipse-workspace\\TESTBIBLIO\\src\\TESTBIBLIO\\Search (2).png"));
				bt2.setBounds(577,10,36,32);
				
				bt2.addActionListener(this);
				pn.add(bt2);
				
				bt1=new JButton("Pr�c�dent");
				bt1.setBounds(540,450,110,30);
				bt1.addActionListener(this);
				pn.add(bt1);
				DefaultTableModel df=new  DefaultTableModel();
				init();
				 pn.add(scroll);
				 df.addColumn("Numero");
				 
				 df.addColumn("Cote");
				 df.addColumn("Titre");
				 df.addColumn("Auteur");
				 df.addColumn("Etat");
				 df.addColumn("Caution");
				 table.setModel(df);
				    lbtitre2=new JLabel("TOTAL :");
					lbtitre2.setBounds(460,360,300,30);
					lbtitre2.setFont(new Font("Arial",Font.BOLD,20));
					pn.add(lbtitre2);
					//
					lbtitre2=new JLabel("");
					lbtitre2.setBounds(560,360,300,30);
					lbtitre2.setFont(new Font("Arial",Font.ITALIC,20));
					lbtitre2.setForeground(new Color(255,255,255));
					pn.add(lbtitre2);
				 String req="select * from `bibliotheque`.`cdrom` order by titre;";
				 int i=0;
				 try{
					 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
						connexion = DriverManager.getConnection(url,username,password);
						java.sql.Statement stmt = connexion.createStatement();
						ResultSet r�sultats = stmt.executeQuery(req);
					 while(r�sultats.next()){
						 i++;
						 df.addRow(new Object[]{
								 r�sultats.getString("num_cdrom"),r�sultats.getString("cote"),r�sultats.getString("titre"),
								 r�sultats.getString("auteur"),r�sultats.getString("etat"),r�sultats.getString("caution")});
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
		InterfaceCDRom a= new InterfaceCDRom();
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
		if(e.getSource()==bt1)
	    {
			dispose();
			InterfaceUser ab=new InterfaceUser();
			ab.setVisible(true);
		}
		if(e.getSource()==bt2)
	    {
			dispose();
			RechercherCDRom ab=new RechercherCDRom();
			ab.setVisible(true);
		}
		
	}

}
