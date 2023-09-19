import java.util.ArrayList;
import java.util.Scanner;

public class Coustomer extends User{    

    private ArrayList<Item> cartList = new ArrayList<>();                                                     
    private ArrayList<Invoice> invoicesList = new ArrayList<>();

    public Coustomer(String userName , String passWord){
        super(userName, passWord);
    }
 
    
/*---this method used to complet pament by take the items from cart and add it in invoice----*/
    public static void buyTheItmes(int userIndex){
        Coustomer coustomer= (Coustomer) User.userList.get(userIndex);
        Invoice invoice = new Invoice();
        
        for (int i = 0; i < coustomer.cartList.size(); i++) {
            invoice.getItemList().add(coustomer.cartList.get(i));
            invoice.setTotlePrice(invoice.getTotlePrice()+coustomer.cartList.get(i).getPrice());
        }
        coustomer.invoicesList.add(invoice);
        coustomer.cartList.clear();
        User.userList.add(userIndex,coustomer);
    }
/*-------------------------------------------------------------------------------------------*/


/*-----------------this method used to add items to coustomer cart-----------------------*/
    public static void addToCart(int itemIndex,int userIndex){
        Coustomer coustomer= (Coustomer) User.userList.get(userIndex);
        coustomer.cartList.add(Item.itemsList.get(itemIndex));
        User.userList.add(userIndex,coustomer);
        coustomer.printCart(userIndex);
    }
/*---------------------------------------------------------------------------------------*/


/*-----------------------this method used to print coustomer carts-----------------------*/
    public static void printCart(int userIndex){
        Coustomer coustomer= (Coustomer) User.userList.get(userIndex);
        System.out.println("|************************************************|");
        System.out.println("|*******************your cart********************|");
        System.out.println("|************************************************|");
        System.out.println("|  (name)              (id)               (price)|");
        for (int i = 0; i < coustomer.cartList.size(); i++) {
            System.out.println("|"+(i+1)+"-"+coustomer.cartList.get(i).getName()+"                 "+
            coustomer.cartList.get(i).getId()+"                 "+coustomer.cartList.get(i).getPrice());
        }
        System.out.println("|************************************************|");
        System.out.println("");
        Menu.coustomerMenu();
    }
/*----------------------------------------------------------------------------------------*/

public ArrayList<Invoice> getInvoicesList() {
    return invoicesList;
}
}

    


