package firstprogram;
import java.util.Scanner;
public class casepercabang {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan Nilai :");
        int nilai = scanner.nextInt();
        String grade;
        if(nilai >90){
            grade = "A";
        }else if(nilai>80){
            grade = "B";
        }else if(nilai > 70){
            grade="C";
        }else{
            grade = "F";
        }
        System.out.println("Grade adalah = "+grade);
    }
}
