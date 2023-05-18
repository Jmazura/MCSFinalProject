package mcsfinalproject.JPanels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mcsfinalproject.Tools.CustomerTool;

public class CustomersPanel extends JPanel implements ActionListener{

    
    private JPanel northPanel, centernPanel;
    
    private JButton addCustomerButton, removeCustomerButton;
    
    private JButton[] buttons = new JButton[50];
    private JLabel[] ids = new JLabel[50];
    private JLabel[] names = new JLabel[50];
    
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
        
        CustomerTool asd = new CustomerTool("src/mcsfinalproject/datas/customers.json");
        
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
        
        
        
        
        return local;
    }
    
    public void actionPerformed(ActionEvent e) {
    }
    
}