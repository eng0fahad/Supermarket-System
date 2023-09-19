public class Main {
    public static void main(String[] args) {


/*------------------some data gast to test the system------------------------*/
        User.userList.add(new Admin("a","1"));
        User.userList.add(new Coustomer("c","1"));

        Item.addNewItem("apple", 0.3);
        Item.addNewItem("milk ", 9.0);
        Item.addNewItem("bread", 1.0);
        Item.addNewItem("oring", 0.5);
        Item.addNewItem("water", 0.5);
        Item.addNewItem("Chips", 3.0);
/*----------------------------------------------------------------------------*/



        Menu.mainMenu();
    }
}
