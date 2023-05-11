package mcsfinalproject.JPanels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mcsfinalproject.Entities.Admin;
import mcsfinalproject.Tools.AdminTool;

public class LoginPanel extends JPanel{
    
    private String adminFilePath = "src/mcsfinalproject/datas/admins.json";
    
    private int PANEL_WIDTH, PANEL_HEIGHT;
    private ActionListener al;
    
    private JTextField staffUserField, staffPassField, adminUserField, adminPassField;
    private JButton staffLoginButton, adminFormButton, adminLoginButton, staffFormButton;
    
    private CardLayout forms;
    private JPanel formsPanel, staffFormPanel, adminFormPanel;
    
    private AdminTool adminJson = new AdminTool(this.adminFilePath);
    
    public LoginPanel(ActionListener aL, int width,int height)
    {
        this.al = aL;
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.setSize(new Dimension(this.PANEL_WIDTH, this.PANEL_HEIGHT));
        this.setLayout(new BorderLayout());
        
        this.add(sidePanel(), BorderLayout.LINE_START);
        //this.setBackground(new Color(255,255,255));
    }
    
    public JPanel sidePanel()
    {
        JPanel sideMainPanel = new JPanel(new GridBagLayout());
        sideMainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        GridBagConstraints sGBC = new GridBagConstraints();
        
        forms = new CardLayout();
        formsPanel = new JPanel(forms);
        
        staffFormPanel = staffFormPanel();
        adminFormPanel = adminFormPanel();
        
        sGBC.insets = new Insets(0,10,0,10);
        sGBC.gridx = 0;
        sGBC.gridy = 0;
        
        formsPanel.add("staff", staffFormPanel);
        formsPanel.add("admin", adminFormPanel);
        
        forms.show(formsPanel, "staff");
        sideMainPanel.add(formsPanel, sGBC);
        return sideMainPanel;
    }
    
    public JPanel staffFormPanel()
    {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        GridBagConstraints fGBC = new GridBagConstraints();
        
        JLabel staffLoginLabel = new JLabel("STAFF LOGIN");
        JLabel staffUserLabel = new JLabel("Username:");
        JLabel staffPassLabel = new JLabel("Password:");
        
        staffUserField = new JTextField(10);
        staffPassField = new JTextField(10);
        
        staffLoginButton = new JButton("LOGIN");
        adminFormButton = new JButton("LOGIN AS ADMIN");
        
        fGBC.gridx = 0;
        fGBC.gridy = 0;
        fGBC.gridwidth = 2;
        formPanel.add(staffLoginLabel, fGBC);
        fGBC.fill = GridBagConstraints.HORIZONTAL;
        fGBC.gridwidth = 1;
        fGBC.gridx = 0;
        fGBC.gridy = 1;
        formPanel.add(staffUserLabel, fGBC);
        fGBC.gridx = 1;
        fGBC.gridy = 1;
        formPanel.add(staffUserField, fGBC);
        fGBC.gridx = 0;
        fGBC.gridy = 2;
        formPanel.add(staffPassLabel, fGBC);
        fGBC.gridx = 1;
        fGBC.gridy = 2;
        formPanel.add(staffPassField, fGBC);
        
        fGBC.fill = GridBagConstraints.NONE;
        fGBC.insets = new Insets(10,0,0,0);
        
        fGBC.gridwidth = 2;
        fGBC.gridx = 0;
        fGBC.gridy = 3;
        formPanel.add(staffLoginButton, fGBC);
        
        fGBC.gridwidth = 2;
        fGBC.gridx = 0;
        fGBC.gridy = 4;
        formPanel.add(adminFormButton, fGBC);
        
        this.staffLoginButton.addActionListener(this.al);
        this.adminFormButton.addActionListener(this.al);
        return formPanel;
    }
    
    public JPanel adminFormPanel()
    {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        GridBagConstraints fGBC = new GridBagConstraints();
        
        JLabel adminLoginLabel = new JLabel("ADMIN LOGIN");
        JLabel adminUserLabel = new JLabel("Username:");
        JLabel adminPassLabel = new JLabel("Password:");
        
        adminUserField = new JTextField(10);
        adminPassField = new JTextField(10);
        
        adminLoginButton = new JButton("LOGIN");
        staffFormButton = new JButton("LOGIN AS STAFF");
        
        fGBC.gridx = 0;
        fGBC.gridy = 0;
        fGBC.gridwidth = 2;
        formPanel.add(adminLoginLabel, fGBC);
        fGBC.fill = GridBagConstraints.HORIZONTAL;
        fGBC.gridwidth = 1;
        fGBC.gridx = 0;
        fGBC.gridy = 1;
        formPanel.add(adminUserLabel, fGBC);
        fGBC.gridx = 1;
        fGBC.gridy = 1;
        formPanel.add(adminUserField, fGBC);
        fGBC.gridx = 0;
        fGBC.gridy = 2;
        formPanel.add(adminPassLabel, fGBC);
        fGBC.gridx = 1;
        fGBC.gridy = 2;
        formPanel.add(adminPassField, fGBC);
        
        fGBC.fill = GridBagConstraints.NONE;
        fGBC.insets = new Insets(10,0,0,0);
        
        fGBC.gridwidth = 2;
        fGBC.gridx = 0;
        fGBC.gridy = 3;
        formPanel.add(adminLoginButton, fGBC);
        
        fGBC.gridwidth = 2;
        fGBC.gridx = 0;
        fGBC.gridy = 4;
        formPanel.add(staffFormButton, fGBC);
        
        this.adminLoginButton.addActionListener(this.al);
        this.staffFormButton.addActionListener(this.al);
        return formPanel;
    }
    
    public void contentPanel()
    {
        
    }
    

    
    // BUTTONS & EVENTS
    
     public JButton getStaffLoginButton() {
        return staffLoginButton;
    }
     
    public void getStaffLoginButtonEvent()
    {
        
    }
    
    public boolean isStaffLoginValid()
    {
        boolean user = false, pass = false, isAdmin = false;
        String username = this.staffUserField.getText();
        String password = this.staffPassField.getText();
        List<Admin> admins = adminJson.getList();
        for(int i=0; i<admins.size(); i++)
        {
            if(!admins.get(i).getIsAdmin())
            {
                if(username.equals(admins.get(i).getUsername()))
                {
                    user = true;
                }else{
                    user = false;
                    continue;
                }
                if(password.equals(admins.get(i).getPassword()))
                {
                    pass = true;
                    break;
                }else{
                    pass = false;
                    continue;
                }
            }
            
        }
        if(user && pass)
        {
            return true;
        }else{
            return false;
        }
    }
    

    public JButton getAdminFormButton() {
        return adminFormButton;
    }
    
    public void getAdminFormButtonEvent()
    {
        this.forms.show(this.formsPanel, "admin");
    }
    
    public boolean isAdminLoginValid()
    {
        boolean user = false, pass = false, isAdmin = false;
        String username = this.adminUserField.getText();
        String password = this.adminPassField.getText();
        List<Admin> admins = adminJson.getList();
        for(int i=0; i<admins.size(); i++)
        {
            if(admins.get(i).getIsAdmin())
            {
                if(username.equals(admins.get(i).getUsername()))
                {
                    user = true;
                }else{
                    user = false;
                    continue;
                }
                if(password.equals(admins.get(i).getPassword()))
                {
                    pass = true;
                    break;
                }else{
                    pass = false;
                    continue;
                }
            }
            
        }
        if(user && pass)
        {
            return true;
        }else{
            return false;
        }
    }

    public JButton getAdminLoginButton() {
        return adminLoginButton;
    }

    public void getAdminLoginButtonEvent() {
        
    }
    
    public JButton getStaffFormButton() {
        return staffFormButton;
    }
    
    public void getStaffFormButtonEvent() {
        this.forms.show(this.formsPanel, "staff");
    }

}
