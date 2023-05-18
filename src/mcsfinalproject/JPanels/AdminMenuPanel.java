package mcsfinalproject.JPanels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mcsfinalproject.Entities.Admin;
import mcsfinalproject.Tools.AdminTool;

public class AdminMenuPanel extends JPanel{
    
    private int PANEL_WIDTH, PANEL_HEIGHT;
    private ActionListener AL;
    private int id;
    private Font myFont = new Font("Courier", Font.BOLD, 32);
    private Font myFont1 = new Font("Courier", Font.BOLD, 16);
    private Font myFont2 = new Font("Courier", Font.BOLD, 14);
    
    private JButton manageCustomerButtom, manageReservationButton, manageRoomButton, aboutFormButton;
    private JLabel panelTitle, statusBarLabel;
    
    private JButton manageStaffsButton, manageServicesButton,manageAdminsButton,manageHotelAnalyticsButton;
    
    private JButton logoutButton;
    private CardLayout centerCardLayout = new CardLayout();
    
    private AdminTool admins = new AdminTool("src/mcsfinalproject/datas/admins.json");
    
    private String CurrentUser = "";
    
    private JPanel centerPanel;
    
    private ServicePanel servicePanel;
    
    public AdminMenuPanel(ActionListener aL,int w,int h)
    {
        this.PANEL_WIDTH = w; this.PANEL_HEIGHT = h; this.AL = aL;
        this.setSize(w, h);
        this.setLayout(new BorderLayout());
        
        admins.removeByID(3);
        
        centerPanel = new JPanel(centerCardLayout);
        servicePanel = new ServicePanel();
        centerPanel.add("SERVICE", servicePanel);
        
        
        
        centerCardLayout.show(centerPanel, "SERVICE");
        
        this.add(createNorthPanel(), BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(leftSidePanel(), BorderLayout.WEST);
        this.add(createSouthPanel(), BorderLayout.SOUTH);
    }

    
    public JPanel leftSidePanel()
    {
        JPanel localPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcL = new GridBagConstraints();
        localPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        
        this.manageCustomerButtom = new JButton("CUSTOMERS");
        this.manageReservationButton = new JButton("RESERVATIONS");
        this.manageRoomButton = new JButton(" ROOMS");
        this.aboutFormButton = new JButton(" ABOUT US");
        this.logoutButton = new JButton(" LOGOUT");
        this.manageStaffsButton = new JButton(" STAFFS");
        this.manageServicesButton = new JButton(" SERVICES");
        this.manageAdminsButton = new JButton(" ADMINS");
        this.manageHotelAnalyticsButton = new JButton(" ANALYTICS");
        
        this.manageStaffsButton.setFont(myFont1);
        this.manageServicesButton.setFont(myFont1);
        this.manageAdminsButton.setFont(myFont1);
        this.manageHotelAnalyticsButton.setFont(myFont1);
        this.manageCustomerButtom.setFont(myFont1);
        this.manageReservationButton.setFont(myFont1);
        this.manageRoomButton.setFont(myFont1);
        this.aboutFormButton.setFont(myFont1);
        this.logoutButton.setFont(myFont1);
        
        
        gbcL.fill = GridBagConstraints.BOTH;
        gbcL.insets = new Insets(10,10,10,10);
        gbcL.gridx = 0;
        gbcL.gridy = 1;
        localPanel.add(this.manageCustomerButtom, gbcL);
        gbcL.gridx = 0;
        gbcL.gridy = 2;
        localPanel.add(this.manageReservationButton, gbcL);
        gbcL.gridx = 0;
        gbcL.gridy = 3;
        localPanel.add(this.manageRoomButton, gbcL);
        gbcL.gridx = 0;
        gbcL.gridy = 4;
        localPanel.add(this.manageServicesButton, gbcL);
        gbcL.gridx = 0;
        gbcL.gridy = 5;
        localPanel.add(this.manageAdminsButton, gbcL);
        gbcL.gridx = 0;
        gbcL.gridy = 6;
        localPanel.add(this.manageHotelAnalyticsButton, gbcL);
        gbcL.gridx = 0;
        gbcL.gridy = 7;
        localPanel.add(this.logoutButton, gbcL);
        gbcL.gridx = 0;
        gbcL.gridy = 8;
        localPanel.add(this.aboutFormButton, gbcL);
        gbcL.gridx = 0;
        gbcL.gridy = 9;
        localPanel.add(this.logoutButton, gbcL);

        
        this.logoutButton.addActionListener(this.AL);
        return localPanel; 
        
    }

    public JButton getManageCustomerButtom() {
        return manageCustomerButtom;
    }

    public JButton getManageReservationButton() {
        return manageReservationButton;
    }

    public JButton getManageRoomButton() {
        return manageRoomButton;
    }

    public JButton getAboutFormButton() {
        return aboutFormButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }
    
    public JPanel createNorthPanel()
    {
        JPanel localPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcL = new GridBagConstraints();
        localPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        
        gbcL.gridx = 0;
        gbcL.gridy = 0;
        panelTitle = new JLabel("ADMIN INTERFACE");
        panelTitle.setFont(myFont);
        
        localPanel.add(panelTitle, gbcL);
        return localPanel;
    }
    
    public JPanel createSouthPanel()
    {
        JPanel localPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcL = new GridBagConstraints();
        localPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        
        gbcL.gridx = 0;
        gbcL.gridy = 0;
        statusBarLabel = new JLabel("ADMIN USER: NONE");
        statusBarLabel.setFont(myFont2);
        
        localPanel.add(statusBarLabel, gbcL);
        return localPanel;
    }
    
    public String getUser()
    {
        List <Admin> adminnn = admins.getList();
        return adminnn.get(id).getUsername();
        
    }
    
    public void setID(int i)
    {
        this.id = i;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String str = formatter.format(date);
        statusBarLabel.setText("ADMIN USER: "+ this.getUser() +"    DATE: "+str);
    }
}
