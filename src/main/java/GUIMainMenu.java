import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIMainMenu  extends JPanel implements ActionListener {
    private GUIMainFrame mainFrame;    //parent frame holder
    private final int width, height;   //width and height of the panel for easy access

    //COMPONENTS
    //----------
    private JLabel title;
    private JButton toAssetSearch;
    private JButton newPortfolio;
    private JButton toSelectedPortfolio;
    private JComboBox<String> portfolioSelector;

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

        /*
        ArrayList<Portfolio> portfolios = GUIMainFrame.currentUser.getAllPortfolios(); //get portfolios
        String[] portfolioNames = new String[portfolios.size()]; //convert portfolios into names
        for (int i = 0; i < portfolioNames.length; i++) {
            portfolioNames[i] = portfolios.get(i).getName();
        }
        portfolioSelector = new JComboBox<>(portfolioNames);
        portfolioSelector.addActionListener(this);
        portfolioSelector.setActionCommand("selectPortfolio");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.5;
        c.weighty = 0.5;
        this.add(portfolioSelector, c);
*/


        toSelectedPortfolio = new JButton("Please Select A Portfolio");
        toSelectedPortfolio.addActionListener(this);
        toSelectedPortfolio.setActionCommand("toSelectedPortfolio");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 0.5;
        c.weighty = 0.5;
        this.add(toSelectedPortfolio, c);


    }

    public void setSelectablePortfolios(){
        ArrayList<Portfolio> portfolios = GUIMainFrame.currentUser.getAllPortfolios(); //get portfolios
        String[] portfolioNames = new String[portfolios.size()]; //convert portfolios into names
        for (int i = 0; i < portfolioNames.length; i++) {
            portfolioNames[i] = portfolios.get(i).getName();
        }
        portfolioSelector = new JComboBox<>(portfolioNames);
        portfolioSelector.addActionListener(this);
        portfolioSelector.setActionCommand("selectPortfolio");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.5;
        c.weighty = 0.5;
        this.add(portfolioSelector, c);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "assetSearch" -> {
                //TODO: implement the entirety of asset search
            }
            case "newPortfolio" -> {
                //TODO: implement jdialogue or similar for entering name
                GUIMainFrame.currentUser.addNewPortfolio("Portfolio");
            }
            case "selectPortfolio" -> {
                toSelectedPortfolio.setText((String)portfolioSelector.getSelectedItem());
            }
            case "toSelectedPortfolio" -> {
                GUIPortfolioView.setCurrentPortfolio(GUIMainFrame.currentUser.getAllPortfolios().get(portfolioSelector.getSelectedIndex()));
                mainFrame.getPortfolioView().setupComponents();
                mainFrame.navigate(GUIMainFrame.PORTFOLIO_VIEW, this);
            }
        }
    }
}
