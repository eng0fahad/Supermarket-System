import java.util.ArrayList;

public class User {

    private String userName ;
    private String passWord ;
    protected static int userIndex ;
    protected static ArrayList<User> userList = new ArrayList<>();

    public User(String userName ,String passWord){
        this.passWord = passWord;
        this.userName = userName;
    }
    
/*----------------------this method used to register the new users------------------------*/
    public static void register(Coustomer c){
        if(isRegistered(c)){
            System.out.println("you are already registered");
            System.out.println();
        }else{
        userList.add(c);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println("register successful");
    }}
/*----------------------------------------------------------------------------------------*/

/*-------------------this method used to check if the user registered---------------------*/
    private static boolean isRegistered(User user){

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).passWord.equals(user.passWord)&&userList.get(i).userName.equals(user.userName)) {
                return true;
            }
        }
        return false; 
    }
/*----------------------------------------------------------------------------------------*/

/*-----------this method used to login users by using linyar search in userLis------------*/
    public static void login(User user){

        if (isRegistered(user)) {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).passWord.equals(user.passWord)&&userList.get(i).userName.equals(user.userName)) {
                    if (userList.get(i).getClass()==new Admin("","").getClass()) {
                        userIndex = i ;
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        Menu.adminMenu();
                    }else if (userList.get(i).getClass()==new Coustomer("","").getClass()){
                        userIndex = i ;
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        Menu.coustomerMenu();
                    }
                }}
        }else{
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("you have to register");
            Menu.mainMenu();

        }
    }
/*----------------------------------------------------------------------------------------*/

}