package mcsfinalproject.JPanels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mcsfinalproject.Entities.Staff;
import mcsfinalproject.Tools.StaffTool;

public class StaffMenuPanel extends JPanel implements ActionListener{
    
    private int PANEL_WIDTH, PANEL_HEIGHT;
    private ActionListener AL;
    private int id;
    private Font myFont = new Font("Courier", Font.BOLD, 32);
    private Font myFont1 = new Font("Courier", Font.BOLD, 16);
    
    private JButton manageCustomerButtom, manageReservationButton, manageRoomButton, aboutFormButton;
    private JLabel panelTitle, statusBarLabel;
    
    private JButton logoutButton;
    
    private StaffTool staffs = new StaffTool("src/mcsfinalproject/datas/staffs.json");
    
    private String CurrentUser = "";
    
    private JPanel centerPanel,servicePanel,reservationPanel,roomsPanel,customerPanel,aboutUsPanel,customersPanel;
    private CardLayout centerCardLayout = new CardLayout();
    
    public StaffMenuPanel(ActionListener aL,int w,int h)
    {
        this.PANEL_WIDTH = w; this.PANEL_HEIGHT = h; this.AL = aL;
        this.setSize(w, h);
        this.setLayout(new BorderLayout());
        
        centerPanel = new JPanel(centerCardLayout);
        servicePanel = new ServicePanel();
        reservationPanel = new ReservationPanel();
        roomsPanel = new RoomsPanel();
        customersPanel = new CustomersPanel();
        aboutUsPanel = new AboutUsPanel();
        centerPanel.add("SERVICE", servicePanel);
        centerPanel.add("RESERVATION", reservationPanel);
        centerPanel.add("ROOMS", roomsPanel);
        centerPanel.add("CUSTOMER", customersPanel);
        centerPanel.add("ABOUT US", aboutUsPanel);
        
        
        
        centerCardLayout.show(centerPanel, "SERVICE");
        
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(createNorthPanel(), BorderLayout.NORTH);
        this.add(createLeftPanel(), BorderLayout.WEST);
        this.add(createSouthPanel(), BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    Object event = e.getSource();
    
        if(event.equals(this.manageReservationButton))
        {
            centerCardLayout.show(centerPanel, "RESERVATION");
        }
        if(event.equals(this.manageRoomButton))
        {
            centerCardLayout.show(centerPanel, "ROOMS");
        }
        if(event.equals(this.manageCustomerButtom))
        {
            centerCardLayout.show(centerPanel, "CUSTOMER");
        }
        if(event.equals(this.aboutFormButton))
        {
            centerCardLayout.show(centerPanel, "ABOUT US");
        }

    }
    public JPanel createLeftPanel()
    {
        JPanel localPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcL = new GridBagConstraints();
        localPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        
        this.manageCustomerButtom = new JButton("CUSTOMERS");
        this.manageReservationButton = new JButton("RESERVATIONS");
        this.manageRoomButton = new JButton(" ROOMS");
        this.aboutFormButton = new JButton(" ABOUT US");
        this.logoutButton = new JButton(" LOGOUT ");
        
        this.manageCustomerButtom.addActionListener(this);
        this.manageReservationButton.addActionListener(this);
        this.manageRoomButton.addActionListener(this);
        this.aboutFormButton.addActionListener(this);
        this.logoutButton.addActionListener(this);
        
        this.logoutButton.setFont(myFont1);
        this.manageCustomerButtom.setFont(myFont1);
        this.manageReservationButton.setFont(myFont1);
        this.manageRoomButton.setFont(myFont1);
        this.aboutFormButton.setFont(myFont1);
        
        
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
        localPanel.add(this.aboutFormButton, gbcL);
        gbcL.gridx = 0;
        gbcL.gridy = 5;
        localPanel.add(this.logoutButton, gbcL);
        
        this.logoutButton.addActionListener(AL);
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
      
        gbcL.gridx = 0;
        gbcL.gridy = 0;
        panelTitle = new JLabel("STAFF INTERFACE");
        panelTitle.setFont(myFont);
        
        localPanel.add(panelTitle, gbcL);
        return localPanel;
    }
    
    public JPanel createSouthPanel()
    {
        JPanel localPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcL = new GridBagConstraints();
        
        gbcL.gridx = 0;
        gbcL.gridy = 0;
        statusBarLabel = new JLabel("STAFF USER: NONE");
        statusBarLabel.setFont(myFont);
        
        localPanel.add(statusBarLabel, gbcL);
        return localPanel;
    }
    
    public String getUser()
    {
        List <Staff> stafff = staffs.getList();
        return stafff.get(id).getUsername();
        
    }
    
    public void setID(int i)
    {
        this.id = i;
        statusBarLabel.setText("STAFF USER: "+ this.getUser());
    }

}
