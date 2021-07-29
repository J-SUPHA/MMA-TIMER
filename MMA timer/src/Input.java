import javax.swing.*;  
import java.awt.event.*;  
public class Input implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField tf1,tf2,tf3,tf4,tf5;  
    JButton b1,b2;  
    JFrame f= new JFrame("Welcome to the BOXING/MMA Timer"); //frame title 
    public int [] store = new int [5]; //store of input to be put in timer method 
    
    Input(){  
        JPanel p = new JPanel();
        f.setSize(900, 700);
        p.setSize(899, 699);
        p.setLayout(null);
        
        l2 = new JLabel("Enter the number of minutes of your live round");
        l2.setBounds(250,10,350,50);
        p.add(l2);
        tf1=new JTextField();  
        tf1.setBounds(250,70,350,50);
        p.add(tf1);
        l3 = new JLabel("Enter the number of seconds of your live round");
        l3.setBounds(250,130,350,50);
        p.add(l3);
        tf2=new JTextField();  
        tf2.setBounds(250,190,350,50); 
        p.add(tf2);
        l4 = new JLabel("Enter the number of minutes of your rest round");
        l4.setBounds(250,250,350,50);
        p.add(l4);
        tf3=new JTextField();  
        tf3.setBounds(250,310,350,50);  
        p.add(tf3);
        l5 = new JLabel("Enter the number of seconds of your rest round");
        l5.setBounds(250,370,350,50);
        p.add(l5);
        tf4=new JTextField();  
        tf4.setBounds(250,420,350,50); 
        p.add(tf4);
        l6 = new JLabel("Enter the number of rounds");
        l6.setBounds(250,480,350,50);
        p.add(l6);
        tf5=new JTextField();  
        tf5.setBounds(250,540,350,50); 
        p.add(tf5);
        b1 = new JButton("Enter");
        b1.setBounds(375, 600, 100, 50);
        b1.addActionListener(this);
        p.add(b1);
        f.add(p);
        f.setVisible(true);
    }         
    public void actionPerformed(ActionEvent e) {  
        String s1=tf1.getText();  //extracting data from input table
        String s2=tf2.getText(); 
        String s3=tf3.getText();
        String s4=tf4.getText();
        String s5=tf5.getText();
      
      
        int a=Integer.parseInt(s1);  //converting ata from string to int 
        int b=Integer.parseInt(s2);  
        int c=Integer.parseInt(s3);
        int d=Integer.parseInt(s4);
        int g=Integer.parseInt(s5);
       
            store[0] = a;
            store[1] = b;
            store[2] = c;
            store[3] = d;
            store[4] = g;
        for (int i=0;i<5;i++) {
        	System.out.println(store[i]);
        }

        
        f.dispose();
    }
    
    public int [] getStore() {
    	return store;
    }
}
