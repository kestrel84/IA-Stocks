import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUICreateUser  extends JPanel implements ActionListener {
    private GUIMainFrame mainFrame;    //parent frame holder
    private final int width, height;   //width and height of the panel for easy acess

    //COMPONENTS
    //----------
    JLabel title;
    JTextField enterNewUsername;
    JTextField enterNewPassword;
    JButton createNewUser;
    JButton backToLogin;



    public GUICreateUser(GUIMainFrame mainFrame){
        this.mainFrame = mainFrame; //set parent frame holder

        //set up panel
        //setBounds(mainFrame.getBounds());
        setSize(new Dimension(mainFrame.getWidth(), mainFrame.getHeight()-GUIMainFrame.PANEL_OFFSET));
        setLayout(new GridLayout(0, 1));
        width=getWidth();
        height=getHeight();

        //COMPONENT SET UP
        //----------------

        //LABELS
        //------
        title = new JLabel("CREATE NEW USER");
        //title.setBounds(0,0,width,height/10);
        title.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        this.add(title);

        //TEXT FIELDS
        //-----------
        enterNewUsername = new JTextField();
        this.add(enterNewUsername);

        enterNewPassword = new JTextField();
        this.add(enterNewPassword);

        //BUTTONS
        //-------
        createNewUser = new JButton("Create New User");
        //toMainMenu.setBounds(0, height/2, width/2, height/2);
        createNewUser.addActionListener(this);
        createNewUser.setActionCommand("mainMenu");
        this.add(createNewUser);

        backToLogin = new JButton("Back to login");
        //back.setBounds(width/2, height/2, width/2, height/2);
        backToLogin.addActionListener(this);
        backToLogin.setActionCommand("loginScreen");
        this.add(backToLogin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "mainMenu":
                if (!enterNewUsername.getText().equals("") || !enterNewPassword.getText().equals("")) {
                    User newUser = new User(enterNewUsername.getText(), enterNewPassword.getText());
                    GUIMainFrame.currentUser = newUser;
                    mainFrame.navigate(GUIMainFrame.MAIN_MENU, this);
                }
                break;
            case "loginScreen":
                mainFrame.navigate(GUIMainFrame.LOGIN_SCREEN, this);
                break;
        }
    }
}
