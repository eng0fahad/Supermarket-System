import java.util.Scanner;

public class Menu {

    private static boolean complet;
    private static int chose ;
    private static Scanner input = new Scanner(System.in);



    public static void mainMenu(){
        complet = false ;
        do{
        System.out.println("|*********************************|");
        System.out.println("|************Main Menu************|");
        System.out.println("|*********************************|");
        System.out.println("|1-login                          |");
        System.out.println("|2-register as coustomer          |");
        System.out.println("|3-exit                           |");
        System.out.println("|*********************************|");

         chose = input.nextInt();

        switch (chose){

            case 1 :
            System.out.println("enter username :"); 
            String u = input.next();
            System.out.println("enter password :");
            String p = input.next();
            User.login(new User(u, p));
            break ;

            case 2 :
            System.out.println("enter new username :"); 
            u = input.next();
            System.out.println("enter new password :");
            p = input.next();
            User.register(new Coustomer(u, p));
            Menu.mainMenu();
            break ;

            case 3 :
             System.out.print("\033[H\033[2J");  
             System.out.flush(); 
             System.out.println("thank you for using system"); 
             complet = false ;
             System.exit(0); 
            break ;
            
        }
        if (chose < 1 || chose > 3) {
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
            System.out.println("unvalid input !!!!!!");
            complet = true ;   
        }
        }while(complet);
    }


    public static void coustomerMenu(){

        complet = false;
        do{
        System.out.println("|*********************************|");
        System.out.println("|*********Coustomer Menu**********|");
        System.out.println("|*********************************|");
        System.out.println("|1-add item to cart               |");
        System.out.println("|2-see cart                       |");
        System.out.println("|3-buy the items                  |");
        System.out.println("|4-main menu                      |");
        System.out.println("|5-exit                           |");
        System.out.println("|*********************************|");

         chose = input.nextInt();

        switch (chose){
            
            case 1 :  
            Item.printItems();
            System.out.println("select item to add it in your cart");
            int itemIndex = input.nextInt();
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
            Coustomer.addToCart(itemIndex-1, User.userIndex);
            coustomerMenu();
            break ;

            case 2 : 
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
            Coustomer.printCart(User.userIndex);
            coustomerMenu();
            break ;

            case 3:
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
            Coustomer.buyTheItmes(User.userIndex);
            Invoice.printInvoice(User.userIndex);
            break ;

            case 4 :
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
            Menu.mainMenu();
            break ;

            case 5 : 
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
            System.out.println("thank you for using system");
            complet = false ;
            System.exit(0); 
            break ;
            
        }
        if (chose < 1 || chose > 5) {
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
            System.out.println("unvalid input !!!!!!");
            complet = true ;   
        }
        }while(complet);
    }       

    
    public static void adminMenu(){
        complet = false ;
        do{  
        System.out.println("|*********************************|");
        System.out.println("|***********Admin Menu************|");
        System.out.println("|*********************************|");
        System.out.println("|1-add item                       |");
        System.out.println("|2-remove item                    |");
        System.out.println("|3-see items                      |");
        System.out.println("|4-main menu                      |");
        System.out.println("|5-exit                           |");
        System.out.println("|*********************************|");

         chose = input.nextInt();

        switch (chose){

            case 1 :
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            Item.printItems();
            System.out.println("enter item neme :");
            String itemName = input.next(); 
            System.out.println("enter item price :");
            Double itemPrice = input.nextDouble(); 
            Item.addNewItem(itemName,itemPrice);
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            Menu.adminMenu();
            break ;

            case 2 :
            try{
                Item.printItems();
                System.out.println("enter item index :");
                int itemIndex = input.nextInt();
                Item.removeItem(itemIndex-1);
                Item.printItems();
                Menu.adminMenu();
            }catch(Exception exception){
                Item.printItems();
                System.out.println("unvalid input !!!!!!");
                System.out.println("enter item index :");
                int itemIndex = input.nextInt();
                Item.removeItem(itemIndex-1);
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                Menu.adminMenu();
            }
            break ;
        

            case 3 : 
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            Item.printItems();
            adminMenu();
            break ;

            case 4 :
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            Menu.mainMenu();
            break ;

            case 5 :
             System.out.print("\033[H\033[2J");  
             System.out.flush(); 
             System.out.println("thank you for using system");
             System.exit(0); 
             complet = false ;
            break ;
            
        }
        if (chose < 1 || chose > 5) {
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
            System.out.println("unvalid input !!!!!!");
            complet = true ;
        }
        }while(complet);
    }

}
