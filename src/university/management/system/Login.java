package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login, cancel;
    JTextField tfusername, tfpassword;
    
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,20); // setting location in UI
        add(lblusername); // for adding written "usename" to the UI 
        
        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);// for adding textfield to the UI 
        
         JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,70,100,20); // setting location in UI
        add(lblpassword); // for adding written "usename" to the UI 
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);// for adding textfield to the UI 
        
        login = new JButton("Login");
        login.setBounds(40,140,120,35);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);// this function calls the action performed method
        login.setFont(new Font("Tamoha", Font.BOLD,15));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,35);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this); // this function calls the action performed method
        cancel.setFont(new Font("Tamoha", Font.BOLD,15));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        // all the listeners call the this action performed method
        // Action Event is used to get from which button it is called
        if(ae.getSource() == login){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            
        } else if(ae.getSource() == cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new Login();
    }
}
