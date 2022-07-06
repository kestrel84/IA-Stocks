public class Main {

    public static void main(String[] args) {
        //TODO: all the other panels
        //TODO: URGENT: IMPLEMENT PORTFOLIO VIEW
        AlphaVantageWrapper.initialiseApi();
        GUIMainFrame m = new GUIMainFrame("\\\\bex-file-01\\studenthome$\\16\\16Ashton_M\\CSH IB\\IA-Stonks\\");
        m.setVisible(true);
    }
}
