package mcsfinalproject;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class MenuClass extends JPanel{
    
    public JButton btn1;
    public int FRAME_WIDTH, FRAME_HEIGHT;
    public MenuClass(int FRAME_WIDTH, int FRAME_HEIGHT, ActionListener AL)
    {
        this.FRAME_WIDTH = FRAME_WIDTH;
        this.FRAME_HEIGHT = FRAME_HEIGHT;
        this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        btn1 = new JButton("BACK");
        
        btn1.addActionListener(AL);
        this.add(btn1);
        
    }
   
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g2d);
        Image lars = new ImageIcon("src/mcsfinalproject/lars.jpg").getImage();
        
        g2d.drawImage(lars, 0,0,this.FRAME_WIDTH, this.FRAME_HEIGHT,null);
    }
    
}
