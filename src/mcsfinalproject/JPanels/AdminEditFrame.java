package mcsfinalproject.JPanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mcsfinalproject.Entities.Admin;
import mcsfinalproject.Tools.AdminTool;

public class AdminEditFrame extends JFrame implements ActionListener{
    
    private AdminTool adtol = new AdminTool("src/mcsfinalproject/datas/admins.json");
    List <Admin> admins = adtol.getList();
    private int id;
    
    private JButton passEditButton, userEditButton;
    private JLabel username, password;
    private JLabel[] names, passwords;
    public AdminEditFrame(int id, JLabel[] names, JLabel[] passwords)
    {
        this.id = id;
        this.names = names;
        this.passwords = passwords;
        this.init();
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel userlabel = new JLabel("USERNAME:    ");
        username = new JLabel(admins.get(id).getUsername());
        userEditButton = new JButton("EDIT USERNAME");
        
        JLabel passlabel = new JLabel("PASSWORD:    ");
        password = new JLabel(admins.get(id).getPassword());
        passEditButton = new JButton("EDIT PASSWORD");
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0,25,0,25);
                
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
        
        this.userEditButton.addActionListener(this);
        this.passEditButton.addActionListener(this);
        this.add(mainPanel);
    }
    
    public void init()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 150);
        this.setResizable(false);
        this.setFocusable(true);
        this.setLocationRelativeTo(null);
        this.setTitle("EDIT ADMIN USER");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if(event.equals(this.userEditButton))
        {
            String newUsername = JOptionPane.showInputDialog("NEW USERNAME: ");
            if(newUsername != null)
                admins.get(id).setUsername(newUsername);
                
            adtol.update(admins);
            admins = adtol.getList();
            username.setText(admins.get(id).getUsername());
            names[id].setText(admins.get(id).getUsername());
            
        }
        if(event.equals(this.passEditButton))
        {
            String newPassword = JOptionPane.showInputDialog("NEW PASSWORD: ");
            if(newPassword != null)
                admins.get(id).setPassword(newPassword);
            adtol.update(admins);
            admins = adtol.getList();
            password.setText(admins.get(id).getPassword());
            passwords[id].setText(admins.get(id).getPassword());
        }
    }
    
}
