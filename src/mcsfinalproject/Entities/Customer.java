package mcsfinalproject.Entities;

import java.util.Dictionary;
import java.util.Hashtable;


public class Customer {
    
    private String name;
    private boolean isSeniorCitizen;
    private Dictionary<String, Double> pendingPayments = new Hashtable<>();
    private Dictionary<String, String> logInHistory = new Hashtable<>();
    private Dictionary<String, String> logOutHIstory = new Hashtable<>();
    
    public Customer()
    {
        
    }
    
}
