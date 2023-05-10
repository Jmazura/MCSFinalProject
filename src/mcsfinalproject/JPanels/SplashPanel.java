package mcsfinalproject.JPanels;

import mcsfinalproject.Entities.Admin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mcsfinalproject.Tools.*;

public class SplashPanel extends JPanel{
    
    private int WIDTH, HEIGHT;
    private JLabel bg;
    private JButton button;

    public JButton getButton() {
        return button;
    }
    
    public SplashPanel(ActionListener AL,int w,int h)
    {
        this.WIDTH = w;
        this.HEIGHT = h;
        this.setLayout(null);
        Image image = new ImageIcon("src/mcsfinalproject/Media/HotelResort.png").getImage();
        bg = new JLabel(new ImageIcon(image.getScaledInstance(WIDTH, HEIGHT, 0)));
        
        button = new JButton("Continue");
        button.setBackground(new Color(0,0,0,0));
        button.addActionListener(AL);
        this.add(button);
        this.add(bg);
        bg.setBounds(0, 0, WIDTH, HEIGHT);
        button.setBounds((WIDTH/2)-35,(HEIGHT/2)+155,100,25 );
    }

    
}
