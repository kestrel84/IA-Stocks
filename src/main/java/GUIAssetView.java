import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIAssetView  extends JPanel implements ActionListener {
    private GUIMainFrame mainFrame;    //parent frame holder
    private final int width, height;   //width and height of the panel for easy access

    //STOCK CURRENTLY BEING VIEWED
    private static Stock currentStock;

    //COMPONENTS
    JLabel title;
    JLabel currentPrice;
    JComboBox<String> portfolioSelector;
    JTextField numberOfAsset;
    JButton addToPortfolio;
    JButton backToMainMenu;



    public GUIAssetView(GUIMainFrame mainFrame){
        this.mainFrame = mainFrame; //set parent frame holder

        //set up panel
        //setBounds(mainFrame.getBounds());
        setSize(new Dimension(mainFrame.getWidth(), mainFrame.getHeight()-GUIMainFrame.PANEL_OFFSET));
        setLayout(new GridLayout(0,1));
        width=getWidth();
        height=getHeight();
    }

    public void setCurrentStock(Stock s){
        currentStock = s;
    }
    public void setupComponents(){
        //RESET FRAME
        this.removeAll();

        //TITLE
        title = new JLabel(currentStock.getName());
        title.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        this.add(title);

        //TITLE
        currentPrice = new JLabel("Current Value: " + currentStock.getPrice());
        currentPrice.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        currentPrice.setHorizontalAlignment(SwingConstants.CENTER);
        currentPrice.setVerticalAlignment(SwingConstants.CENTER);
        this.add(currentPrice);

        //PORTFOLIO SELECTOR
        ArrayList<Portfolio> portfolios = GUIMainFrame.currentUser.getAllPortfolios(); //get portfolios
        String[] portfolioNames = new String[portfolios.size()]; //convert portfolios into names
        for (int i = 0; i < portfolioNames.length; i++) {
            portfolioNames[i] = portfolios.get(i).getName();
        }
        portfolioSelector = new JComboBox<>(portfolioNames);
        portfolioSelector.addActionListener(this);
        portfolioSelector.setActionCommand("selectPortfolio");
        this.add(portfolioSelector);

        numberOfAsset = new JTextField("Enter number of assets to add");
        this.add(numberOfAsset);

        addToPortfolio = new JButton("Please select a portfolio");
        addToPortfolio.addActionListener(this);
        addToPortfolio.setActionCommand("addToPortfolio");
        this.add(addToPortfolio);

        //BACK TO MAIN MENU
        backToMainMenu = new JButton("Back to main menu");
        backToMainMenu.addActionListener(this);
        backToMainMenu.setActionCommand("mainMenu");
        this.add(backToMainMenu);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "selectPortfolio" -> addToPortfolio.setText((String)portfolioSelector.getSelectedItem());
            case "addToPortfolio" -> {
                if (numberOfAsset.getText().matches("[0-9]+")) {
                    currentStock.setAmount(Integer.parseInt(numberOfAsset.getText()));
                    GUIMainFrame.currentUser.getAllPortfolios().get(portfolioSelector.getSelectedIndex()).addStock(currentStock);
                } else {
                    System.out.println("not a number");
                }
            }
            case "mainMenu" -> mainFrame.navigate(GUIMainFrame.MAIN_MENU, this);
        }
    }
}
