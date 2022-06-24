import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILoginScreen  extends JPanel implements ActionListener {
    private GUIMainFrame mainFrame;    //parent frame holder
    private final int width, height;   //width and height of the panel for easy acess

    //COMPONENTS
    //----------
    JButton checkLoginDetails;
    JButton toCreateUser;
    JLabel title;
    JTextField enterUname;
    JPasswordField enterPassword;



    public GUILoginScreen(GUIMainFrame mainFrame){
        this.mainFrame = mainFrame; //set parent frame holder

        //set up panel
        //setBounds(mainFrame.getBounds());
        setSize(new Dimension(mainFrame.getWidth(), mainFrame.getHeight()-50));
        setLayout(new GridLayout(0,1));
        width=getWidth();
        height=getHeight();

        //COMPONENT SET UP
        //----------------

        //TITLE
        //-----
        title = new JLabel("LOGIN SCREEN");
        title.setBounds(0,0,width,height/10);
        title.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        this.add(title);

        //JTEXTFIELD
        //---------
        enterUname = new JTextField();
        this.add(enterUname);

        //JPASSWORDFIELD
        //--------------
        enterPassword = new JPasswordField();
        this.add(enterPassword);


        //BUTTONS
        //-------
        checkLoginDetails = new JButton("Login");
        checkLoginDetails.setBounds(0, height/2, width/2, height/2);
        checkLoginDetails.addActionListener(this);
        checkLoginDetails.setActionCommand("mainMenu");
        this.add(checkLoginDetails);

        toCreateUser = new JButton("Create New User");
        toCreateUser.setBounds(width/2, height/2, width/2, height/2);
        toCreateUser.addActionListener(this);
        toCreateUser.setActionCommand("createUser");
        this.add(toCreateUser);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "mainMenu" -> mainFrame.navigate(GUIMainFrame.MAIN_MENU, this);
            case "createUser" -> mainFrame.navigate(GUIMainFrame.CREATE_USER, this);
        }
    }
}
