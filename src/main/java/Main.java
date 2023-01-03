public class Main {

    public static void main(String[] args) {
        AlphaVantageWrapper.initialiseApi();
        GUIMainFrame m = new GUIMainFrame("");
        //GUIMainFrame m = new GUIMainFrame("/Users/maxashton/Desktop/IA-Stonks/");

        //GUIMainFrame m = new GUIMainFrame("C:\\Users\\maxha\\Documents\\GitHub\\IA-Stonks\\");
        m.setVisible(true);



    }
}
