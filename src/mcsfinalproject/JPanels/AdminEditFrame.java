package mcsfinalproject.JPanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mcsfinalproject.Entities.Admin;
import mcsfinalproject.Tools.AdminTool;

public class AdminEditFrame extends JFrame{
    
    private AdminTool adtol = new AdminTool("src/mcsfinalproject/datas/admins.json");
    List <Admin> admins = adtol.getList();
    private int id;
    
    public AdminEditFrame(int id)
    {
        this.id = id;
        this.init();
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel userlabel = new JLabel("USERNAME:    ");
        JLabel username = new JLabel(admins.get(id).getUsername());
        JButton userEditButton = new JButton("EDIT USERNAME");
        
        JLabel passlabel = new JLabel("PASSWORD:    ");
        JLabel password = new JLabel(admins.get(id).getPassword());
        JButton passEditButton = new JButton("EDIT PASSWORD");
        
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(userlabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(username, gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 4;
        gbc.gridy = 0;
        mainPanel.add(userEditButton, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(passlabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(password, gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 4;
        gbc.gridy = 1;
        mainPanel.add(passEditButton, gbc);
        
        
        this.add(mainPanel);
    }
    
    public void init()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setResizable(false);
        this.setFocusable(true);
        this.setLocationRelativeTo(null);
        this.setTitle("EDIT ADMIN USER");
    }
    
}
