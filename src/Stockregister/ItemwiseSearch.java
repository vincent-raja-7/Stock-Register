/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stockregister;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author King Vincent
 */
public class ItemwiseSearch extends JFrame  {
        private JLabel jLabel1; 
 	private JLabel jLabel2,jLabel3,jLabel4; 
        private JPanel contentPane;  	
	JTable table;
	Toolkit tk;
	Dimension d;
   	Vector row,columns,data,allrow,row1,columns1,data1,allrow1;
	String uname="";
        static String items;
        static void setItem(String item) {
        items = item;
        }
        
        public ItemwiseSearch() 
 	{ 
 		super(); 
 		//this.setOpaque(true);
        this.setBackground(Color.BLUE);
 		dbConne();
              //  dbConne1();
        initializeComponent();
        setVisible(true);
		setResizable(false);
 		//this.setVisible(true); 
	}  
        private void initializeComponent() 
 	{ 
		
		JLabel bgr; 
		bgr = new JLabel();                   
		tk = Toolkit.getDefaultToolkit();
		d = tk.getScreenSize();
 		jLabel1 = new JLabel(); 
 		jLabel2 = new JLabel(); 
	     jLabel3 = new JLabel(); 
		 jLabel4 = new JLabel(); 
 		//jButton1 = new JButton(); 
		bgr.setText("Stock Details");
		contentPane = (JPanel)this.getContentPane(); 	
 		jLabel1.setText(" Sports Records");  		
 		jLabel2.setText(" ");  		
 		jLabel3.setText("");  	
 		jLabel4.setText("");  	
        addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
							
				}
			}
		);
        contentPane.setLayout(null);
		contentPane.setBackground(new Color(205,125,205)); 
		addComponent(contentPane, bgr,210,0,100,50); 
 		
		addComponent(contentPane, jLabel1, 30,50,50,18); 
	 	addComponent(contentPane, jLabel3, 80,50,100,21); 
	
		addComponent(contentPane, jLabel2, 290,50,50,18); 
		addComponent(contentPane, jLabel4, 355,50,100,22); 
                this.setTitle("Stock Records"); 
		

                 table = new JTable(data, columns);
		JScrollPane scrollPane = new JScrollPane(table);
                addComponent(contentPane, scrollPane , 30,80,1000,1000);  
                int x = (d.height/2) - 165;
		int y = (d.width/2) - 250;
 		this.setLocation(new Point(y,x)); 
 		this.setSize(new Dimension(1000,1000)); 
 	}   
        private void addComponent(Container container,Component c,int x,int y,int width,int height) 
 	{ 
 		c.setBounds(x,y,width,height); 
 		container.add(c); 
 	}   
        public void dbConne()
	{
		int count = 0;
		columns=new Vector();		
                allrow = new Vector();
                columns.add("Bill No.");
                columns.add("Purchase Date");
                columns.add("Items");
                columns.add("Quantity");
                columns.add("Supp. Name");
                columns.add("Using Stock");
                columns.add("New Stock");
                columns.add("Total Stock");
                columns.add("Total Amount");
                columns.add("Amount");
                //columns.add("Quantity");
          data=new Vector();
          try{
	
				 
			 Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `user`.updatestock where items='"+items+"'");
			while (rs.next()){
          row=new Vector() ; 
 
          for (int i = 1; i <= columns.size(); i++)
                {
				row.addElement(rs.getObject(i)); 
                }
             data.addElement(row);
		        
	       }
			 
                        }catch(Exception sql){sql.printStackTrace();System.out.println(sql);}
		
	
	}
       // public static void main(String a[]){
	//	new ItemwiseSearch();
	//}

 
    
}
