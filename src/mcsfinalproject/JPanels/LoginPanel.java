package mcsfinalproject.JPanels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mcsfinalproject.Tools.AdminTool;

public class LoginPanel extends JPanel{
    
    private int WIDTH, HEIGHT;
    private JButton loginButton, registerButton;
    private JTextField userField, passField;
    private AdminTool tool;
    
    private JPanel backGroundPanel;
    
    public LoginPanel(ActionListener AL,int w,int h)
    {
        this.WIDTH = w;
        this.HEIGHT = h;
        this.setLayout(null);
        
        this.backGroundPanel = new JPanel();
        this.backGroundPanel.setLayout(null);
        
        this.userField = new JTextField(10);
        this.passField = new JTextField(10);
        this.loginButton = new JButton("LOGIN");
        this.registerButton = new JButton("REGISTER");
        
        this.loginButton.setFont(new Font("Courier",Font.BOLD,15));
        this.registerButton.setFont(new Font("Courier",Font.BOLD,12));
        
        this.loginButton.addActionListener(AL);
        this.registerButton.addActionListener(AL);
        
        this.backGroundPanel.add(this.userField);
        this.backGroundPanel.add(this.passField);
        this.backGroundPanel.add(this.loginButton);
        this.backGroundPanel.add(this.registerButton);
        
        this.userField.setBounds(175, 318, 142, 40);
        this.passField.setBounds(175, 396, 142, 40);
        this.loginButton.setBounds(175, 460, 100, 30);
        this.registerButton.setBounds(675, 10, 100, 30);
        
        this.backGroundPanel.setBounds(0, 0, WIDTH, HEIGHT);
        this.backGroundPanel.setBackground(new Color(0,0,0,0));
        this.add(this.backGroundPanel);
        
        Image bg = new ImageIcon("src/mcsfinalproject/Media/Login.png").getImage();
        JLabel bgLabel = new JLabel(new ImageIcon(bg.getScaledInstance(WIDTH, HEIGHT, 0)));
        this.add(bgLabel);
        bgLabel.setBounds(0, 0, WIDTH, HEIGHT);
        
        
    }
    
    public void loginEvent()
    {
        
    }
    
    public void registerEvent()
    {
        
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }
    
}
