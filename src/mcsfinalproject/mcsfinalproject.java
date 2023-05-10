package mcsfinalproject;

public class mcsfinalproject {
    
    public static final int FRAME_WIDTH = 800, FRAME_HEIGHT = 600;
    public static final String FRAME_TITLE = "HOTEL AND RESORT AMENITIES FOR BLACK BEAN";
    
    public static void main(String[] args) 
    {
        MainFrame mainFrame = new MainFrame(FRAME_WIDTH, FRAME_HEIGHT,FRAME_TITLE);
        mainFrame.setVisible(true);
    }
}
