package mcsfinalproject.Tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mcsfinalproject.Entities.Room;


public class RoomTool {
    
    private final String pathFile;
    private Gson gson;
    private List<Room> rooms = new ArrayList<>();
    
   public RoomTool(String pathfile)
    {
        this.pathFile = pathfile;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        read();
       

    }
   
   public void addd(Room object)
   {     
        System.out.println("test");
        read();
        rooms.add(object);
        update(rooms);
   }
    
    public void update(List<Room> n)
    {
        try {
            FileWriter writer = null;
            
            writer = new FileWriter(this.pathFile);
            gson.toJson(n, writer);
            writer.close();
            read();
        } catch (IOException ex) {
            Logger.getLogger(RoomTool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Room> getList()
    {
        return rooms;
    }
    
  
    
    public void read()
    {
        rooms.clear();
        try {
            FileReader reader = new FileReader(this.pathFile);
            //customers = gson.fromJson(reader, customers.getClass());
            Room[] temp = gson.fromJson(reader, Room[].class);
            if(temp != null)
            {         
                for(Room index: temp)
                {
                    rooms.add(index);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
