import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUICreateUser  extends JPanel implements ActionListener {
    private GUIMainFrame mainFrame;    //parent frame holder
    private final int width, height;   //width and height of the panel for easy acess

    //COMPONENTS
    //----------
    JButton toMainMenu;
    JButton back;
    JLabel title;


    public GUICreateUser(GUIMainFrame mainFrame){
        this.mainFrame = mainFrame; //set parent frame holder

        //set up panel
        setBounds(mainFrame.getBounds());
        setLayout(null);
        width=getWidth();
        height=getHeight();

        //set up components
        title = new JLabel("CREATE USER");
        title.setBounds(0,0,width,height/4);
        title.setFont(new Font("Sans Serif", Font.PLAIN, 100));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        this.add(title);

        toMainMenu = new JButton("Main Menu");
        toMainMenu.setBounds(0, height/2, width, height/2);
        toMainMenu.addActionListener(this);
        toMainMenu.setActionCommand("mainMenu");
        this.add(toMainMenu);

        back = new JButton("Back to login");
        back.setBounds(0, height/2, width, height/2);
        back.addActionListener(this);
        back.setActionCommand("loginScreen");
        this.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "mainMenu":
                mainFrame.navigate(GUIMainFrame.MAIN_MENU, this);
                break;
            case "loginScreen":
                mainFrame.navigate(GUIMainFrame.LOGIN_SCREEN, this);
                break;
        }
    }
}
