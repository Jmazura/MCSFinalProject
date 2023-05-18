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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mcsfinalproject.Entities.Staff;
import mcsfinalproject.Tools.StaffTool;

public class StaffPanel extends JPanel implements ActionListener{
    
    private StaffTool adtool = new StaffTool("src/mcsfinalproject/datas/staffs.json");
    List <Staff> staffs = adtool.getList();
    //List <JButton> buttons;
    JButton[] buttons = new JButton[50];
    JLabel[] ids = new JLabel[50];
    JLabel[] names = new JLabel[50];
    JLabel[] passwords = new JLabel[50];
    JPanel centerPanel;
    JButton addButton;
    JButton removeButton;
            
    public StaffPanel()
    {
        this.setLayout(new BorderLayout());
        
        JPanel northPanel = new JPanel(new FlowLayout());
        
        addButton  = new JButton("ADD NEW STAFF");
        removeButton = new JButton("REMOVE STAFF");
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
        
        for(int i=0; i<staffs.size();i++)
        {
            gbc.gridx = 1;
            gbc.gridy = i+1;
            JLabel localname = new JLabel(staffs.get(i).getUsername());
            names[i] = localname;
            centerPanel.add(names[i], gbc);
            
            gbc.gridx = 0;
            gbc.gridy = i+1;
            JLabel localid = new JLabel(Integer.toString(staffs.get(i).getId()));
            ids[i] = localid;
            centerPanel.add(ids[i], gbc);
            
            gbc.gridx = 2;
            gbc.gridy = i+1;
            JLabel localPass = new JLabel(staffs.get(i).getPassword());
            passwords[i] = localPass;
            centerPanel.add(passwords[i], gbc);
            
            gbc.gridx = 3;
            gbc.gridy = i+1;
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
        
        for(int i=0;i<staffs.size();i++)
        {
            if(event.equals(buttons[i]))
            {
                StaffEditFrame frame = new StaffEditFrame(i, names, passwords);
                frame.setVisible(true);
            
            }
        }
        
        if(event.equals(addButton))
        {
            NewStaffFrame frame = new NewStaffFrame(centerPanel, names, passwords, buttons);
            frame.setVisible(true);
        }
        
        if(event.equals(removeButton))
        {
            int removeId = Integer.parseInt(JOptionPane.showInputDialog("USER ID TO REMOVE:"));
            adtool.removeByID(removeId);
            centerPanel.remove(buttons[removeId]);
            centerPanel.remove(ids[removeId]);
            centerPanel.remove(names[removeId]);
            centerPanel.remove(passwords[removeId]);
            centerPanel.validate();
            centerPanel.repaint();
            
        }
        
        
    }
    

}
