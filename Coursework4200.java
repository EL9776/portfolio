//Elliot Leigh 4200 Coursework
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Coursework4200 {
   
   public static void main(String[] args)
   // TODO Auto-generated method stub
   throws FileNotFoundException {
      
      String restart;
      
      Scanner Keyboard = new Scanner(System.in);
      
      do {
         Double discountrate = 20.0;
         Double totalIncome = 0.0;
         Double totalDiscount = 0.0;
         String DiscountChoice;
         
         
         System.out.println("----------- Seat Discount System -----------");
         System.out.println(""); // line spacing 
         System.out.println("Would you like to enter a custom discount?(Y/N):  ");
         
         DiscountChoice = Keyboard.next();
         
         /**Method using while loop to produce the error message requesting a new input while the conditions are not met
          *Conditions for this while loop are while the input is Not (!) Y or N will continue to loop
          *equalsIgnoreCase will allow user to input either upper case or lower case equivalent of letter
          */
         
         while (!(DiscountChoice.equalsIgnoreCase("Y") || DiscountChoice.equalsIgnoreCase("N"))) {
            
            System.out.println("INVALID INPUT: Please enter (Y/N)");
            DiscountChoice = Keyboard.next();
         }
         
         
         //method if will run when input == Y asking user for a custom discount rate to be executed upon
         if (DiscountChoice.equalsIgnoreCase("Y")) {
            
            boolean done = false;
            System.out.println("Please enter custom discount rate: ");
            
            
            /** Method do while loop using try and catch to loop as long as the condition "done" is not == true
             *InputMismatchException is used to indicate that the token retrieved does not match the expected data type
             *catching the error and outputting an error message, once valid input has been accepted method continues
             */
            do {
               try {
                  
            	 
                     	discountrate = Keyboard.nextDouble();
            	 
            	   done = true;
            	   
            	   
                  break;
            	   
               } catch (InputMismatchException error) {
                  
                  System.out.println("Please enter a valid input in form 0.0:");
                  Keyboard.next();
                  
               
                  }
               
               
               
            } while (!done);
         
         
            System.out.println("Discount Rate: " + discountrate);
            
            Scanner read = new Scanner(new FileReader("seats.txt"));
            //method while will read from file as long as there is text to be read
            while (read.hasNext()) {
               
               String SeatType = read.next();
               double SeatPrice = read.nextDouble();
               int Bookings = read.nextInt();
               
               double Income = (SeatPrice * Bookings) * (1 - discountrate / 100); //will use calculation to resolve a value for the income for eat seat type
               double Discount = (SeatPrice * Bookings) - Income; // will use calculation to resolve the amount of discount they have given  for each seat type      
               System.out.printf("Seat Type: %s, Seat Price: £%.2f, Bookings: %d, Income: £%.2f Discount: £%.2f\n", SeatType, SeatPrice, Bookings, Income, Discount);
               totalIncome = totalIncome + Income; //running total adding each new income to the value of totalIncome
               totalDiscount = totalDiscount + Discount; //running total for totalDiscount adding discount amount each time
            }
            System.out.println(""); //line spacing
            System.out.println("----------  Summary ----------");
            //%.2f will output totalIncome and totalDiscount to 2 decimal places
            System.out.printf("Total Income: £%.2f\nTotal Discount: £%.2f\n", totalIncome, totalDiscount);
         }
         // method else if will do same as above method when input ==N using default discount rate of 20.0	    			        
         else if (DiscountChoice.equalsIgnoreCase("N")) {
            
            System.out.println("Discount Rate: " + discountrate);
            
            Scanner read = new Scanner(new FileReader("seats.txt"));
            //method while will read from file as long as there is text to be read
            while (read.hasNext()) {
               
               String SeatType = read.next();
               double SeatPrice = read.nextDouble();
               int Bookings = read.nextInt();
               
               double Income = (SeatPrice * Bookings) * (1 - discountrate / 100); //will use calculation to resolve a value for the income for eat seat type
               double Discount = (SeatPrice * Bookings) - Income; // will use calculation to resolve the amount of discount they have given  for each seat type
               System.out.printf("seat type: %s, seat Price: £%.2f, bookings: %d, Income: £%.2f Discount: £%.2f\n ", SeatType, SeatPrice, Bookings, Income, Discount);
               totalIncome = totalIncome + Income; //running total adding each new income to the value of totalIncome
               totalDiscount = totalDiscount + Discount; //running total for totalDiscount adding discount amount each time
               
            }
            System.out.println(""); //line spacing
            System.out.println("----------  Summary ----------");
            System.out.println(""); // line spacing 
            //%.2f will output totalIncome and totalDiscount to 2 decimal places
            System.out.printf("Total Income: £%.2f\nTotal Discount: £%.2f\n", totalIncome, totalDiscount);
            
            
            
            read.close();
         }
         System.out.println(""); // line spacing
         System.out.println("Input any key to restart:");
         restart = Keyboard.next();
         //method do while will restart program as long as a key is input
      } while (!(restart.equalsIgnoreCase("")));
      
      Keyboard.close();
   }
   
   
  
}