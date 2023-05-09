package mcsfinalproject;

import org.json.simple.JSONObject;

public class MCSFinalProject {

    // VALID USERNAME AND PASS
    // USERNAME: ADMIN 
    // PASSWORD: ADMIN
    
    // Paths of JSON FILES
    public static String settingsJson = "src/mcsfinalproject/DATABASE.json";
    
    // MAIN CLASS ONLY FOR CALLING CLASSES
    public static void main(String[] args) {
    
        int WIDTH = 800, HEIGHT = 600;
        String TITLE = "SEGGS";
        
        
        MainFrame frame = new MainFrame(WIDTH, HEIGHT, TITLE);
        frame.showFrame();
    }
    
}
