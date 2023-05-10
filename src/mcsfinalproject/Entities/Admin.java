package mcsfinalproject.Entities;

public class Admin {
    
    private int id;
    private String username;
    private String password;
    
    public Admin(int identificationNumber,String user, String pass)
    {
        this.id = identificationNumber;
        this.username = user;
        this.password = pass;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
