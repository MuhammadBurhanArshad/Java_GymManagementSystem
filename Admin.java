import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Admin {

    static Scanner s = new Scanner(System.in);

    static void menu() {
        ArrayList<String> arrayList = new ArrayList<String>();
        System.out.println("1. INSERT MEMBER RECORD");
        System.out.println("2. DELETE MEMBER RECORD");
        System.out.println("3. UPDATE MEMBER RECORDS");
        System.out.println("4. VIEW MEMBER RECORDS");
        System.out.println("5. SEARCH MEMBER");
        System.out.println("6. VEIW MEMBER'S ATTENDANCE");
        Scanner s = new Scanner(System.in);
        System.out.println("please enter your choice(enter 7 to go back)");
        int ch = s.nextInt();
        if (ch == 1) {
            insert_data();
        } else if (ch == 2) {
            delete_member(arrayList, s);
        } else if (ch == 3) {
            update_member(arrayList, s);
        } else if (ch == 4) {
            show_data();
        }
        else if (ch == 5) {
            search_member();
        } else if (ch==6) {
            User u = new User();
            u.showattendence();
        } else if (ch==7){
            start st = new start();
            st.start();
        }else {
            System.out.println("Wrong choice");
            menu();
        }
    }

    public static void insert_data() {
        int pack;
        boolean string_check;
        File f = new File("Members data.txt");
        try {
            f.createNewFile();
            FileWriter writer = new FileWriter("Members data.txt", true);
            System.out.println("ENTER NO OF MEMBERS YOU WANT TO ENTER DATA");
            int n = s.nextInt();
            for (int i = 1; i <= n; i++) {
                s.nextLine();
                System.out.println("\nplease enter member information");
                do {
                System.out.println("\nenter name");
                    String name = s.nextLine();
                    string_check = string_checker(name);
                    if (string_check==true) {
                        writer.write("\t" + name + ",");
                    }else {
                        System.out.println("Invalid input");
                    }
                }while (string_check!=true);
                do {
                    System.out.println("\nenter contact number");
                    String contact = s.nextLine();
                    string_check=string_checker(contact);
                    if (string_check==false) {
                        writer.write("\t" + contact + ",");
                    }else {
                        System.out.println("Invalid input");
                    }
                }while (string_check!=false);
                    System.out.println("\nenter email address");
                    String email = s.nextLine();
                        writer.write("\t" + email + ",");
                do {
                    System.out.println("\nenter CNIC number");
                    String CNIC = s.nextLine();
                    string_check=string_checker(CNIC);
                    if (string_check==false) {
                        writer.write("\t" + CNIC + ",");
                    }else {
                        System.out.println("Invalid Input");
                    }
                }while (string_check!=false);
                do {
                    System.out.println("\nenter days per week");
                    String days = s.nextLine();
                    string_check=string_checker(days);
                    if (string_check==false) {
                        writer.write("\t" + days + ",");
                    }else {
                        System.out.println("Invalid Input");
                    }
                }while (string_check!=false);
                do {
                    System.out.println("\nenter hours spent");
                    String hours = s.nextLine();
                    string_check=string_checker(hours);
                    if (string_check==false) {
                        writer.write("\t" + hours + ",");
                    }else {
                        System.out.println("Invalid input");
                    }
                }while (string_check!=false);
                do {
                System.out.println("Enter package you want to enroll(type the choice number)");
                System.out.println("1)Cardio Section\n2)Selectorized Training Section\n3)Free Weights Section\n4)Functional Fit Area\n5)Studio");
                 pack = s.nextInt();

                if (pack==1) {
                    int pay = 5000;
                    writer.write("PACKAGE PAYMENT " + pay);
                } else if (pack==2) {
                    int pay = 10000;
                    writer.write("PACKAGE PAYMENT " + pay);
                } else if (pack==3) {
                    int pay = 7000;
                    writer.write("PACKAGE PAYMENT " + pay);
                } else if (pack==4) {
                    int pay = 6000;
                    writer.write("PACKAGE PAYMENT " + pay);
                } else if (pack==5) {
                    int pay = 9000;
                    writer.write("PACKAGE PAYMENT " + pay);
                }else {
                    System.out.println("Wrong choice, enter the correct option");
                }}while ((pack!=5)&&(pack!=4)&&(pack!=3)&&(pack!=2)&&(pack!=1));
                writer.write("\n");
            }
            writer.close();
            System.out.println("Data entered");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        menu();
    }

    public static void update_member(ArrayList<String> arrayList, Scanner input) {
        boolean string_check;
        String search;
        System.out.println("Enter The name of the member whose data you want to replace");
        do {
            search = input.next();
            string_check=string_checker(search);
            if (string_check==false){
                System.out.println("Invalid Input");
            }
        }while (string_check!=true);
        String line;
        try {

            BufferedReader read = new BufferedReader(new FileReader("Members data.txt"));
            while ((line = read.readLine()) != null) {
                if (line.contains(search)) {
                    System.out.println(line);
                    continue;
                } else {
                    arrayList.add(line);
                }
            }

        } catch (Exception e) {

        }
        try {
            FileWriter write = new FileWriter("Members data.txt");
            for (int i = 0; i < arrayList.size(); i++) {
                write.append(arrayList.get(i));
                write.append("\n");
            }
            write.close();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Data Found!");
        }
        insert_data();
    }

    public static void show_data() {
        File sd = new File("Members data.txt");
        try {
            Scanner s = new Scanner(sd);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                System.out.println(data);
            }
            s.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        menu();
    }

    public static void delete_member(ArrayList<String> arrayList, Scanner input) {
        boolean string_check;
        String search;
        System.out.println("Enter member's name to delete their record");
        do {
            search = input.next();
            string_check=string_checker(search);
            if (string_check==false){
                System.out.println("Invalid input");
            }
        }while (string_check!=true);
        String line;
        try {

            BufferedReader read = new BufferedReader(new FileReader("Members data.txt"));
            while ((line = read.readLine()) != null) {
                if (line.contains(search)) {
                    System.out.println(line);
                    continue;
                } else {
                    arrayList.add(line);
                }
            }

        } catch (Exception e) {

        }
        try {
            FileWriter write = new FileWriter("Members data.txt");
            for (int i = 0; i < arrayList.size(); i++) {
                write.append(arrayList.get(i));
                write.append("\n");
            }
            write.close();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Data Found and has been deleted");
        }
        menu();
    }

    public static void search_member() {
        boolean string_check;
        String search;
        boolean find_status=false;
        System.out.println("Enter member's name to search their record");
        do {
            search = s.next();
            string_check=string_checker(search);
            if (string_check==false){
                System.out.println("Invalid input");
            }
        }while (string_check!=true);
        String line;
        BufferedReader read = null;
        try {
            read = new BufferedReader(new FileReader("Members data.txt"));
            while ((line = read.readLine()) != null) {
                if (line.contains(search)) {
                    System.out.println(line);
                    System.out.println("RECORD FOUND");
                    find_status=true;
                }
            }
            if (find_status==false){
                    System.out.println("Record isn't found");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }

    static boolean string_checker(String word){
        boolean is_string=false;

        for (int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if (Character.isAlphabetic(ch)){
                is_string=true;
            }
        }
        return is_string;
    }
}

