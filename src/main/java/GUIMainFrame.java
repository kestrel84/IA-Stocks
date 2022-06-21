import javax.swing.*;

public class GUIMainFrame extends JFrame {
    //MAGIC NUMBERS
    //------------
    private static final int WINDOW_WIDTH = 1000;  //TODO: CONFIG FILE?????????!?!?!?!??
    private static final int WINDOW_HEIGHT = 700;


    private JPanel[] panels;

    //PANEL-RELATED MAGIC NUMBERS
    //---------------------------
    public static final int MAIN_MENU = 0;
    public static final int LOGIN_SCREEN = 1;
    public static final int CREATE_USER = 2;
    public static final int PORTFOLIO_VIEW = 3;
    public static final int ASSET_VIEW = 4;
    public static final int ASSET_SEARCH = 5;

    public GUIMainFrame(){
        //set up the frame
        setBounds(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        panels = new JPanel[6];
        //TODO: initialise and add all the panels

    }

    public void navigate(int goTo, JPanel comingFrom){
        comingFrom.setVisible(false);
        panels[goTo].setVisible(true);
    }


}
