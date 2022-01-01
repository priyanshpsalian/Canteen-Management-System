import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Signin extends JFrame {
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField username;
    private JPasswordField passwordField;
    private JButton loginButton,newUserButton;
    
    public Signin() {
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setTitle("Canteen-MS-Login");
        setBounds(200, 100, 400, 500);
        setResizable(false);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        getContentPane().setBackground(new Color(150, 255, 225));
        
        JLabel lblsignin = new JLabel("Login");
        lblsignin.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        lblsignin.setBounds(148, 30, 200, 50);
        contentPane.add(lblsignin);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsername.setBounds(20, 120, 90, 18);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setBounds(20, 200, 90, 18);
        contentPane.add(lblPassword);
        
        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 18));
        username.setBounds(110, 115, 228, 30);
        contentPane.add(username);
        username.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        passwordField.setBounds(110, 195, 228, 30);
        contentPane.add(passwordField);
        
        loginButton = new JButton("Sign in");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = username.getText();
        		String password = String.valueOf(passwordField.getPassword());
        		String query = "select password_,first_name from account where user_name = \""+userName+"\"";
                try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen_db", "root", "1234");
                    Statement sta = connection.createStatement();
                    
                    ResultSet rs = sta.executeQuery(query);
                    rs.next();
            		String db_password = rs.getString("password_");
            		//System.out.println(db_password+" entered :"+password);
            		
                    if (db_password.equals(password)) {
                    	JOptionPane.showMessageDialog(loginButton,"Welcome, "+ rs.getString("first_name"));
                    	dispose();
                    	new Order();
                    } else {
                        JOptionPane.showMessageDialog(loginButton, "Invalid Password");
                    }
                    connection.close();
                } catch (Exception exception) {
                    //exception.printStackTrace();
                	JOptionPane.showMessageDialog(loginButton, "Invalid User");
                	System.out.println(exception);
                }
            }
        });
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        loginButton.setBounds(56, 280, 270, 44);
        contentPane.add(loginButton);
        
        newUserButton = new JButton("New user");
        newUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
                new UserRegistration();
            }
        });
        newUserButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        newUserButton.setBounds(56, 350, 270, 44);
        contentPane.add(newUserButton);
    }
}
