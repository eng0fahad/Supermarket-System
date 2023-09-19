import java.util.ArrayList;

public class Invoice {
    
    private double totlePrice =0;
    private ArrayList<Item> itemList = new ArrayList<>();

/*---------this method used to print all invoice that coustomer has-------------*/
     public static void printInvoice(int userIndex){
        Coustomer coustomer= (Coustomer) User.userList.get(userIndex);
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        for (int i = 0; i < coustomer.getInvoicesList().size(); i++) {

            System.out.println("|************************************************|");
            System.out.println("                  invoice "+(i+1));
            System.out.println("|************************************************|");
            System.out.println("|  (name)              (id)               (price)|");
             for (int j = 0; j < coustomer.getInvoicesList().get(i).itemList.size(); j++) {
                 System.out.println("|"+(j+1)+"-"+coustomer.getInvoicesList().get(i).itemList.get(j).getName() +"                 "+
                 coustomer.getInvoicesList().get(i).itemList.get(j).getId()
                 +"                 "+coustomer.getInvoicesList().get(i).itemList.get(j).getPrice());
             }
            System.out.println("    totel : "+coustomer.getInvoicesList().get(i).totlePrice);
            System.out.println("|************************************************|");
            System.out.println("");
            System.out.println("");
        }
    }
/*------------------------------------------------------------------------------*/

public double getTotlePrice() {
    return totlePrice;
}

public void setTotlePrice(double totlePrice) {
    this.totlePrice = totlePrice;
}
   
public ArrayList<Item> getItemList() {
    return itemList;
}

}
    
    


