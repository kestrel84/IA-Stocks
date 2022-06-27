import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMainMenu  extends JPanel implements ActionListener {
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
        //setBounds(mainFrame.getBounds());
        setSize(new Dimension(mainFrame.getWidth(), mainFrame.getHeight()-50));
        setLayout(new GridLayout(0,1));
        width=getWidth();
        height=getHeight();

        //COMPONENT SET UP
        //----------------

        //LABELS
        //------
        title = new JLabel("MAIN MENU");
        //title.setBounds(0,0,width,height/10);
        title.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        this.add(title);


        //BUTTONS
        //-------
        toAssetSearch = new JButton("To Asset Search");
        toAssetSearch.addActionListener(this);
        toAssetSearch.setActionCommand("assetSearch");
        this.add(toAssetSearch);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "assetSearch" -> {

            }
        }
    }
}
