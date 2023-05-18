package mcsfinalproject.JPanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LoginPanel extends JPanel{
    
    private int PANEL_WIDTH, PANEL_HEIGHT;
    private ActionListener AL;
    //private ActionListener AL;
    private JButton staffButton, adminButton;
    private Font myFont = new Font("Courier", Font.BOLD, 32);
    
    
    public LoginPanel(ActionListener aL, int w, int h)
    {
        this.PANEL_HEIGHT = h;
        this.PANEL_WIDTH = w;
        this.AL = aL;
        
        this.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //DESIGN
        this.setBackground(Color.decode("#574b90"));

        staffButton = new JButton("Login As a Staff");
        adminButton = new JButton("Login As an Admin");
        staffButton.setBackground(Color.decode("#364f6b"));
        staffButton.setBorder(BorderFactory.createLineBorder(Color.decode("#fdfdfd"),7));
        staffButton.setForeground(Color.WHITE);
        adminButton.setBackground(Color.decode("#364f6b"));
        adminButton.setForeground(Color.WHITE);
        adminButton.setBorder(BorderFactory.createLineBorder(Color.decode("#fdfdfd"),7));
        JLabel orLabel = new JLabel("   OR   ");
        orLabel.setForeground(Color.WHITE);
        
        staffButton.setFont(myFont);
        adminButton.setFont(myFont);
        orLabel.setFont(myFont);
        
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(staffButton, gbc);
        gbc.gridx = 2;
        this.add(orLabel, gbc);
        gbc.gridx = 4;
        this.add(adminButton, gbc);
        
        staffButton.addActionListener(this.AL);
        adminButton.addActionListener(this.AL);
    }
    
    public JButton getStaffButton()
    {
        return staffButton;
    }
    
    public JButton getAdminButton()
    {
        return adminButton;
    }
    
    
}
