package ITSS2020;

import java.util.Scanner;

public class TiffanyLourdraj_Project001 {

	public static void main(String[] args) {
		 
		String name; // defining the string name

		
		 
		name = getName();  // calling upon method to get user's name
		String operation = getOperation(); // calling upon the value of the type of operation which will be the letters A,M,S, or D
		int numProblems = getProblems(); // calling upon method for number of problems
		int lowValue=  lowRange(); // calling upon the method for the lowValue of range
		int highValue=  highRange(); // calling upon the method for the highValue of the range

	 
		int number1; // random number for the first number for +,X,/ or -
		int number2;// random number for the second number for +,X,/ or -
		int result; // the result of the user to compare to the actual value of the equation
		Scanner input = new Scanner(System.in);

		double tallyCorrect=0.0; // tally starts at 0 so when it goes through the if statement it racks up points
		double tallyIncorrect=0.0; // tally starts at 0 so when it goes through the else statement it racks up points
		
 		
		double startTime = System.currentTimeMillis(); // method to count time passed 
			switch (operation) {

			case "A":  // switch statement for addition 
  				for (int i = 1; i<=numProblems; i++) 
				{
					
				
				number1 = (int)(Math.floor(Math.random() * (highValue - lowValue + 1)) + lowValue); //random value in range
				number2 = (int)(Math.floor(Math.random() * (highValue - lowValue + 1)) + lowValue); // random value in range
 				System.out.print
				("What is " + number1 + " + " + number2 + "? "); 
				result = input.nextInt();
					if (result == (number1+number2)) // if else to check if answer is right
					{
						System.out.print("\ncorrect\n");	
						tallyCorrect=tallyCorrect+1;
						
					}
					else if (result != (number1+number2))
					{
						System.out.print("\nincorrect\n");	
						tallyIncorrect= tallyIncorrect+1;
					}
						
				} 
  				
  		double endTime = System.currentTimeMillis(); 
  		double totalTime = (endTime-startTime)/1000; // covert the milliseconds to seconds
  		double totalScore = (tallyCorrect)/numProblems*100.0; // formula to calculate total right
  		System.out.print("Session Summary ");
  		System.out.print("\n" + numProblems + " problems," + (int)tallyCorrect + " correct");
  		System.out.print("\n score is " + (int)totalScore + " , Time is " +  totalTime + " seconds ");
  		System.out.print("\n Session for " + name + " was Addition on " + java.time.LocalDate.now() + " at " +   java.time.LocalTime.now() ); // gets the local time and date
 

				break; 
			case "S": // switch statement for Subtraction, same structure as before
				
				for (int i = 1; i<=numProblems; i++) 
				{
					
				
				number1 = (int)(Math.floor(Math.random() * (highValue - lowValue + 1)) + lowValue);
				number2 = (int)(Math.floor(Math.random() * (highValue - lowValue + 1)) + lowValue);
 				System.out.print
				("What is " + number1 + " - " + number2 + "? ");
				result = input.nextInt();
					if (result == (number1-number2))
					{
						System.out.print("\ncorrect\n");	
						tallyCorrect=tallyCorrect+1;
						
					}
					else if (result != (number1-number2))
					{
						System.out.print("\nincorrect\n");	
						tallyIncorrect= tallyIncorrect+1;
					}
						
				} 
  				
  		double sendTime = System.currentTimeMillis();
  		double stotalTime = (sendTime-startTime)/1000;
  		double stotalScore = (tallyCorrect)/numProblems*100.0;
  		System.out.print("Session Summary ");
  		System.out.print("\n" + numProblems + " problems," + (int)tallyCorrect + " correct");
  		System.out.print("\n score is " + (int)stotalScore + " , Time is " +  stotalTime + " seconds ");
  		System.out.print("\n Session for " + name + " was Subtraction on " + java.time.LocalDate.now() + " at " +   java.time.LocalTime.now() );
 
				break;
				
				
			case "M": // switch statement for multiplication, same structure as before
				
				for (int i = 1; i<=numProblems; i++) 
				{
					
				
				number1 = (int)(Math.floor(Math.random() * (highValue - lowValue + 1)) + lowValue);
				number2 = (int)(Math.floor(Math.random() * (highValue - lowValue + 1)) + lowValue);
 				System.out.print
				("What is " + number1 + " x " + number2 + "? ");
				result = input.nextInt();
					if (result == (number1*number2))
					{
						System.out.print("\ncorrect\n");	
						tallyCorrect=tallyCorrect+1;
						
					}
					else if (result != (number1*number2))
					{
						System.out.print("\nincorrect\n");	
						tallyIncorrect= tallyIncorrect+1;
					}
						
				} 
  				
  		double mendTime = System.currentTimeMillis();
  		double mtotalTime = (mendTime-startTime)/1000;
  		double mtotalScore = (tallyCorrect)/numProblems*100.0;
  		System.out.print("Session Summary ");
  		System.out.print("\n" + numProblems + " problems, " + (int)tallyCorrect + " correct");
  		System.out.print("\n score is " + (int)mtotalScore + " , Time is " +  mtotalTime + " seconds ");
  		System.out.print("\n Session for " + name + " was Multiplication on " + java.time.LocalDate.now() + " at " +   java.time.LocalTime.now() );
 
  		
				break; 
				
				
			case "D":// switch statement for division, same structure as before
				
				for (int i = 1; i<=numProblems; i++) 
				{
					
				
				number1 = (int)(Math.floor(Math.random() * (highValue - lowValue + 1)) + lowValue);
				number2 = (int)(Math.floor(Math.random() * (highValue - lowValue + 1)) + lowValue);
 				System.out.print
				("What is " + number1*number2 + " / " + number2 + "? ");
				result = input.nextInt();
					if (result == (int)(number1*number2/number2)) // X dividend by quotient and ask for the divisor
					{
						System.out.print("\ncorrect\n");	
						tallyCorrect=tallyCorrect+1;
						
					}
					else if (result != (int)(number1*number2/number2))
					{
						System.out.print("\nincorrect\n");	
						tallyIncorrect= tallyIncorrect+1;
					}
						
				} 
  				
  		double dendTime = System.currentTimeMillis();
  		double dtotalTime = (dendTime-startTime)/1000;
  		double dtotalScore = (tallyCorrect)/numProblems*100.0;
  		System.out.print("Session Summary ");
  		System.out.print("\n" + numProblems + " problems," + (int)tallyCorrect + " correct");
  		System.out.print("\n score is " + (int)dtotalScore + " , Time is " +  dtotalTime + " seconds ");
  		System.out.print("\n Session for " + name + " was Division on " + java.time.LocalDate.now() + " at " +   java.time.LocalTime.now() );
 
				break; 
			}
		 
		} 
	public static String getName() { // method for getting user's name
		Scanner input = new Scanner(System.in);
		System.out.print("Hi, please tell me your name: " );
		String mName = input.next();
		return mName;
		
		
	}
 

	public static String getOperation() { // method for getting preferred operation
		Scanner input = new Scanner(System.in);
		System.out.print("Enter \"A\" for Addition, \"S\" for Subtraction, \"M\" for Multiplication, \"D\" for Division:" );
		String operation = input.next();
		return operation;
		
		
	}

	public static int getProblems() { // method for getting the # of problems
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of problems you wish to work:" );
		int numProblems = input.nextInt();
		return numProblems;
		
		
	}


	public static int lowRange() { // method for getting the lower number in range 
		Scanner input = new Scanner(System.in);
		System.out.print("What are the low and high numbers you want in your problems? \n"+ "" );
		System.out.print("Enter the low value for your problems: " );
		int lowValue = input.nextInt();
 		return lowValue; 
	}



	public static int highRange() { // method for getting the higher number in range
		Scanner input = new Scanner(System.in);
 		System.out.print("Enter the high value for your problems:"); 
		int highValue = input.nextInt();
		return highValue; 
	}
 
 
 
}
