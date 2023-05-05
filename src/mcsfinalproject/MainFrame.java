package mcsfinalproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
    
    // CONSTRUCTER
    // THIS FUNCTION IS CALLED AUTOMATICALLY WHENEVER THE CLASS IS REFERENCED
    MainFrame()
    {
        initializeFrame(FRAME_WIDTH, FRAME_HEIGHT, FRAME_TITLE);   
        
        
        // EXAMPLE OF CLASS
        // START OF EXAMPLE OF CLASS
        TempClass tempClass = new TempClass(customers);
        
        tempClass.addRandomCustomers();
        this.add(tempClass.showCustomers());
        // END OF EXAMPLE OF CLASS
    }
    
   
    
    // FOR EVENTS OR BUTTONS PRESSED
    @Override
    public void actionPerformed(ActionEvent e) {
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
