package mcsfinalproject.JPanels;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mcsfinalproject.Entities.Admin;
import mcsfinalproject.Tools.AdminTool;


public class NewAdminFrame extends JFrame implements ActionListener{
    
    private AdminTool adtol = new AdminTool("src/mcsfinalproject/datas/admins.json");
    List <Admin> admins = adtol.getList();
    
    private JLabel userLabel, passLabel;
    private JTextField userField, passField;
    private JButton addButton, cancelButton;
    
    private JPanel centerPanel;
    private JLabel[] usernames, passwords;
    JButton[] buttons;
    
    public NewAdminFrame(JPanel centerPanel, JLabel[] usernames, JLabel[] passwords, JButton[] buttons)
    {
        this.usernames = usernames;
        this.passwords = passwords;
        this.buttons = buttons;
        this.centerPanel = centerPanel;
        init();
        JPanel mainPanel = new JPanel(new GridLayout(3,2,0,0));
        
        userLabel = new JLabel("USERNAME: ");
        passLabel = new JLabel("PASSWORD: ");
        userField = new JTextField(12);
        passField = new JTextField(12);
        
        addButton = new JButton("ADD");
        cancelButton = new JButton("CANCEL");
        
        addButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        mainPanel.add(userLabel);
        mainPanel.add(userField);
        mainPanel.add(passLabel);
        mainPanel.add(passField);
        mainPanel.add(addButton);
        mainPanel.add(cancelButton);
        
        this.add(mainPanel);
        
    }
    public void init()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 150);
        this.setResizable(false);
        this.setFocusable(true);
        this.setLocationRelativeTo(null);
        this.setTitle("ADD ADMIN USER");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        
        if(event.equals(addButton))
        {
            adtol.add(new Admin(this.userField.getText(),this.passField.getText()));
            admins = adtol.getList();
            int id = admins.size()-1;
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = id;
            JLabel localid = new JLabel(Integer.toString(id));
            
            centerPanel.add(localid, gbc);
            gbc.gridx = 1;
            gbc.gridy = id;
            JLabel localuser = new JLabel(admins.get(id).getUsername());
            usernames[id] = localuser;
            centerPanel.add(localuser, gbc);
            gbc.gridx = 2;
            gbc.gridy = id;
            JLabel localpassword = new JLabel(admins.get(id).getPassword());
            passwords[id] = localpassword;
            centerPanel.add(localpassword, gbc);
            gbc.gridx = 3;
            gbc.gridy = id;
            JButton localbutton = new JButton("EDIT");
            buttons[id] = localbutton;
            centerPanel.add(localbutton, gbc);
            centerPanel.validate();
            centerPanel.repaint();
            
        }
        if(event.equals(cancelButton))
        {
            this.dispose();
        }
    }
}
