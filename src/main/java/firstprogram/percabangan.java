package firstprogram;

import java.util.Scanner;
public class percabangan {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String Password = prompt("Enter Passowrd :");
        String validPassword = "password";

        if(Password.equals("password")){
            System.out.println("Selamat datang");
        }else{
            System.out.println("Password salah");
        }
    }
    public static String prompt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
