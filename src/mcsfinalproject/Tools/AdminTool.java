package mcsfinalproject.Tools;

import Entities.Admin;
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


public class AdminTool {
    
    private final String pathFile;
    private Gson gson;
    private List<Admin> admins = new ArrayList<>();
    
    public AdminTool(String pathfile)
    {
        this.pathFile = pathfile;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        read();
    }
    
    public List<Admin> getList()
    {
        return admins;
    }
    
    public void removeByID(int idNumber)
    {
        if(admins.isEmpty())
            read();
        
        FileWriter writer = null;
        try {
            writer = new FileWriter(this.pathFile);
            
            for(int i=0;i<admins.size();i++)
            {
                if(admins.get(i).getId() == idNumber)
                {
                    admins.remove(i);
                    break;
                }
            }
            
            gson.toJson(admins, writer);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(CustomerTool.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void removeByUsername(String username)
    {
        if(admins.isEmpty())
            read();
        
        FileWriter writer = null;
        try {
            writer = new FileWriter(this.pathFile);
            
            for(int i=0;i<admins.size();i++)
            {
                if(admins.get(i).getUsername().equals(username))
                {
                    admins.remove(i);
                    break;
                }
            }
            
            gson.toJson(admins, writer);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(CustomerTool.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void add(Admin object)
    {
        if(admins.isEmpty())
            read();
        
        FileWriter writer = null;
        try {
            writer = new FileWriter(this.pathFile);
            admins.add(object);
            gson.toJson(admins, writer);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(CustomerTool.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

       
        
        
    }
    
    public void read()
    {
        try {
            FileReader reader = new FileReader(this.pathFile);
            //customers = gson.fromJson(reader, customers.getClass());
            Admin[] temp = gson.fromJson(reader, Admin[].class);
            if(temp != null)
            {         
                for(Admin index: temp)
                {
                    admins.add(index);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
