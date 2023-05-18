package mcsfinalproject.JPanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class AdminLoginPanel extends JPanel{
    
    private int PANEL_WIDTH, PANEL_HEIGHT;
    private ActionListener AL;
    private Font myFont = new Font("Courier", Font.BOLD, 32);
    
    private JTextField userField;
    private JTextField passField;
    
    private JButton backButton, loginButton;
    private int validID = 0;
    
    private AdminTool admins = new AdminTool(   "src/mcsfinalproject/datas/admins.json");
    
    public AdminLoginPanel(ActionListener aL,int w, int h)
    {
        this.PANEL_HEIGHT = h;
        this.PANEL_WIDTH = w;
        this.AL = aL;
        
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.decode("#574b90"));
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel label = new JLabel("ADMIN LOGIN");
        label.setForeground(Color.decode("#5d5d5a"));
        label.setBackground(Color.decode("#002651"));
        
        label.setFont(myFont);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(label, gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(this.getForm(), gbc);
        
        backButton = new JButton("BACK");
        
        backButton.setBackground(Color.decode("#002651"));
        loginButton = new JButton("LOGIN");
        
        loginButton.setBackground(Color.decode("#002651"));
        backButton.setFont(myFont);
        loginButton.setFont(myFont);
        
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(backButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 50;
        this.add(loginButton, gbc);
    
        backButton.addActionListener(aL);
        loginButton.addActionListener(aL);
    }
    public JPanel getForm()
    {
        JPanel localPanel = new JPanel(new GridBagLayout());
        localPanel.setBackground(Color.decode("#002651"));
        GridBagConstraints gbcL = new GridBagConstraints();
        
        JLabel userLabel = new JLabel("USERNAME: ");
        userLabel.setFont(myFont);
        JLabel passLabel = new JLabel("PASSWORD: ");
        passLabel.setFont(myFont);
        userField = new JTextField(10);
        userField.setFont(myFont);
        passField = new JTextField(10);
        passField.setFont(myFont);
        
        gbcL.fill = GridBagConstraints.BOTH;
        gbcL.gridx = 0;
        gbcL.gridy = 0;
        localPanel.add(userLabel, gbcL);
        
        gbcL.gridx = 1;
        gbcL.gridy = 0;
        localPanel.add(userField, gbcL);

        gbcL.gridx = 0;
        gbcL.gridy = 1;
        localPanel.add(passLabel, gbcL);
        
        gbcL.gridx = 1;
        gbcL.gridy = 1;
        localPanel.add(passField, gbcL);
        
       
        
        return localPanel;
    }

    public JTextField getUserField() {
        return userField;
    }

    public JTextField getPassField() {
        return passField;
    }
    
    
    
    public JButton getBackButton()
    {
        return this.backButton;
    }
    public JButton getLoginButton()
    {
        return this.loginButton;        
    }
    
    public int getID()
    {
        return this.validID;
    }
    
    public boolean loginValueValid()
    {
        boolean isValid = false;
        String username = this.userField.getText();
        String password = this.passField.getText();
        
        List <Admin> adminn = admins.getList();
        
        if(!adminn.isEmpty())
        {
        
            for(Admin index: adminn)
            {
                if(index.getUsername().equals(username))
                {
                    if(index.getPassword().equals(password))
                    {
                        JOptionPane.showMessageDialog(null, "LOGIN VALID");
                        this.validID = index.getId();
                        isValid = true;
                        break;
                    }
                }
                else{
                    isValid = false;
                }
            }
        }else{
            isValid = false;
        }
        return isValid;
    }
}
