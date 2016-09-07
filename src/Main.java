import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<User> users = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            User user = new User();
            ArrayList<Item> inventory = new ArrayList<>();

            //// Check if user is known, and create if user is unknown (user.name == "undefined") with default name value.
            boolean userUnknown = true;
            while (userUnknown){
                System.out.println("Welcome! Please enter your name.");
                String name = Validation.validateString();
                user = User.searchUser(name);

                if (user.getName() == "unlisted") {
                    user = User.createUser(name);
                    users.add(user);
                }
                else {
                    userUnknown = false;
                }
            }
            //// Get user's custom inventory by authenticating their password.
            inventory = User.retrieveUser(user);

            //// Keep users in the action loop of managing their inventory until they decide to "log out"
            boolean loggedIn = true;
            while (loggedIn){
                System.out.println();
                System.out.println("Please Enter:");
                System.out.println("[1] to Display your Items");
                System.out.println("[2] to Add an Item");
                System.out.println("[3] to Change an Item's Quantity");
                System.out.println("[4] to Remove an Item");
                System.out.println("[5] to Log Out");

                String userChoice = "";
                userChoice = scanner.nextLine();
                System.out.println();

                switch (userChoice) {
                    case "1":
                        /// display
                        if (user.getInventory().size() > 0) {
                            System.out.println("You have:");
                            for (Item item1 : inventory) {
                                System.out.println("[" + item1.getQuantity() + "] " + item1.getName());
                            }
                        }
                        else {
                            System.out.println();
                            System.out.println("Your inventory is currently empty. Please add some items.");
                        }
                        break;
                    case "2":
                        /// add
                        inventory = Item.addItem(inventory);
                        user.setInventory(inventory);
                        break;
                    case "3":
                        /// change quantity
                        if (inventory.size() > 0) {
                            System.out.println();
                            System.out.println("Please Enter the name of the item you would like to change.");
                            Item item3 = Item.extractItem(inventory);

                            System.out.println();
                            System.out.println("Please Enter a new quantity for this item.");
                            item3 = Item.changeQuantity(item3);
                            inventory.add(item3);
                            user.setInventory(inventory);
                        }
                        else {
                            System.out.println();
                            System.out.println("You currently have no Items in your inventory. Please add some first.");
                        }
                        break;
                    case "4":
                        /// remove
                        if (inventory.size() > 0) {
                            System.out.println();
                            System.out.println("Please Enter the name of the item you would like to remove.");
                            Item item4 = Item.extractItem(inventory);
                            inventory.remove(item4);
                            user.setInventory(inventory);
                            System.out.println();
                            System.out.println("Item Removed.");
                        }
                        else {
                            System.out.println();
                            System.out.println("You currently have no Items in your inventory. Please add some first.");
                        }
                        break;
                    case "5":
                        /// logout
                        loggedIn = false;
                        break;
                    default:
                        System.out.println();
                        System.out.println("Invalid Input. You must Enter 1, 2, 3, 4, or 5.");
                }

            }
        }
    }
}
