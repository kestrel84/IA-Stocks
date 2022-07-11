import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAssetSearch  extends JPanel implements ActionListener {
    private GUIMainFrame mainFrame;    //parent frame holder
    private final int width, height;   //width and height of the panel for easy acess

    //COMPONENTS
    private JLabel title;
    private JComboBox<String> assetSelector;
    private JLabel assetInfo;
    private JButton toAssetView;
    private JButton backToMainMenu;

    //STOCK LIST
    private static final String[] allStockNames = new String[]{
                    "Admiral Group",
                    "Anglo American",
                    "Antofagasta Holdings",
                    "Ashtead Group",
                    "Associated British Foods",
                    "AstraZeneca",
                    "Auto Trader Group",
                    "AVEVA Group",
                    "Aviva",
                    "BAE Systems",
                    "Barclays",
                    "Barratt Developments",
                    "Berkeley Group Holdings",
                    "BHP Group",
                    "BP",
                    "British American Tobacco",
                    "British Land Co",
                    "BT Group",
                    "Bunzl",
                    "Burberry Group",
                    "Carnival",
                    "Centrica",
                    "Coca-Cola HBC AG",
                    "Compass Group",
                    "CRH",
                    "Croda International",
                    "DCC",
                    "Diageo",
                    "Evraz",
                    "Experian",
                    "Ferguson",
                    "Flutter Entertainment",
                    "Fresnillo",
                    "GlaxoSmithKline",
                    "Glencore",
                    "Halma",
                    "Hargreaves Lansdown",
                    "Hikma Pharmaceuticals",
                    "Hiscox Ltd",
                    "HSBC Holdings",
                    "Imperial Brands Group",
                    "Informa",
                    "InterContinental Hotels Group",
                    "International Consolidated Airlines Group SA",
                    "Intertek Group",
                    "ITV",
                    "JD Sports Fashion",
                    "Johnson Matthey",
                    "Kingfisher",
                    "Land Securities Group",
                    "Legal & General Group",
                    "Lloyds Banking Group",
                    "London Stock Exchange Group ",
                    "M&G",
                    "Meggitt",
                    "Melrose Industries",
                    "Mondi",
                    "Morrison (Wm) Supermarkets",
                    "National Grid",
                    "Next",
                    "NMC Health",
                    "Ocado Group",
                    "Pearson",
                    "Persimmon",
                    "Phoenix Group Holdings",
                    "Polymetal International",
                    "Prudential",
                    "Reckitt Benckiser Group",
                    "RELX",
                    "Rentokil Initia",
                    "Rightmove",
                    "Rio Tinto",
                    "Rolls Royce Holdings",
                    "Royal Bank of Scotland Group",
                    "Royal Dutch Shell Plc A Shares",
                    "Royal Dutch Shell Plc B Shares",
                    "RSA Insurance Group",
                    "Sage Group",
                    "Sainsbury (J)",
                    "Schroders",
                    "Scottish Mortgage Investment Trust",
                    "Segro",
                    "Severn Trent",
                    "Smith & Nephew",
                    "Smith (DS)",
                    "Smiths Group",
                    "Smurfit Kappa Group",
                    "Spirax-Sarco Engineering",
                    "SSE",
                    "St James's Place",
                    "tStandard Chartered",
                    "Standard Life Aberdeen",
                    "Taylor Wimpey",
                    "Tesco",
                    "TUI AG",
                    "Unilever",
                    "United Utilities Group",
                    "Vodafone Group",
                    "Whitbread",
                    "WPP",
    };
    private static final String[] allStockSymbols = new String[]{
            "ADM",
            "AAL",
            "ANTO",
            "AHT",
            "ABF",
            "AZN",
            "AUTO",
            "AVV",
            "AV.",
            "BA.",
            "BARC",
            "BDEV",
            "BKG",
            "BHP",
            "BP.",
            "BATS",
            "BLND",
            "BT.A",
            "BNZL",
            "BRBY",
            "CCL",
            "CNA",
            "CCH",
            "CPG",
            "CRH",
            "CRDA",
            "DCC",
            "DGE",
            "EVR",
            "EXPN",
            "FERG",
            "FLTR",
            "FRES",
            "GSK",
            "GLEN",
            "HLMA",
            "HL.",
            "HIK",
            "HSX",
            "HSBA",
            "IMB",
            "INF",
            "IHG",
            "IAG",
            "ITRK",
            "ITV",
            "JD.",
            "JMAT",
            "KGF",
            "LAND",
            "LGEN",
            "LLOY",
            "LSE",
            "MNG",
            "MGGT",
            "MRO",
            "MNDI",
            "MRW",
            "NG.",
            "NXT",
            "NMC",
            "OCDO",
            "PSON",
            "PSN",
            "PHNX",
            "POLY",
            "PRU",
            "RB.",
            "REL",
            "RTO",
            "RMV",
            "RIO",
            "RR.",
            "RBS",
            "RDSa",
            "RDSb",
            "RSA",
            "SGE",
            "SBRY",
            "SDR",
            "SMT",
            "SGRO",
            "SVT",
            "SN.",
            "SMDS",
            "SMIN",
            "SKG",
            "SPX",
            "SSE",
            "STJ",
            "STAN",
            "SLA",
            "TW.",
            "TSCO",
            "TUI",
            "ULVR",
            "UU.",
            "VOD",
            "WTB",
            "WPP"
    };



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

        assetSelector = new JComboBox<>(allStockNames);
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
            case "assetView" -> {
                mainFrame.getAssetView().setCurrentStock(new Stock(1, 0.0, allStockSymbols[assetSelector.getSelectedIndex()], allStockNames[assetSelector.getSelectedIndex()] ));
                mainFrame.getAssetView().setupComponents();
                mainFrame.navigate(GUIMainFrame.ASSET_VIEW, this);
            }
            case "selectAsset" -> {
                toAssetView.setText(allStockNames[assetSelector.getSelectedIndex()]);
            }
        }
    }
}
