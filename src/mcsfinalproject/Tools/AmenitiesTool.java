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
import mcsfinalproject.Entities.Amenities;



public class AmenitiesTool {
    
    private final String pathFile;
    private Gson gson;
    //private List<Amenities> amenities = new ArrayList<>();
    private Amenities amenities = new Amenities();
  
    
    public AmenitiesTool(String pathfile)
    {
        this.pathFile = pathfile;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        read();
    }
    
    
    
    /*
    public List<Amenities> getList()
    {
        return amenities;
    }  
    */
    
    public Amenities getAmenities()
    {
        return amenities;
    }
    
    public void update(Amenities ame)
    {
        try {
            FileWriter writer;
            writer = new FileWriter(this.pathFile);
            
            
            
            gson.toJson(ame, writer);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(AmenitiesTool.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void read()
    {
        try {
            FileReader reader = new FileReader(this.pathFile);
            //customers = gson.fromJson(reader, customers.getClass());
            //Amenities[] temp = gson.fromJson(reader, Amenities[].class);
            Amenities temp = gson.fromJson(reader, Amenities.class);
            
            if(temp != null)
            {         
                /*
                for(Amenities index: temp)
                {
                    amenities.add(index);
                }
                */
                amenities = temp;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}

