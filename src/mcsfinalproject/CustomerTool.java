package mcsfinalproject;

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


public class CustomerTool {
    
    public final String pathFile;
    public Gson gson;
    public List<Customer> customers = new ArrayList<>();
    
    public CustomerTool(String pathfile)
    {
        this.pathFile = pathfile;
        
        gson = new GsonBuilder().setPrettyPrinting().create();
        read();  
    }
    
    public List<Customer> getList()
    {
        return customers;
    }
    
    public void removeByUsername(String username)
    {
        if(customers.isEmpty())
            read();
        
        FileWriter writer = null;
        try {
            writer = new FileWriter(this.pathFile);
            
            for(int i=0;i<customers.size();i++)
            {
                if(customers.get(i).getUsername().equals(username))
                {
                    customers.remove(i);
                    break;
                }
            }
            
            gson.toJson(customers, writer);
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
        if(customers.isEmpty())
            read();
        
        FileWriter writer = null;
        try {
            writer = new FileWriter(this.pathFile);
            customers.add(object);
            gson.toJson(customers, writer);
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
    
    private void read()
    {
        try {
            FileReader reader = new FileReader(this.pathFile);
            //customers = gson.fromJson(reader, customers.getClass());
            Customer[] temp = gson.fromJson(reader, Customer[].class);
            if(temp != null)
            {         
                for(Customer index: temp)
                {
                    customers.add(index);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
