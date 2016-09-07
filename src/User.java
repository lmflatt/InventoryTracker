import java.util.ArrayList;

/**
 * Created by lee on 9/6/16.
 */
public class User {

    private static final String DEFAULT_NAME = "unlisted";
    private String name = DEFAULT_NAME;
    private String password;
    private ArrayList<Item> inventory = new ArrayList<>();

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public static User searchUser(String name) {
        User user1 = new User();
        for (User user : Main.users) {
            if (name.equalsIgnoreCase(user.getName())){
                System.out.println("Welcome " + name + "!");
                user1 = user;
                break;
            }
        }
        return user1;
    }

    public static User createUser(String name) {
        System.out.println("Please Enter a password for your account");
        String password = Validation.validateString();

        User user = new User(name, password);
        System.out.println("Thank you. You will now be asked to being login with your name and password again.");
        return user;
    }

    public static ArrayList<Item> retrieveUser(User user) {
        boolean passwordIncorrect = true;
        String password = new String();
        while(passwordIncorrect) {
            System.out.println("Please Enter your password.");
            password = Validation.validateString();

            if (password.equalsIgnoreCase(user.password)){
                System.out.println();
                System.out.println("Accepted. You may now access your personal inventory:");
                passwordIncorrect = false;
            }
            else {
                System.out.println();
                System.out.println("Password Incorrect.");
            }
        }
        return user.getInventory();
    }
}
