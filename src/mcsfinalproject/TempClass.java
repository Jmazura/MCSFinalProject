package mcsfinalproject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TempClass {
    
    public LinkedList<Customer> customers;
    public int customerAdd = 0;
    
    public TempClass(LinkedList<Customer> customers)
    {
        this.customers = customers;
    }
    
    public LinkedList<Customer> getCustomerlist()
    {
        return this.customers;
    }
    
    public void setCustomerList(LinkedList<Customer> customers)
    {
        this.customers = customers;
    }
    
    //JUST A RANDOM FUNCTIOn
    public JPanel showCustomers(int amountOfCustomer)
    {
        JPanel tempPanel = new JPanel(new GridLayout(amountOfCustomer+customerAdd,3,10,10));
        for(Customer index: customers)
        {
            JLabel label = new JLabel(index.getUsername());
            tempPanel.add(label);
            JLabel label1 = new JLabel(index.getPassword());
            tempPanel.add(label1);
            JLabel label2 = new JLabel(Double.toString(index.getBalance()));
            tempPanel.add(label2);
        } 
        return tempPanel;
       
    }
    
    
    // FUNCTION THAT ADDS RANDOM CUSTOMERS
    public void addRandomCustomers()
    {
        Customer customer1 = new Customer("Jm", "1234", 999.99);
        Customer customer2 = new Customer("Yuri", "1234", 999.99);
        Customer customer3 = new Customer("Vincen", "1234",999.99);
        Customer customer4 = new Customer("Lars", "1234",999.99);
        Customer customer5 = new Customer("Jom", "1234",999.99);
        
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
    }
    
    public void addCustomer(String username, String password, double balance)
    {
        Customer customer = new Customer(username, password, balance);
        customers.add(customer);
        customerAdd += 1;
    }
    
}
