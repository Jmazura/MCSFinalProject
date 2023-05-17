package mcsfinalproject.Entities;

public class Staff {
    
    private int id;
    private String username;
    private String password;
    
    public Staff(String user, String pass)
    {
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
