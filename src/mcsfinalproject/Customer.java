package mcsfinalproject;

public class Customer {
    
    private String username, password;
    private double balance;
    
    public Customer(String username, String password, double balance)
    {
        this.username = username;
        this.password = password;
        this.balance = balance;
        System.out.println("A new Customer has been created named " + "| "+ username +" | " );
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public void setUsername(String newUsername)
    {
        this.username = newUsername;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public void setPassword(String newPassword)
    {
        this.password = newPassword;
    }
    public double getBalance()
    {
        return this.balance;
    }
    
    public void setBalance(String newBalance)
    {
        this.balance = balance;
    }
}
