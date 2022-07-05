import java.util.ArrayList;

public class User {
    private final int userID; //unique user ID for each user
    private ArrayList<Portfolio> portfolios;
    private String username;
    private String password;
    private int numberOfPortfolios;

    //CONSTANTS
    private static final int USER_FILE_FORMAT_LENGTH = 100;
    private static final String usersFilePath = GUIMainFrame.generalFilePath + "users.txt";

    //CONSTRUCTORS
    public User(String username, String password){
        this.username = username;
        this.password = password;
        numberOfPortfolios = 0;
        Database userDatabase = new Database(usersFilePath, USER_FILE_FORMAT_LENGTH);
        userID = userDatabase.getSize();
        userDatabase.appendRecord(this.toFileFormat());
        portfolios = getAllPortfolios();

    }
    public User(String fileFormat){
        userID = Integer.parseInt(fileFormat.substring(0, (USER_FILE_FORMAT_LENGTH /4)).trim());
        username = fileFormat.substring(USER_FILE_FORMAT_LENGTH /4, (USER_FILE_FORMAT_LENGTH /2)).trim();
        password = fileFormat.substring((USER_FILE_FORMAT_LENGTH /2), 3*(USER_FILE_FORMAT_LENGTH /4)).trim();
        numberOfPortfolios = Integer.parseInt(fileFormat.substring(3*(USER_FILE_FORMAT_LENGTH /4), USER_FILE_FORMAT_LENGTH).trim());

        portfolios = getAllPortfolios();
    }

    //STATIC METHODS
    public static ArrayList<User> getAllUsersFromFile(){
        Database userDatabase = new Database(usersFilePath, USER_FILE_FORMAT_LENGTH);
        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < userDatabase.getSize(); i++) {
            users.add(new User(userDatabase.getRecordAt(i)));
        }
        return users;
    }


    //OBJECT METHODS
    public void addNewPortfolio(String portfolioName){
        //creates a new portfolio

        portfolios.add(new Portfolio(GUIMainFrame.generalFilePath + userID + portfolioName + numberOfPortfolios + ".txt"));
        numberOfPortfolios++;

        Database userDatabase = new Database(usersFilePath, USER_FILE_FORMAT_LENGTH);
        userDatabase.setRecordAt(userID, toFileFormat());



        //how portfolio files are going to work - [userid]Portfolio[number]
        //userid is userid
        //portfolio number is for how many portfolios the user has (e.g. portfolio1 (or zero, undecided yet) is the first, portfolio2 is the second)
    }
    public ArrayList<Portfolio> getAllPortfolios(){
        //gets all the portfolios for a specific userID

        //TODO: TEST THIS
        ArrayList<Portfolio> portfolios = new ArrayList<>();
        for (int i = 0; i < numberOfPortfolios; i++) {
            portfolios.add(new Portfolio(GUIMainFrame.generalFilePath + userID + "Portfolio" + i + ".txt"));
        }
        return portfolios;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String toFileFormat(){
        return (String.format("%-25s", userID) + String.format("%-25s", username) + String.format("%-25s", password) + String.format("%-25s", numberOfPortfolios));
    }
}
