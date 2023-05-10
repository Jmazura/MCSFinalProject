package mcsfinalproject.JPanels;

import Entities.Admin;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mcsfinalproject.Tools.*;

public class SplashPanel extends JPanel{
    
    private JButton loginButton;
    private JTextField userField, passField;
    private AdminTool tool;
    private JLabel statusLabel;
    
    public SplashPanel(ActionListener AL,int w,int h)
    {
        
        this.setBackground(Color.black);
        this.setSize(w, h);
        
        JPanel mainPanel = new JPanel(new GridLayout(3,2,0,0));
        
        JLabel userLabel = new JLabel("Username: ");
        JLabel passLabel = new JLabel("Password: ");
        userField = new JTextField(10);
        passField = new JTextField(10);
        statusLabel = new JLabel("NONE");
        loginButton = new JButton("LOGIN");
        loginButton.addActionListener(AL);
        
        tool = new AdminTool("src/mcsfinalproject/datas/admins.json");
        
        mainPanel.add(userLabel);
        mainPanel.add(passLabel);
        mainPanel.add(userField);
        mainPanel.add(passField);
        mainPanel.add(loginButton);
        mainPanel.add(statusLabel);
        
        this.add(mainPanel);
        
    }
    
    public void loginButtonAction()
    {
        String username = userField.getText();
        String password = passField.getText();
        
        boolean validUsername = false, validPassword = false, validUser=false;
        
        for(int i=0;i<tool.getList().size();i++)
        {
            if(username.equals(tool.getList().get(i).getUsername()))
            {
                
                validUsername = true;
            }
            else{
                validUsername = false;
            }
            if(password.equals(tool.getList().get(i).getPassword()))
            {
                validPassword = true;
            }
            else{
                validPassword = false;
            }
            if(validPassword && validUsername)
            {
                validUser = true;
            }
            else{
                validUser = false;
            }
        }
        
        
        if(!validUsername)
        {
            this.statusLabel.setText("USERNAME INCORRECT!");
        }
        else if(!validPassword)
        {
            this.statusLabel.setText("PASSWORD INCORRECT");
        }
        if(validUser)
            this.statusLabel.setText("ACCESS GRANTED...");
    }
    
    public JButton getLoginButton()
    {
        return loginButton;
    }
    
}
