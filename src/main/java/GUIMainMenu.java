import javax.swing.*;
import java.awt.*;

public class GUIMainMenu  extends JPanel {
    private GUIMainFrame mainFrame;    //parent frame holder
    private final int width, height;   //width and height of the panel for easy access

    //COMPONENTS
    //----------
    private JLabel title;
    private JButton toAssetSearch;
    private JButton Portfolio1;

    public GUIMainMenu(GUIMainFrame mainFrame){
        this.mainFrame = mainFrame; //set parent frame holder

        //set up panel
        setBounds(mainFrame.getBounds());
        setLayout(null);
        width=getWidth();
        height=getHeight();

        //COMPONENT SET UP
        //----------------

        //LABELS
        //------
        title = new JLabel("MAIN MENU");
        title.setBounds(0,0,width,height/10);
        title.setFont(new Font("Sans Serif", Font.PLAIN, 90));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        this.add(title);


        //BUTTONS
        //-------
    }
}
