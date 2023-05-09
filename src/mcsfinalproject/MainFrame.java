package mcsfinalproject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.simple.JSONObject;

public class MainFrame extends JFrame implements ActionListener{
    
    
    // CONSTANT VARIABLES
    public final int FRAME_WIDTH, FRAME_HEIGHT;
    public final String FRAME_TITLE;
    
    public LinkedList<Customer> customers = new LinkedList<Customer>(); 
    
    //FONTS
    Font courierFont = new Font("Courier",Font.BOLD, 32);
    
    // CUSTOMED MADE
    //JPanel Classes
    MenuClass menuPanel;
    LoginClass loginPanel;
    
    //JPanel Holder
    CardLayout JPanels = new CardLayout();
    JPanel mainPanel = new JPanel(JPanels);
 
    // CONSTRUCTER
    // THIS FUNCTION IS CALLED AUTOMATICALLY WHENEVER THE CLASS IS REFERENCED
    public MainFrame(int WIDTH, int HEIGHT, String TITLE)
    {
        this.FRAME_HEIGHT = HEIGHT;
        this.FRAME_WIDTH = WIDTH;
        this.FRAME_TITLE = TITLE;
        // INTIALIZING THE FRAME DEFAULT PROPERTIES
        initializeFrame(FRAME_WIDTH, FRAME_HEIGHT, FRAME_TITLE);   
        initializeJPanels();
        
        JsonToolClass a = new JsonToolClass();
        
    }
    
    public void initializeJPanels()
    {   
        menuPanel = new MenuClass(FRAME_WIDTH, FRAME_HEIGHT, this);
        loginPanel = new LoginClass(FRAME_WIDTH, FRAME_HEIGHT, this);
        mainPanel.add("MENU", menuPanel);
        mainPanel.add("LOGIN", loginPanel);
        
        JPanels.show(mainPanel, "LOGIN");
        this.add(mainPanel);
    }
    
    // FOR EVENTS OR BUTTONS PRESSED
    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = new Object();
        event = e.getSource();
       
        if(event.equals(loginPanel.loginButton))
        {
            if(loginPanel.loginValid())
                JPanels.show(mainPanel, "MENU");
                
        }
        
        if(event.equals(menuPanel.btn1))
        {
            JPanels.show(mainPanel, "LOGIN");
        }
    }
    
    
    
    
    
    // DEFAULT FRAME FUNCTIONS
    public void initializeFrame(int width,int height,String title)
    {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setFocusable(true);
        this.setSize(new Dimension(width, height));
        this.setLocationRelativeTo(null);
        
    }
    
     // A FUNCTION THAT SHOW THE FRAME
    public void showFrame()
    {
        this.setVisible(true);
    }

  
    
}
