package mcsfinalproject.JPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mcsfinalproject.Entities.Customer;
import mcsfinalproject.Entities.Room;
import mcsfinalproject.Tools.RoomTool;

class RoomsPanel extends JPanel{
    
    RoomTool rotol = new RoomTool("src/mcsfinalproject/datas/rooms.json");

    List<Room> rooms = rotol.getList();
    JPanel[] roomPanels = new JPanel[rooms.size()];
    JPanel[] allrooms = new JPanel[rooms.size()];
    public RoomsPanel()
    {
        this.setLayout(new BorderLayout());

        JPanel tempPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel roomslabel = new JLabel("ROOMS");
        tempPanel.add(roomslabel, gbc);
        this.add(tempPanel, BorderLayout.NORTH);
        this.add(this.getCenter(), BorderLayout.CENTER);
        
        
    }
    
    public JPanel getCenter()
    {
        JPanel local = new JPanel(new FlowLayout());
        
        for(int i=0;i<rooms.size();i++)
        {
            roomPanels[i] = roomPanel(i);
            local.add(roomPanels[i]);
        }
        
        return local;
    }
    
    public JPanel roomPanel(int id)
    {
        JPanel local = new JPanel(new GridBagLayout());
        local.setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel title_Room = new JLabel(rooms.get(id).getRoom_name());
//        JLabel customerName = new JLabel(rooms.get(id).getCustomer().getName());
        JLabel status;
        if(rooms.get(id).isAvailable())
        {
            status = new JLabel("AVAILABLE");
        }
        else{
            status = new JLabel("OCCUPIED");
        }
        if(rooms.get(id).isReservered())
        {
            status = new JLabel("RESERVED");
        }
        JLabel dummy = new JLabel("DUMMY");
        JButton infoButton = new JButton("INFO");
        
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10,10,10,10);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        local.add(title_Room, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        local.add(status, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        //local.add(customerName, gbc);
        local.add(dummy, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        local.add(infoButton, gbc);
        return local;
    }
    
    
}
