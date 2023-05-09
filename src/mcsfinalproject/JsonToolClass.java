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

public class JsonToolClass {
    
    public List<Customer> customers = new ArrayList<>();
    public Gson gson;
    
    public JsonToolClass()
    {
        gson = new GsonBuilder().setPrettyPrinting().create();
        //fill();
        read();
        add(new Customer("JM", "123", 200));
        add(new Customer("HALLO", "123", 200));
        read();
        //Gson gson = new GsonBuilder()
        
        
    }
    
    public void add(Customer object)
    {
        customers.add(object);
        write();
    }
    
    public void write()
    {
        try {
            FileWriter writer = new FileWriter("src/mcsfinalproject/customers.json");
            gson.toJson(customers, writer);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(JsonToolClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fill()
    {
        for(int i=0; i<+10;i++)
        {
            Customer customer = new Customer("Name"+(i+1),"123",200);
            customers.add(customer);
        }
    }
    
    public void read()
    {
        try {
            FileReader reader = new FileReader("src/mcsfinalproject/customers.json");
            Customer[] customerrs = gson.fromJson(reader, Customer[].class);
            
            for(Customer index : customerrs)
            {
                customers.add(index);
                System.out.println(index.getUsername());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsonToolClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

