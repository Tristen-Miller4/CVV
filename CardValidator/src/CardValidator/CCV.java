package CardValidator;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;


public class CCV {
	
		
		static Long cardNumber;
		 Scanner userInput = new Scanner(System.in);
		static Long cardnumber;
		static ArrayList<Long> cardNumbers = new ArrayList<Long>();
		 
		 
		
	

	public static void main(String[] args) throws IOException{
		readingTextFile();
		//testCard();
		//userInput();
		//cardLoop();
		 Scanner userIntInput = new Scanner(System.in);
		
		
		System.out.println("Welcome to the Card Validator");
		System.out.println("Press 1) if you would like to validate an inputed card. Press 2) if you want to check the text file");
      int userChoice = userIntInput.nextInt();
      
      if (userChoice == 1)
      {
    	  userInput();
    	  if (testCard(cardNumber) == true) {
    		  System.out.println("That is a potentially valid card!");
    	  }
    	  else {
    		  System.out.println("That is an invalid card!");
    	  }
    	  
      }
      else if (userChoice == 2)
      {
    	cardLoop();
    	
      }
      
      
	}

	private static void cardLoop()throws IOException {
	int validcard = 0;
	int invalidcard =0;
	
	for (int i = 0; i< cardNumbers.size(); i++)
	{
	if (testCard(cardNumbers.get(i)) == true)
	{
		System.out.println(cardNumbers.get(i) + " Valid"); 
		validcard++;
		
	}
	else 
	{
		System.out.println(cardNumbers.get(i) + " Invalid"); 
		invalidcard++;
	}
	
	}
		
	System.out.println("There are " + validcard + " Valid cards and " + invalidcard + " Invalid cards");
	
	}

	private static void userInput()throws IOException {
		 Scanner userLongInput = new Scanner(System.in);
		 System.out.println("Please input a 16 digit card number");
		 cardNumber = userLongInput.nextLong();
		
	}

	public static boolean testCard(Long cardNumber) throws IOException {
		 String number = Long.toString(cardNumber);
	        int sum = 0;
	        boolean doubleDigit = false;

	        
	        for (int i = number.length() - 1; i >= 0; i--) {
	            int digit = number.charAt(i) - '0';

	            if (doubleDigit) {
	                digit = digit * 2;
	                if (digit > 9) {
	                    digit = digit - 9;
	                }
	            }

	            sum += digit;
	            doubleDigit = !doubleDigit;
	        }

	        return sum % 10 == 0;
	    }


   
		
		
		
		
		
		
		
	



	private static void readingTextFile() throws IOException{
		 Scanner userStringINput = new Scanner(System.in);
		 Scanner cardNum = new Scanner (new File("CardNumbers.txt"));
		 while (cardNum.hasNext())
		 {
			 String line=cardNum.nextLine();
			 cardNumbers.add(Long.parseLong(line));
			 
			 
		 }

		
	}

}
