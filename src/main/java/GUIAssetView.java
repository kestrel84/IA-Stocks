import javax.swing.*;
import java.awt.*;

public class GUIAssetView  extends JPanel {
    private GUIMainFrame mainFrame;    //parent frame holder
    private final int width, height;   //width and height of the panel for easy access

    //STOCK CURRENTLY BEING VIEWED
    private static Stock currentStock;

    //COMPONENTS
    JLabel title;
    JLabel currentPrice;
    JComboBox<String> portfolioSelector;
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

        //
    }


}
