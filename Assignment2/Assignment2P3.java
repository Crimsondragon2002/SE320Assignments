
import java.util.Scanner;
class Assignment2P3 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Input a number from 0 to 10 ");
        int number = scanner.nextInt();
        assert number>=0 && number<=10 : "The entered number is out of range";
         System.out.println(number);
    }
}
