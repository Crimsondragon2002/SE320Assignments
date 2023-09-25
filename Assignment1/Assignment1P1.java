import java.util.Scanner;
import java.util.InputMismatchException;  
class Assignment1P1 {
    public static void main(String[] args) {
      java.util.Scanner scanner = new java.util.Scanner(System.in);
      boolean fail = false;
      int num1=0;
      int num2=0;
      do{
          try{
          System.out.println("Enter the first number");
          num1 = scanner.nextInt();
          System.out.println("Enter the second number");
          num2 = scanner.nextInt();
          fail=false;
      }
      catch(InputMismatchException e){
          fail=true;
          System.out.println("Wrong values, please try again");
          scanner.next();
      }
      }while(fail==true);
  
      int sum = num1 + num2;
      System.out.println("The sum is " + sum);
           
        
    }
}
