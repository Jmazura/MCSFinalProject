package mcsfinalproject.JPanels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mcsfinalproject.Entities.Admin;
import mcsfinalproject.Tools.AdminTool;

public class AdminPanel extends JPanel implements ActionListener{
    
    private AdminTool adtool = new AdminTool("src/mcsfinalproject/datas/admins.json");
    List <Admin> admins = adtool.getList();
    //List <JButton> buttons;
    JButton[] buttons = new JButton[50];
    JLabel[] names = new JLabel[50];
    JLabel[] passwords = new JLabel[50];
    JPanel centerPanel;
    JButton addButton;
    JButton removeButton;
            
    public AdminPanel()
    {
        this.setLayout(new BorderLayout());
        
        JPanel northPanel = new JPanel(new FlowLayout());
        
        addButton  = new JButton("ADD NEW ADMIN");
        removeButton = new JButton("REMOVE ADMIN");
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        northPanel.add(addButton);
        northPanel.add(removeButton);
        
        centerPanel = new JPanel();
        
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //buttons.add(new JButton("TEST"));
        JLabel idLabel = new JLabel("ID");
        JLabel nameLabel = new JLabel("USERNAMES");
        JLabel passLabel = new JLabel("PASSWORDS");
        JLabel actionLabel = new JLabel("ACTIONS");
        
        gbc.insets = new Insets(0,50,0,50);
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(idLabel, gbc);
        //gbc.insets = new Insets(0,50,0,50);
        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(nameLabel, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        centerPanel.add(passLabel, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        centerPanel.add(actionLabel, gbc);
        
        for(int i=1; i<admins.size();i++)
        {
            gbc.gridx = 1;
            gbc.gridy = i;
            JLabel localname = new JLabel(admins.get(i).getUsername());
            centerPanel.add(localname, gbc);
            names[i] = localname;
            
            gbc.gridx = 0;
            gbc.gridy = i;
            JLabel localid = new JLabel(Integer.toString(admins.get(i).getId()));
            centerPanel.add(localid, gbc);
            
            gbc.gridx = 2;
            gbc.gridy = i;
            JLabel localPass = new JLabel(admins.get(i).getPassword());
            centerPanel.add(localPass, gbc);
            passwords[i] = localPass;
            
            gbc.gridx = 3;
            gbc.gridy = i;
            buttons[i] = new JButton("EDIT");
            buttons[i].addActionListener(this);
            centerPanel.add(buttons[i], gbc);
                    
        }
        
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        
        for(int i=0;i<admins.size();i++)
        {
            if(event.equals(buttons[i]))
            {
                AdminEditFrame frame = new AdminEditFrame(i, names, passwords);
                frame.setVisible(true);
            
            }
        }
        
        if(event.equals(addButton))
        {
            NewAdminFrame frame = new NewAdminFrame(centerPanel, names, passwords, buttons);
            frame.setVisible(true);
        }
        
        if(event.equals(removeButton))
        {
            
        }
        
        
    }
    

}
