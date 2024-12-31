import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    static Scanner s = new Scanner(System.in);
    static String name;
    public static void login(){
        System.out.println("Please Enter username and password");
        name=s.nextLine();
        String password=s.nextLine();
        if((name.equalsIgnoreCase("admin")) && (password.equalsIgnoreCase("abc.123"))){
            System.out.println("LOGIN SUCCESSFULLY");
            Admin a= new Admin();
            a.menu();
        }
        else{
            System.out.println("WRONG USERNAME AND PASSWORD");
            login();
        }

    }

    private static boolean user_search(ArrayList<String> arrayList, String name) {
        String line;
        boolean found=false;
        try {

            BufferedReader read=new BufferedReader(new FileReader("Members data.txt"));
            while ((line=read.readLine())!=null){
                if(line.contains(name)){
                    found=true;
                }else {
                    arrayList.add(line);
                }

            }

        }catch (Exception e){
        }
        return found;
    }

    public void user_login(){
        System.out.println("Please Enter username and password");
        ArrayList<String> arrayList=new ArrayList<String>();
        name=s.nextLine();
        String password=s.nextLine();
        boolean result=user_search(arrayList,name);
        if ((result==true) && (password.equalsIgnoreCase("abc.123"))){
            System.out.println("LOGIN SUCCESSFULLY");
            User u=new User();
            u.display();
        }else{
            System.out.println("WRONG USERNAME AND PASSWORD");
            user_login();
        }
    }



}
