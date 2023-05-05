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

public class MainFrame extends JFrame implements ActionListener{
    
    
    // CONSTANT VARIABLES
    public final int FRAME_WIDTH = 600, FRAME_HEIGHT = 600;
    public final String FRAME_TITLE = "HOTEL PROGRAM";
    
    public LinkedList<Customer> customers = new LinkedList<Customer>(); 
    
    //FONTS
    Font courierFont = new Font("Courier",Font.BOLD, 32);
    
    // CLASSES
    public LoginClass loginClass;
    public MenuClass menuClass;
    
    public CardLayout card;
    public JPanel mainPanel;
    
    // CONSTRUCTER
    // THIS FUNCTION IS CALLED AUTOMATICALLY WHENEVER THE CLASS IS REFERENCED
    MainFrame()
    {
        
        mainPanel = new JPanel();
        mainPanel.setLayout(card);
        
        // INTIALIZING THE FRAME DEFAULT PROPERTIES
        initializeFrame(FRAME_WIDTH, FRAME_HEIGHT, FRAME_TITLE);   
       
        // CALLING THE LOGIN CLASS AND ADDING IT TO THE FRAME(THIS)
        loginClass = new LoginClass(FRAME_WIDTH, FRAME_HEIGHT, this);
        menuClass = new MenuClass(FRAME_WIDTH, FRAME_HEIGHT,this);
        
        mainPanel.add( "login",loginClass.getPanel());
        mainPanel.add("menu",menuClass.getPanel());
        /*
        card.show(mainPanel, "login");
        this.add(mainPanel, BorderLayout.CENTER);
        this.pack();
        */
        this.add(loginClass.getPanel(),BorderLayout.CENTER);
    
    }
    
    // FOR EVENTS OR BUTTONS PRESSED
    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = new Object();
        event = e.getSource();
        
        
        // LOGIN CLASS
        if(event.equals(loginClass.getLoginButton()))
        {
            if(loginClass.loginValid())
            {
                
                this.add(menuClass.getPanel(), BorderLayout.CENTER);
            }
        }
        
        
        // MENU CLASS
        if(event.equals(menuClass.getButton()))
        {
            this.remove(0);
            this.add(loginClass.getPanel());
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

     
    // CALL THIS TO SEE AN EXAMPLE
    public void ExampleMethod()
    {
         
        // EXAMPLE OF CLASS
        // START OF EXAMPLE OF CLASS
        TempClass tempClass = new TempClass(customers);
        
        tempClass.addRandomCustomers();
        JPanel pane = tempClass.showCustomers();
        this.add(pane);
        tempClass.addCustomer("Jeff", "1234", 999.99);
        
        this.remove(pane);
        this.add(tempClass.showCustomers());
      
        
        // END OF EXAMPLE OF CLASS
    }
    
}
