package mcsfinalproject.JPanels;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
    
    public MenuPanel(ActionListener AL,int w,int h)
    {
        this.setSize(w, h);
        this.setBackground(Color.blue);
    }
    
}
