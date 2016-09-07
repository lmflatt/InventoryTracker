import java.util.ArrayList;

/**
 * Created by lee on 9/6/16.
 */
public class Item {

    private String name = "";
    private Integer quantity;

    public Item() {
    }

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static ArrayList<Item> addItem(ArrayList<Item> inventory) {
        String itemName = "";
        boolean nameAlreadyExists = true;
        while (nameAlreadyExists) {
            nameAlreadyExists = false;
            System.out.println();
            System.out.println("Please Enter the name of the item.");
            itemName = Validation.validateString();

            for (Item item : inventory) {
                if (itemName.equalsIgnoreCase(item.getName())) {
                    System.out.println("Your inventory already contains " + itemName + ".");
                    nameAlreadyExists = true;
                }
            }
        }

        System.out.println();
        System.out.println("Please Enter the amount you have.");
        Integer itemAmount = Validation.validatePositiveInt();

        Item item = new Item(itemName, itemAmount);
        inventory.add(item);

        return inventory;
    }

    public static Item changeQuantity(Item item) {
        Integer newQuantity = Validation.validatePositiveInt();
        item.setQuantity(newQuantity);
        return item;
    }

    public static Item extractItem(ArrayList<Item> inventory) {
        Item item1 = new Item();

        boolean itemNotValid = true;
        while (itemNotValid) {
            String itemName = Validation.validateString();
            for (Item item : inventory) {
                if (itemName.equalsIgnoreCase(item.getName())){
                    System.out.println("You currently have " + item.getQuantity() + " " + itemName + ".");
                    item1 = item;
                    itemNotValid = false;
                }
            }
            if (item1.getName().equalsIgnoreCase("")) {
                System.out.println("Name did not match any item in your inventory.");
            }
        }

        inventory.remove(item1);
        return item1;
    }
}
