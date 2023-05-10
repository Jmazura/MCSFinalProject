package mcsfinalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginClass extends JPanel{
    
    String adminUsername = "ADMIN";
    String adminPassword = "ADMIN";
       
    Font courierFont = new Font("Courier",Font.BOLD, 32);
    private final int FRAME_WIDTH, FRAME_HEIGHT;
    private JPanel northPanel;
    private JPanel midPanel;
    public JButton loginButton, registerButton;
    private ActionListener AL;
    private JTextField usernameField, passwordField;
    
    
    public LoginClass(int FRAME_WIDTH,int FRAME_HEIGHT, ActionListener AL)
    {
        this.FRAME_HEIGHT = FRAME_HEIGHT;
        this.FRAME_WIDTH = FRAME_WIDTH;
        this.AL = AL;
        this.initializePanel();
        this.setUpTitle();
        this.loginForm();
        this.add(northPanel, BorderLayout.NORTH);
        this.add(midPanel, BorderLayout.CENTER);
        
    }
    
    private void initializePanel()
    {

        northPanel = new JPanel();
        midPanel = new JPanel(new GridLayout(3,0,0,0));
        this.setPreferredSize(new Dimension(this.FRAME_WIDTH, this.FRAME_HEIGHT));
        northPanel.setPreferredSize(new Dimension(this.FRAME_WIDTH, this.FRAME_HEIGHT/3));
        
    }
    
    private void loginForm()
    {
        JPanel upperMidPanel = new JPanel(new GridLayout(2,2,0,0));
        JPanel lowerMidPanel = new JPanel();
        
        // UPPER MID PANEL CODES
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        usernameField = new JTextField(10);
        passwordField = new JTextField(10);
        upperMidPanel.add(usernameLabel);
        upperMidPanel.add(usernameField);
        upperMidPanel.add(passwordLabel);
        upperMidPanel.add(passwordField);
        
        // LOWER MID PANEL CODES
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        loginButton.addActionListener(AL);
        registerButton.addActionListener(AL);
        lowerMidPanel.add(loginButton);
        lowerMidPanel.add(registerButton);
        
        // TITLE FOR MEMBER LOGIIN
        JPanel test = new JPanel();
        JLabel memberLoginLabel = new JLabel("MEMBER LOGIN");
        memberLoginLabel.setFont(new Font("Ariel",Font.BOLD,22));
        test.add(memberLoginLabel, BorderLayout.NORTH);
        
        //upperMidPanel.setBackground(new Color(0,0,0,100));
        //lowerMidPanel.setBackground(new Color(0,0,0,100));
        midPanel.add(test, BorderLayout.NORTH);
        midPanel.add(upperMidPanel, BorderLayout.CENTER);
        midPanel.add(lowerMidPanel, BorderLayout.SOUTH);
    }
    
    private void setUpTitle()
    {
       JLabel titleLabel = new JLabel("Hotel and Resort Amenities");
       titleLabel.setFont(courierFont);
       titleLabel.setForeground(Color.red);
       JLabel titleLabel2 = new JLabel("for black Bean");
       titleLabel2.setFont(courierFont);
       titleLabel2.setForeground(Color.red);
       //northPanel.setLayout(new GridLayout(2,1,0,0));
      // northPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
       northPanel.setBackground(new Color(0,0,0,0));
       northPanel.add(titleLabel, BorderLayout.NORTH);
       northPanel.add(titleLabel2, BorderLayout.NORTH); 
    }
    
    private boolean isCredentialsValid(String username, String password)
    {
        if(username.equals(adminUsername) && password.equals(adminPassword))
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public boolean loginValid()
    {
        if(this.isCredentialsValid(this.usernameField.getText(),this.passwordField.getText() ))
        {
            System.out.println("WOKRING");
            return true;
        }
        else{
            return false;
        }
    }

    
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        Image lars = new ImageIcon("src/mcsfinalproject/lars.jpg").getImage();
        g2d.drawImage(lars, 0,0,this.FRAME_WIDTH, this.FRAME_HEIGHT,null);
    }
    
}
