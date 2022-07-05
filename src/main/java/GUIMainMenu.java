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
    private JButton newPortfolio;
    private JButton toPortfolio;
    private JComboBox<Portfolio> selectPortfolio;

    public GUIMainMenu(GUIMainFrame mainFrame){
        this.mainFrame = mainFrame; //set parent frame holder

        //set up panel
        //setBounds(mainFrame.getBounds());
        setSize(new Dimension(mainFrame.getWidth(), mainFrame.getHeight()-GUIMainFrame.PANEL_OFFSET));
        setLayout(new GridBagLayout());
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
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        this.add(title, c);


        //BUTTONS
        //-------
        toAssetSearch = new JButton("To Asset Search");
        toAssetSearch.addActionListener(this);
        toAssetSearch.setActionCommand("assetSearch");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.5;
        c.weighty = 0.5;
        this.add(toAssetSearch, c);


        newPortfolio = new JButton("New Portfolio");
        newPortfolio.addActionListener(this);
        newPortfolio.setActionCommand("newPortfolio");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.5;
        c.weighty = 0.5;
        this.add(newPortfolio, c);

        //PORTFOLIO SELECTOR
        //-------------------
        //TODO: when this is properly implemented, use user.getportfolios
        selectPortfolio = new JComboBox<>();




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "assetSearch" -> {

            }
            case "newPortfolio" -> {

            }

        }
    }
}
