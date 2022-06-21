import javax.swing.*;

public class GUIMainFrame extends JFrame {
    //MAGIC NUMBERS
    //------------
    private static final int WINDOW_WIDTH = 1000;  //TODO: CONFIG FILE?????????!?!?!?!??
    private static final int WINDOW_HEIGHT = 700;

    //PANEL-RELATED MAGIC NUMBERS
    //---------------------------
    private JPanel[] panels;
    private static final int MAIN_MENU = 0;
    private static final int LOGIN_SCREEN = 1;
    private static final int CREATE_USER = 2;
    private static final int PORTFOLIO_VIEW = 3;
    private static final int ASSET_VIEW = 4;
    private static final int ASSET_SEARCH = 5;

    public GUIMainFrame(){
        //set up the frame
        setBounds(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        panels = new JPanel[6];

        //
    }

}
