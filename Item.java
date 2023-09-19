import java.util.ArrayList;

public class Item {

    private String name ; 
    private  int id; 
    private  double price ;
    private static int counter ;
    protected static ArrayList<Item> itemsList = new ArrayList<>();


    public Item (String name , double price){
        this.name = name ;
        this.price = price ;
        counter++;
        id = counter+1;
    }

/*---------------this method used to print all items in the super market------------------*/
    public static void printItems(){
        if(itemsList.isEmpty()){
            System.out.println("null add some items");
        }else{
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("|************************************************|");
        System.out.println("|******************items list********************|");
        System.out.println("|************************************************|");
        System.out.println("|  (name)             (price)              (id)  |");
        for (int i = 0; i < itemsList.size() ; i++) {
            System.out.println("| "+(i+1)+"- "+itemsList.get(i).getName()+"              "+
             itemsList.get(i).price+"                 "+itemsList.get(i).id);
        }
        System.out.println("|************************************************|");
        System.out.println("");

    }}
/*----------------------------------------------------------------------------------------*/

/*------this method used for remove new itme to itemsList in Itme class-------*/
public static void removeItem(int index){
    Item.itemsList.remove(index);
}
/*----------------------------------------------------------------------------*/

/*-------this method used for add new itme to itemsList in Itme class---------*/
public static void addNewItem(String itemName , Double itmePrice){
    if(!itemName.equals("")&&itmePrice > 0)
    Item.itemsList.add(new Item(itemName, itmePrice));
}
/*----------------------------------------------------------------------------*/


public String getName() {
    return name;
}

public int getId() {
    return id;
}

public double getPrice() {
    return price;
}
}
