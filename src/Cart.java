import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Cart extends JFrame {
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JTextArea itemList,quantity;
    
    public void createGui() {
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setTitle("Canteen-MS-Cart");
        setBounds(60, 10, 1200, 700);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(255, 229, 143));
        
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(50,100,700,400);
        panel.setBackground(new Color(124, 183, 255));

        itemList = new JTextArea();
        itemList.setBounds(50,80,200,300);
        itemList.setLineWrap(true);
        itemList.setEditable(false);
        itemList.setBorder(new EmptyBorder(5, 5, 5, 5));
        itemList.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(itemList);
        
        quantity = new JTextArea();
        quantity.setBounds(290,80,50,300);
        quantity.setLineWrap(true);
        //quantity.setEditable(false);
        quantity.setBorder(new EmptyBorder(5, 5, 5, 5));
        quantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(quantity);
        
        JLabel litems,lquantity,ltotal; 
        
        litems = new JLabel("Items in cart");
        litems.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        litems.setBounds(50,20,200,32);
        panel.add(litems);
        
        lquantity = new JLabel("Quantity");
        lquantity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lquantity.setBounds(200,20,130,32);
        panel.add(lquantity);
        
        ltotal = new JLabel("Total");
        ltotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        ltotal.setBounds(300,20,100,32);
        panel.add(ltotal);
        
        add(panel);
    }
    
	public void addToCart(String inp) {
		switch(inp) {
		case "1": 
        	itemList.append("button1\n");
        	break;
        case "2": 
        	itemList.append("button2\n");
        	break;
        case "3": 
        	itemList.append("button3\n");
        	break;
        case "4": 
        	itemList.append("button4\n");
        	break;
        case "5": 
        	itemList.append("button5\n");
        	break;
        case "6": 
        	itemList.append("button6\n");
        	break;
        case "7": 
        	itemList.append("button7\n");
        	break;
        case "8": 
        	itemList.append("button8\n");
        	break;
		}
	}

	public void setVisible() {
        setVisible(true);
	} 
    
}