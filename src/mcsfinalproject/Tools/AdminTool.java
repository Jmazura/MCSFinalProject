package mcsfinalproject.Tools;

import mcsfinalproject.Entities.Admin;
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
    //public AdminTool( )
    {
        this.pathFile = pathfile;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        read();
    }
    
    public void update(List<Admin> admin)
    {
        try {
            FileWriter writer = null;
            
            writer = new FileWriter(this.pathFile);
            gson.toJson(admin, writer);
            writer.close();
            read();
        } catch (IOException ex) {
            Logger.getLogger(AdminTool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Admin> getList()
    {
        return admins;
    }
    
    public void removeByID(int idNumber)
    {
        if(admins.isEmpty())
            read();
        
        boolean found = false;
        
        
        FileWriter writer = null;
        try {
            writer = new FileWriter(this.pathFile);
            
            for(int i=0;i<admins.size();i++)
            {
                if(admins.get(i).getId() == idNumber)
                {
                    admins.remove(i);
                    for(Admin index: admins)
                    {
                        if(index.getId() == idNumber+1)
                        {
                            found = true;
                        }
                        if(found)
                        {
                            index.setId(index.getId()-1);
                        }
                    }
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
        
        boolean found = false;
        for(Admin index: admins)
        {
            if(index.getUsername().equals(username))
            {
                found = true;
            }
            if(found)
            {
                index.setId(index.getId()-1);
            }
        }
        
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
        admins.clear();
        read();
        object.setId(admins.get(admins.size()-1).getId()+1);
        
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
        admins.clear();
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
