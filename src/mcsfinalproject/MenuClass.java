package mcsfinalproject;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class MenuClass extends JPanel{
    
    public JButton btn1;
    
    public MenuClass(int FRAME_WIDTH, int FRAME_HEIGHT, ActionListener AL)
    {
        
        this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        btn1 = new JButton("BACK");
        
        btn1.addActionListener(AL);
        this.add(btn1);
        
    }
   
}
