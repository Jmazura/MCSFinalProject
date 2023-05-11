package mcsfinalproject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mcsfinalproject.JPanels.*;

public class MainFrame extends JFrame implements ActionListener{
    
    private final int FRAME_WIDTH, FRAME_HEIGHT;
    private final String FRAME_TITLE;
    
    private CardLayout jPanels = new CardLayout();
    private JPanel mainPanel = new JPanel(jPanels);
    
    private LoginPanel loginPanel;
    private MenuPanel menuPanel;
    private SplashPanel splashPanel;
    
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
        
        mainPanel.add("login",loginPanel);
        mainPanel.add("splash", splashPanel);
        mainPanel.add("menu",menuPanel);
        
        //jPanels.show(mainPanel, "login");
        jPanels.show(mainPanel, "splash");
        this.add(mainPanel, BorderLayout.CENTER);    
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object event = e.getSource();
        
        if(event.equals(splashPanel.getButton()))
        {
            jPanels.show(mainPanel, "login");
        }
        
        if(event.equals(loginPanel.getStaffLoginButton()))
        {
            if(loginPanel.isStaffLoginValid())
            {
                JOptionPane.showMessageDialog(null, "ACCESS GRANTED", "LOGIN", 1);
                System.out.println("VALID");
            }
            else{
                JOptionPane.showMessageDialog(null, "ACCESS DENIED", "LOGIN",0);
            }
        }
        
        if(event.equals(loginPanel.getAdminLoginButton()))
        {
            if(loginPanel.isAdminLoginValid())
            {
                JOptionPane.showMessageDialog(null, "ACCESS GRANTED", "LOGIN", 1);
                System.out.println("VALID");
            }
            else{
                JOptionPane.showMessageDialog(null, "ACCESS DENIED", "LOGIN",0);
            }
        }
        
        if(event.equals(loginPanel.getAdminFormButton()))
            loginPanel.getAdminFormButtonEvent();
        if(event.equals(loginPanel.getStaffFormButton()))
            loginPanel.getStaffFormButtonEvent();
        
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
