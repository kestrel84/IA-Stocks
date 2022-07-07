import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPortfolioView extends JPanel implements ActionListener {
    private GUIMainFrame mainFrame;    //parent frame holder
    private final int width, height;   //width and height of the panel for easy access

    //PORTFOLIO CURRENTLY BEING VIEWED
    //--------------------------------
    private static Portfolio currentPortfolio;

    //COMPONENTS
    JLabel title;
    JLabel totalValue;
    //TODO: GRAPHS????
    JComboBox<String> assetList;
    JLabel basicAssetInfo;
    JButton goToAssetView;
    JButton back;


    public GUIPortfolioView(GUIMainFrame mainFrame){
        this.mainFrame = mainFrame; //set parent frame holder

        //set up panel
        //setBounds(mainFrame.getBounds());
        setSize(new Dimension(mainFrame.getWidth(), mainFrame.getHeight()-GUIMainFrame.PANEL_OFFSET));
        setLayout(new GridLayout(0,1));
        width=getWidth();
        height=getHeight();
/*
        //TITLE
        title = new JLabel(currentPortfolio.getName());
        title.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        this.add(title);

        //TOTAL VALUE
        totalValue = new JLabel(); //implement the total value
        totalValue.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        totalValue.setHorizontalAlignment(SwingConstants.CENTER);
        totalValue.setVerticalAlignment(SwingConstants.CENTER);
        this.add(totalValue);

        //ASSET THINGS

        assetList = new JComboBox<>(currentPortfolio.getStockNamesArray());
        assetList.addActionListener(this);
        assetList.setActionCommand("selectAsset");
        this.add(assetList);

        basicAssetInfo = new JLabel("Please select and asset"); //
        basicAssetInfo.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        basicAssetInfo.setHorizontalAlignment(SwingConstants.CENTER);
        basicAssetInfo.setVerticalAlignment(SwingConstants.CENTER);
        this.add(basicAssetInfo);

        goToAssetView = new JButton("Please select an asset");
        goToAssetView.addActionListener(this);
        goToAssetView.setActionCommand("toAssetView");
        this.add(goToAssetView);

        //BACK
        back = new JButton("Back to main menu");
        back.addActionListener(this);
        back.setActionCommand("toAssetView");
        this.add(back);
*/

    }

    public static void setCurrentPortfolio(Portfolio p) {
        currentPortfolio = p;
    }
    public void setupComponents(){
        //RESET THE FRAME FIRST
        this.removeAll();

        //TITLE
        title = new JLabel(currentPortfolio.getName());
        title.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        this.add(title);

        //TOTAL VALUE
        totalValue = new JLabel("PLACEHOLDER FOR TOTAL VALUE"); //TODO: implement the total value of a portfolio
        totalValue.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        totalValue.setHorizontalAlignment(SwingConstants.CENTER);
        totalValue.setVerticalAlignment(SwingConstants.CENTER);
        this.add(totalValue);

        //ASSET STUFF
        assetList = new JComboBox<>(currentPortfolio.getStockNamesArray());
        assetList.addActionListener(this);
        assetList.setActionCommand("selectAsset");
        this.add(assetList);

        basicAssetInfo = new JLabel("Please select an asset"); //
        basicAssetInfo.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        basicAssetInfo.setHorizontalAlignment(SwingConstants.CENTER);
        basicAssetInfo.setVerticalAlignment(SwingConstants.CENTER);
        this.add(basicAssetInfo);

        goToAssetView = new JButton("Please select an asset");
        goToAssetView.addActionListener(this);
        goToAssetView.setActionCommand("toAssetView");
        this.add(goToAssetView);

        //BACK
        back = new JButton("Back to main menu");
        back.addActionListener(this);
        back.setActionCommand("toMainMenu");
        this.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "selectAsset" -> {
                basicAssetInfo.setText(currentPortfolio.getStockArray()[assetList.getSelectedIndex()].getName() + " | " + currentPortfolio.getStockArray()[assetList.getSelectedIndex()].getAmount() + " | " + currentPortfolio.getStockArray()[assetList.getSelectedIndex()].getTotalValue());
                goToAssetView.setText(currentPortfolio.getStockArray()[assetList.getSelectedIndex()].getName());
            }
            case "toMainMenu" -> mainFrame.navigate(GUIMainFrame.MAIN_MENU, this);
            case "toAssetView" -> {
                mainFrame.getAssetView().setCurrentStock(currentPortfolio.getStockArray()[assetList.getSelectedIndex()]);
                mainFrame.getAssetView().setupComponents();
                mainFrame.navigate(GUIMainFrame.ASSET_VIEW, this);
            }

        }
    }
}
