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
import mcsfinalproject.Entities.Customer;
import mcsfinalproject.Tools.CustomerTool;

public class CustomersPanel extends JPanel implements ActionListener{

    
    private JPanel northPanel, centernPanel;
    
    private CustomerTool adtol = new CustomerTool("src/mcsfinalproject/datas/customers.json");
    private List<Customer> customers =  adtol.getList();
    private JButton addCustomerButton, removeCustomerButton;
    
    private JButton[] buttons = new JButton[50];
    private JLabel[] ids = new JLabel[50];
    private JLabel[] names = new JLabel[50];
    private JLabel[] typeRoomNumber = new JLabel[50];
    private JLabel[] checkIns = new JLabel[50];
    private JLabel[] checkOuts = new JLabel[50];
    
    public CustomersPanel()
    {
        this.setLayout(new BorderLayout());
        
        northPanel = createNorthPanel();
        centernPanel = createCenterPanel();
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centernPanel, BorderLayout.CENTER);
        
    }
    
    public JPanel createNorthPanel()
    {
        JPanel local = new JPanel(new FlowLayout());
        addCustomerButton = new JButton("ADD CUSTOMER");
        this.removeCustomerButton = new JButton("REMOVE CUSTOMER");
        
        local.add(this.addCustomerButton);
        local.add(this.removeCustomerButton);
        
        this.addCustomerButton.addActionListener(this);
        this.removeCustomerButton.addActionListener(this);
        return local;
    }
    
    public JPanel createCenterPanel()
    {
        JPanel local = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel t1 = new JLabel("IDS");
        JLabel t2 = new JLabel("NAMES");
        JLabel t3 = new JLabel("ACTION");
        JLabel t4 = new JLabel("ROOM");
        JLabel t5 = new JLabel("CHECK-IN");
        JLabel t6 = new JLabel("UNTIL");
      
        
        gbc.insets = new Insets(0,10,0,10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        local.add(t1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        local.add(t2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        local.add(t3, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        local.add(t4, gbc);
        gbc.gridx = 4;
        gbc.gridy = 0;
        local.add(t5, gbc);
        gbc.gridx = 5;
        gbc.gridy = 0;
        local.add(t6, gbc);
        
        for(int i=0;i<customers.size();i++)
        {
            gbc.gridx = 0;
            gbc.gridy = i+1;
            ids[i] = new JLabel(Integer.toString(customers.get(i).getId()));
            local.add(ids[i], gbc);
            
            gbc.gridx = 1;
            gbc.gridy = i+1;
            names[i] = new JLabel(customers.get(i).getName());
            local.add(names[i], gbc);
            
            gbc.gridx = 2;
            gbc.gridy = i+1;
            buttons[i] = new JButton("OPEN");
            local.add(buttons[i], gbc);
            
            gbc.gridx = 3;
            gbc.gridy = i+1;
            String show;
            switch(customers.get(i).getTypeRoomNumber())
            {
                case 0:
                    show = "Tourist Class";
                    break;
                
                case 1:
                    show = "Deluxe Class";
                    break;
                
                case 2:
                    show = "Ambassador Class";
                    break;
                
                case 3:
                    show = "Corporate Class";
                    break;
                
                case 4:
                    show = "Annex Room";
                    break;
                default:
                    show = "No Room";
                    break;
                
            }
            typeRoomNumber[i] = new JLabel(show);
            
            
            local.add(typeRoomNumber[i], gbc);
            
            gbc.gridx = 4;
            gbc.gridy = i+1;
            checkIns[i] = new JLabel(customers.get(i).getCheck_in());
            local.add(checkIns[i], gbc);
            gbc.gridx = 5;
            gbc.gridy = i+1;
            checkOuts[i] = new JLabel(customers.get(i).getUntil());
            local.add(checkOuts[i], gbc);
            
        }
        
        
        
        return local;
    }
    
    public void actionPerformed(ActionEvent e) {
        
        Object event = e.getSource();
        
        if(event.equals(this.addCustomerButton))
        {
            
        }
        if(event.equals(this.removeCustomerButton))
        {
            
        }
        
    }
    
}