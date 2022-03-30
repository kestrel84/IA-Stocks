public class User {
    private static int maxUserID = 0;
    private final int userID; //unique user ID for each user
    private Portfolio[] portfolios;
    private Login login;

    public User(String username, String password, int maxPortfolios){
        login = new Login(username, password);
        userID = maxUserID;
        maxUserID++;
        portfolios = new Portfolio[maxPortfolios];
    }


}
