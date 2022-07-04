import javax.swing.*;
import java.awt.*;
import java.security.DigestException;

public class GUIMainFrame extends JFrame {
    //MAGIC NUMBERS
    //------------
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 300;
    public static final int PANEL_OFFSET = 39;

    private JPanel[] panels;

    //PANEL-RELATED MAGIC NUMBERS
    //---------------------------
    public static final int MAIN_MENU = 0;
    public static final int LOGIN_SCREEN = 1;
    public static final int CREATE_USER = 2;
    public static final int PORTFOLIO_VIEW = 3;
    public static final int ASSET_VIEW = 4;
    public static final int ASSET_SEARCH = 5;

    //USER CURRENTLY USING THE PROGRAM
    //--------------------------------
    public static User currentUser;

    //GENERAL FILE PATH
    //-----------------
    public static String generalFilePath;



    public GUIMainFrame(String filePath){
        //set the static file path
        generalFilePath = filePath;


        //set up the frame
        setLayout(null);
        //setBounds(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Stonk Tracker");

        //TODO: initialise and add ALL panels
        panels = new JPanel[6];
        panels[0] = new GUIMainMenu(this);
        panels[1] = new GUILoginScreen(this);
        panels[2] = new GUICreateUser(this);

        for (int i = 0; i < 3; i++) {
            add(panels[i]);
            panels[i].setVisible(false);
        }

        panels[1].setVisible(true);
    }

    public void navigate(int goTo, JPanel comingFrom){
        comingFrom.setVisible(false);
        panels[goTo].setVisible(true);
    }

    public int getHeight() {
        return WINDOW_HEIGHT;
    }
    public int getWidth() {
        return WINDOW_WIDTH;
    }

}
