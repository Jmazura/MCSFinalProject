package mcsfinalproject;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class MenuClass {
    
    private JPanel menuPanel;
    private JButton btn1;
    
    public MenuClass(int FRAME_WIDTH, int FRAME_HEIGHT, ActionListener AL)
    {
        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        btn1 = new JButton("BACK");
        
        btn1.addActionListener(AL);
        menuPanel.add(btn1);
        
    }
    
    public JButton getButton()
    {
        return btn1;
    }
    
    public JPanel getPanel()
    {
        return menuPanel;
    }
}
