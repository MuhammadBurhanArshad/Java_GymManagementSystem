import java.util.Scanner;

public class start {
    void start(){
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("_WELCOME TO GYM MANAGEMENT SYSTEM_");
        System.out.println("-------LOGIN AS ADMIN-------------");
        System.out.println("-------LOGIN AS USER--------------");
        System.out.println("PLEASE ENTER YOUR CHOICE(press 6 to exit)");
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        if(n==1){
            Login l= new Login();
            l.login();
        }
        else if(n==2){
            Login l= new Login();
            l.user_login();
        }else if (n==6){

        }else {
            System.out.println("Wrong choice");
            start();
        }
    }
}
