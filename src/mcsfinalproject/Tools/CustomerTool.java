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
import mcsfinalproject.Entities.Customer;


public class CustomerTool {
    
    private final String pathFile;
    private Gson gson;
    private List<Customer> admins = new ArrayList<>();
    
   public CustomerTool(String pathfile)
    //public AdminTool( )
    {
        this.pathFile = pathfile;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        
        read();
    }
    
    public void update(List<Customer> admin)
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
    
    public List<Customer> getList()
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
                    for(Customer index: admins)
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
            Logger.getLogger(AdminTool.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(AdminTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void removeByName(String username)
    {
        if(admins.isEmpty())
            read();
        
        boolean found = false;
        for(Customer index: admins)
        {
            if(index.getName().equals(username))
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
                if(admins.get(i).getName().equals(username))
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
    
    public void add(Customer object)
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
            Customer[] temp = gson.fromJson(reader, Customer[].class);
            if(temp != null)
            {         
                for(Customer index: temp)
                {
                    admins.add(index);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
