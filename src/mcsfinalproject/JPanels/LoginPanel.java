package mcsfinalproject.JPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mcsfinalproject.Entities.Admin;
import mcsfinalproject.Tools.AdminTool;

public class LoginPanel extends JPanel{
    
    private int PANEL_WIDTH;
    private int PANEL_HEIGHT;
    private JButton loginButton;
    private JButton adminButton;
    private JButton splashButton;
    private JTextField userField;
    private JTextField passField;
    private AdminTool adminTool;
    
    //private final JPanel formPanel;
    
    private JPanel loginPanel;
    private JPanel loginFormPanel;
    private JPanel contentPanel;
    private ActionListener AL;
    private boolean usernameValid;
    private boolean passwordValid;
    
    public LoginPanel(ActionListener AL,int w,int h)
    {
        this.AL = AL;
        this.PANEL_WIDTH = w;
        this.PANEL_HEIGHT = h;

        this.adminTool = new AdminTool("src/mcsfinalproject/datas/admins.json");
        
        this.setLayout(new BorderLayout());
        this.init_loginPanel();
        this.add(loginPanel, BorderLayout.LINE_START);
        
    }
    
    public void init_loginPanel()
    {
        loginPanel = new JPanel(new GridBagLayout());
        Font font1 = new Font("Courier",Font.BOLD, 20);
        loginPanel.setBackground(Color.decode("#46205c"));
        GridBagConstraints gbc = new GridBagConstraints();
        loginFormPanel = new JPanel(new GridBagLayout());
        loginFormPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#59366c"), 3));
        loginFormPanel.setBackground(Color.decode("#46205c"));
        JLabel userLabel, passLabel, memberLoginLabel;
        userLabel = new JLabel("Username: ");
        userLabel.setFont(font1);
        userLabel.setForeground(Color.decode("#dfcece"));
        passLabel = new JLabel("Password: ");
        passLabel.setFont(font1);
        passLabel.setForeground(Color.decode("#dfcece"));
        memberLoginLabel = new JLabel("Member Login");
        memberLoginLabel.setFont(font1);
        memberLoginLabel.setForeground(Color.decode("#dfcece"));
        userField = new JTextField(10);
        passField = new JTextField(10);
        loginButton = new JButton("LOGIN");
        loginButton.addActionListener(AL);
        adminButton = new JButton("REGISTER");
        adminButton.addActionListener(AL);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginFormPanel.add(memberLoginLabel, gbc);
        gbc.fill =  GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginFormPanel.add(userLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginFormPanel.add(userField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginFormPanel.add(passLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginFormPanel.add(passField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        loginFormPanel.add(loginButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        loginFormPanel.add(adminButton, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(loginFormPanel, gbc);
        
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = 0;
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.insets = new Insets(100,0,0,0);
        splashButton = new JButton("BACK");
        splashButton.addActionListener(AL);
        loginPanel.add(splashButton, gbc);

    }
    
    public void loginEvent()
    {
       if(this.isCredentialsValid())
       {
           System.out.println("ACCESS GRANTED!");
       }
    }
    
    public void adminEvent()
    {
        
    }
    
    private boolean isCredentialsValid()
    {
        String username = this.userField.getText();
        String password = this.passField.getText();
        
        usernameValid = false;
        passwordValid = false;
        
        List<Admin> admins = adminTool.getList();
        
        for(int i=0; i<admins.size();i++)
        {
            if(admins.get(i).getUsername().equals(username))
            {
                usernameValid = true;
            }
            else{
                usernameValid = false;
                JOptionPane.showMessageDialog(null, "USERNAME IS INVALID","LOGIN ERROR",0);
                break;
            }
            if(admins.get(i).getPassword().equals(password))
            {
                passwordValid = true;
                break;
            }
            else{
                passwordValid = false;
                JOptionPane.showMessageDialog(this, "PASSWORD IS INVALID","LOGIN ERROR",0);
                break;
            }
            
        }
        return usernameValid && passwordValid;
        
    }

    public JButton getLoginButton() {
        return loginButton;
    }
    
    public JButton getSplashButton()
    {
        return splashButton;
    }

    public JButton getAdminButton() {
        return adminButton;
    }
    
    public boolean isAccess()
    {
        return this.isCredentialsValid();
    }
    
}
