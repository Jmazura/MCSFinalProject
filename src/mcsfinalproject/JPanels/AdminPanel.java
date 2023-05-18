package mcsfinalproject.JPanels;

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
    List <String> names;
    
    public AdminPanel()
    {
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //buttons.add(new JButton("TEST"));
        JLabel idLabel = new JLabel("ID");
        JLabel nameLabel = new JLabel("USERNAMES");
        JLabel passLabel = new JLabel("PASSWORDS");
        JLabel actionLabel = new JLabel("ACTIONS");
        
        gbc.insets = new Insets(0,50,0,50);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(idLabel, gbc);
        //gbc.insets = new Insets(0,50,0,50);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(nameLabel, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(passLabel, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        this.add(actionLabel, gbc);
        
        for(int i=1; i<admins.size();i++)
        {
            gbc.gridx = 1;
            gbc.gridy = i;
            JLabel localname = new JLabel(admins.get(i).getUsername());
            this.add(localname, gbc);
            
            gbc.gridx = 0;
            gbc.gridy = i;
            JLabel localid = new JLabel(Integer.toString(admins.get(i).getId()));
            this.add(localid, gbc);
            
            gbc.gridx = 2;
            gbc.gridy = i;
            JLabel localPass = new JLabel(admins.get(i).getPassword());
            this.add(localPass, gbc);
            
            gbc.gridx = 3;
            gbc.gridy = i;
            buttons[i] = new JButton("EDIT");
            buttons[i].addActionListener(this);
            this.add(buttons[i], gbc);
                    
        }
        
        
    }
    
    public void getNames()
    {
        names.clear();
        for(int i=0; i<admins.size();i++)
        {
            names.add(admins.get(i).getUsername());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        
        for(int i=0;i<admins.size();i++)
        {
            if(event.equals(buttons[i]))
            {
                AdminEditFrame frame = new AdminEditFrame(i);
                frame.setVisible(true);
            
            }
        }
        
    }
    
}
