import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAssetSearch  extends JPanel implements ActionListener {
    private GUIMainFrame mainFrame;    //parent frame holder
    private final int width, height;   //width and height of the panel for easy acess

    //COMPONENTS
    JLabel title;
    JComboBox<String> assetSelector;
    JLabel assetInfo;
    JButton toAssetView;
    JButton backToMainMenu;

    public GUIAssetSearch(GUIMainFrame mainFrame) {
        this.mainFrame = mainFrame; //set parent frame holder

        //set up panel
        //setBounds(mainFrame.getBounds());
        setSize(new Dimension(mainFrame.getWidth(), mainFrame.getHeight() - GUIMainFrame.PANEL_OFFSET));
        setLayout(new GridLayout(0, 1));
        width = getWidth();
        height = getHeight();

        //TITLE
        title = new JLabel("ASSET SEARCH");
        title.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        this.add(title);

        //ASSET SELECTOR
        //TODO: MANUALLY CREATE A LIST OF AV-VALID STOCKS TO PICK FROM

        assetSelector = new JComboBox<>();
        assetSelector.addActionListener(this);
        assetSelector.setActionCommand("selectAsset");
        this.add(assetSelector);

        assetInfo = new JLabel("Please select an asset");
        assetInfo.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        assetInfo.setHorizontalAlignment(SwingConstants.CENTER);
        assetInfo.setVerticalAlignment(SwingConstants.CENTER);
        this.add(assetInfo);

        toAssetView = new JButton("Please select an asset");
        toAssetView.addActionListener(this);
        toAssetView.setActionCommand("assetView");
        this.add(toAssetView);

        backToMainMenu = new JButton("back to main menu");
        backToMainMenu.addActionListener(this);
        backToMainMenu.setActionCommand("mainMenu");
        this.add(backToMainMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "mainMenu" -> mainFrame.navigate(GUIMainFrame.MAIN_MENU, this);
        }
    }
}
