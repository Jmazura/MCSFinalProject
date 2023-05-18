package mcsfinalproject.Entities;

import java.util.Dictionary;
import java.util.Hashtable;


public class Customer {
    
    private String name;
    private boolean isSeniorCitizen;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsSeniorCitizen() {
        return isSeniorCitizen;
    }

    public void setIsSeniorCitizen(boolean isSeniorCitizen) {
        this.isSeniorCitizen = isSeniorCitizen;
    }
    
    public Customer()
    {
        
    }
    
}
