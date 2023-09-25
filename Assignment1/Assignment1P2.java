import java.util.Random;
import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;

class Assignment1P2 {
    public static void main(String[] args) {
      java.util.Scanner scanner = new java.util.Scanner(System.in);
      Random rand = new Random();
      int[] Randomness = new int[100];
      for(int i = 0; i<100;i++){
          Randomness[i]= rand.nextInt(256);
      }
      try{
          System.out.println("Input a number to check");
          int index = scanner.nextInt();
          System.out.println("Index " + index + " is " + Randomness[index]);
      }
      catch(IndexOutOfBoundsException e){
          System.out.println("Out of Bounds");
      }
           
        
    }
}
