import javax.sound.sampled.Port;
import java.util.ArrayList;

public class User {
    private final int userID; //unique user ID for each user
    private ArrayList<Portfolio> portfolios;
    private String username;
    private String password;
    private int numberOfPortfolios;

    //CONSTANTS
    private static final int FILE_FORMAT_LENGTH = 100;
    private static final String usersFilePath = GUIMainFrame.generalFilePath + "users.txt";


    //this may be useless
    public User(String username, String password){
        this.username = username;
        this.password = password;
        numberOfPortfolios = 0;
        portfolios = new ArrayList<>();        //TODO: POPULATE THIS ARRAY WITH ALL OF THE USER'S PORTFOLIO TEXT FILES
        Database userDatabase = new Database(usersFilePath, FILE_FORMAT_LENGTH);
        userID = userDatabase.getSize();
        userDatabase.appendRecord(this.userToFileFormat());
    }

    public static ArrayList<User> getAllUsersFromFile(){
        Database userDatabase = new Database(usersFilePath, FILE_FORMAT_LENGTH);
        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < userDatabase.getSize(); i++) {
            users.add(new User(userDatabase.getRecordAt(i)));
        }
        return users;
    }

    public User(String fileFormat){
        userID = Integer.parseInt(fileFormat.substring(0, (FILE_FORMAT_LENGTH/4)).trim());
        username = fileFormat.substring(FILE_FORMAT_LENGTH/4, (FILE_FORMAT_LENGTH/2)).trim();
        password = fileFormat.substring((FILE_FORMAT_LENGTH/2), 3*(FILE_FORMAT_LENGTH/4)).trim();
        numberOfPortfolios = Integer.parseInt(fileFormat.substring(3*(FILE_FORMAT_LENGTH/4), FILE_FORMAT_LENGTH).trim());

        portfolios = new ArrayList<>();        //TODO: POPULATE THIS ARRAY WITH ALL OF THE USER'S PORTFOLIO TEXT FILES
    }

    public String userToFileFormat(){
        return (String.format("%-25s", userID) + String.format("%-25s", username) + String.format("%-25s", password) + String.format("%-25s", numberOfPortfolios));
    }

    public void addNewPortfolio(){
        //TODO: Create a new portfolio


        //how portfolio files are going to work - [userid]Portfolio[number]
        //userid is userid
        //portfolio number is for how many portfolios the user has (e.g. portfolio1 (or zero, undecided yet) is the first, portfolio2 is the second)
    }

    public ArrayList<Portfolio> getAllPortfolios(){
        //TODO: implement get all portfolios for a specific user
        return null;
    }



    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }


}
