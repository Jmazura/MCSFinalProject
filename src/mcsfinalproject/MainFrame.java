package mcsfinalproject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mcsfinalproject.JPanels.*;
import mcsfinalproject.Tools.AmenitiesTool;

public class MainFrame extends JFrame implements ActionListener{
    
    private final int FRAME_WIDTH, FRAME_HEIGHT;
    private final String FRAME_TITLE;
    
    private CardLayout jPanels = new CardLayout();
    private JPanel mainPanel = new JPanel(jPanels);
    
    private LoginPanel loginPanel;
    private MenuPanel menuPanel;
    private SplashPanel splashPanel;
    private StaffMenuPanel staffMenuPanel;
    private StaffLoginPanel staffLoginPanel;
    private AdminLoginPanel adminLoginPanel;
    private AdminMenuPanel adminMenuPanel;
    
    public MainFrame(int w,int h,String t)
    {
        FRAME_WIDTH = w; FRAME_HEIGHT= h; FRAME_TITLE = t;
        this.init();
        this.init_Panel();
        

        
        
    }
    
    public void init_Panel()
    {
        loginPanel = new LoginPanel(this, FRAME_WIDTH, FRAME_HEIGHT);
        menuPanel = new MenuPanel(this,FRAME_WIDTH, FRAME_HEIGHT);
        splashPanel = new SplashPanel(this, FRAME_WIDTH, FRAME_HEIGHT);
        staffMenuPanel = new StaffMenuPanel(this, FRAME_WIDTH, FRAME_HEIGHT);
        staffLoginPanel = new StaffLoginPanel(this, FRAME_WIDTH, FRAME_HEIGHT);
        adminLoginPanel = new AdminLoginPanel(this, FRAME_WIDTH, FRAME_HEIGHT);
        adminMenuPanel = new AdminMenuPanel(this, FRAME_WIDTH, FRAME_HEIGHT);
        
        mainPanel.add("login",loginPanel);
        mainPanel.add("splash", splashPanel);
        mainPanel.add("menu",menuPanel);
        mainPanel.add("staffMenu",staffMenuPanel);
        mainPanel.add("stafflogin", staffLoginPanel);
        mainPanel.add("adminlogin", adminLoginPanel);
        mainPanel.add("adminMenu", adminMenuPanel);
        
        //jPanels.show(mainPanel, "login");
        jPanels.show(mainPanel, "splash");
        this.add(mainPanel, BorderLayout.CENTER);    
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object event = e.getSource();
        
        
        // SPLASH SCREEN
        if(event.equals(splashPanel.getButton()))
        {
            jPanels.show(mainPanel, "login");
        }
        
        
        // LOGIN PANEL
        if(event.equals(loginPanel.getStaffButton()))    
        {
            jPanels.show(mainPanel, "stafflogin");
        }
        if(event.equals(loginPanel.getAdminButton()))  
        {
            jPanels.show(mainPanel, "adminlogin");
        }
        if(event.equals(staffLoginPanel.getBackButton()))
        {
            jPanels.show(mainPanel, "login");
            
        }
        if(event.equals(staffLoginPanel.getLoginButton()))
        {
            if(staffLoginPanel.loginValueValid())
            {
                jPanels.show(mainPanel, "staffMenu");
                staffMenuPanel.setID(staffLoginPanel.getID());
            }
            else{
                JOptionPane.showMessageDialog(null, "Credentials doesn't match", "LOGIN ERROR", 0);
            }
        }
        if(event.equals(adminLoginPanel.getBackButton()))
        {
            jPanels.show(mainPanel, "login");
        }
        if(event.equals(adminLoginPanel.getLoginButton()))
        {
            if(adminLoginPanel.loginValueValid())
            {
                jPanels.show(mainPanel, "adminMenu");
                adminMenuPanel.setID(adminLoginPanel.getID());
            }
            else{
                JOptionPane.showMessageDialog(null, "Credentials doesn't match", "LOGIN ERROR", 0);
            }
        }
        
        // STAFF MENU PANEL
        if(event.equals(staffMenuPanel.getLogoutButton()))
        {
            staffLoginPanel.getUserField().setText("");
            staffLoginPanel.getPassField().setText("");
            jPanels.show(mainPanel, "login");
        }
        
        // ADMIN MENU PANEL
        if(event.equals(adminMenuPanel.getLogoutButton()))
        {
            adminLoginPanel.getUserField().setText("");
            adminLoginPanel.getPassField().setText("");
            jPanels.show(mainPanel, "login");
        }
        
    }
    
    public void init()
    {
        this.setSize(this.FRAME_WIDTH, this.FRAME_HEIGHT);
        this.setTitle(this.FRAME_TITLE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
