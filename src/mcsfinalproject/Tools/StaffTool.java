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
import mcsfinalproject.Entities.Staff;

public class StaffTool {
    
    private final String pathFile;
    private Gson gson;
    private List<Staff> staffs = new ArrayList<>();
    
    public StaffTool(String pathfile)
    {
        this.pathFile = pathfile;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        read();
    }
    
    public void update(List<Staff> admin)
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
    
    public List<Staff> getList()
    {
        return staffs;
    }
    
    public void removeByID(int idNumber)
    {
        if(staffs.isEmpty())
            read();
        
        boolean found = false;
        for(Staff index: staffs)
        {
            if(index.getId() == idNumber)
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
            
            for(int i=0;i<staffs.size();i++)
            {
                if(staffs.get(i).getId() == idNumber)
                {
                    staffs.remove(i);
                    break;
                }
            }
            
            gson.toJson(staffs, writer);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(StaffTool.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(StaffTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void removeByUsername(String username)
    {
        if(staffs.isEmpty())
            read();
        
        boolean found = false;
        for(Staff index: staffs)
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
            
            for(int i=0;i<staffs.size();i++)
            {
                if(staffs.get(i).getUsername().equals(username))
                {
                    staffs.remove(i);
                    break;
                }
            }
            
            gson.toJson(staffs, writer);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(StaffTool.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(StaffTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void add(Staff object)
    {
        if(staffs.isEmpty())
            read();
        
        object.setId(staffs.get(staffs.size()-1).getId()+1);
  
        
        FileWriter writer = null;
        try {
            writer = new FileWriter(this.pathFile);
            staffs.add(object);
            gson.toJson(staffs, writer);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(StaffTool.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(StaffTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

       
        
        
    }
    
    public void read()
    {
        try {
            FileReader reader = new FileReader(this.pathFile);
            //customers = gson.fromJson(reader, customers.getClass());
            Staff[] temp = gson.fromJson(reader, Staff[].class);
            if(temp != null)
            {         
                for(Staff index: temp)
                {
                    staffs.add(index);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
