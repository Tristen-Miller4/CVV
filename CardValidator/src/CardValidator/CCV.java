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
		
		//This is the main menu that asks if you want to validate a card
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
	        int sum = 0;//This sets the value of the 16 digit cards to 0
	        boolean doubleDigit = false; //sets the first value as false because you are supposed to double every second digit that you move from
	        

	        
	        for (int i = number.length() - 1; i >= 0; i--) // this is running the for loop through the card digits from right to left instead of right to left. It goes to the end value minus 1 to get the last digit and then goes from there.
	        {
	            int digit = number.charAt(i) - '0';// this is converting the string digit that is given in the card value to an actual integer 
	            // so this finds what ever number it is going through (i) and it takes its character and converts it to its ASCII number value and then subtracts it by '0' which is 48 to get its final value
	            // this allows the system to do math and convert the characters to integers.

	            if (doubleDigit) //this is when the digit should be doubled
	            {
	                digit = digit * 2;// this is when the digit gets multiplied by 2 
	                if (digit > 9) // this is asking is the digit that was doubled bigger than 9 and goes into a double digit number?
	                
	                {
	                    digit = digit - 9;// if the number is bigger than 9 then it subtracts 9 to get it back to a single digit number
	                }
	            }

	            sum += digit; // this adds the values of the card that has been either doubled and numbers that have been doubled and subtracted by 9  and then stores the results back into sum
	            doubleDigit = !doubleDigit; // this means for the every other digit that isnt the second it doesnt double it. ! means NOT
	        }

	        return sum % 10 == 0; // this makes it so if the result of sum is divisible by 10 then the card is valid
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
