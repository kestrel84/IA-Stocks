public class Main {

    public static void main(String[] args) {
        //TODO: UI!!!!!!!!!!!!!!!
        //TODO: frame holder Jframe
        //TODO: main menu panel
        //TODO: all the other panels

        AlphaVantageWrapper.initialiseApi();

        //Portfolio portfolio = new Portfolio("\\\\bex-file-01\\studenthome$\\16\\16Ashton_M\\CSH IB\\IA-Stonks\\Portfolio1.txt");
        //System.out.println(portfolio.getStockStringAt(1));

        GUIMainFrame m = new GUIMainFrame();
        m.setVisible(true);
    }
}
