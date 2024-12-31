import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class User {

    public void menu(){
    String packages[]={"Access to Cardio Section,\nAccess to Selectorized Training Section,\nAccess to Free Weights Section,\nAccess to Functional Fit Area,\nAccess to Studio (except for classes"};
        System.out.println(Arrays.toString(packages));
        display();
    }

    public void display(){
        System.out.println("*-*-*-*-*-SHOW PACKAGES*-*-*-*-*-");
        System.out.println("*-*-*-*-*- MARK ATTENDENCE*-*-*-*-*-");
        System.out.println("*-*-*-*-*- DISPLAY ATTENDENCE RECORDS*-*-*-*-*-");
        System.out.println("ENTER YOUR CHOICE(press 6 to go back)");
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        if(n==1){
            menu();
        }
        else if(n==2){
            attendencesheet();
        }
        else if(n==3){
            showattendence();
        }else if (n==6){
            start st=new start();
            st.start();
        }else {
            System.out.println("Wrong choice");
            display();
        }
    }
    public void attendencesheet(){
        System.out.println("MARK YOUR ATTENDENCE");
        File file=new File("attendence.txt");
        try {
            file.createNewFile();
            FileWriter writer=new FileWriter("attendence.txt",true);
            System.out.println("ENTER NAME\n");
            Scanner s1=new Scanner(System.in);
            String name=s1.nextLine();
            writer.write("NAME : "+name);
            writer.write("\nMARK YOUR ATTENDENCE\n");
            System.out.println("-----PRESENT------");
            System.out.println("-----ABSENT-------");
            System.out.println("");
            Scanner s=new Scanner(System.in);
            int ch=s.nextInt();
            if(ch==1){
                writer.write("PRESENT");
            }
            else if(ch==2){
                writer.write("ABSENT");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        display();
    }

    public void showattendence(){
            File sd=new File("attendence.txt");
            try {
                Scanner s=new Scanner(sd);
                while(s.hasNextLine()){
                    String data=s.nextLine();
                    System.out.println(data);
                }
                s.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            display();
        }

}
