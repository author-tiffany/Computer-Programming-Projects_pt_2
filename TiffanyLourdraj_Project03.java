
import java.util.Scanner;
import java.util.*;

//user inputs prompted and captured in this driver class
class Driver {
	private String name; // defining the string name
	private  String operation; // calling upon the value of the type of operation which will be the letters A,M,S, or D
	private  int numProblems; // calling upon method for number of problems
	private  int lowValue; // calling upon the method for the lowValue of range
	private  int highValue; // calling upon the method for the highValue of the range
	private Scanner input = new Scanner(System.in);
	
	
	Driver() {
		boolean tryAgain = true;
		
		// Get the operation type input
		System.out.print("Hi, please tell me your name: " );
		name = input.nextLine();
		do {
			System.out.print("Enter \"A\" for Addition, \"S\" for Subtraction, \"M\" for Multiplication, \"D\" for Division:" );
			operation = input.next();
			if (operation.equalsIgnoreCase("a") || operation.equalsIgnoreCase("s")
					|| operation.equalsIgnoreCase("m") || operation.equalsIgnoreCase("d")) 
					tryAgain = false;
			else
					System.out.println("Operation must be A, S, M or D.  Try again.");
		} while (tryAgain);

		// Get the number of problems input
		tryAgain = true;
		do {
			try {
				System.out.print("Enter the number of problems you wish to work:" );
				numProblems = input.nextInt();
				if(numProblems <= 0) {
					System.out.println("Invalid entry. Try again");
					tryAgain = true;
				} else
					tryAgain = false;
			}
			catch (InputMismatchException e1) {
				System.out.println("Invalid entry. Try again");
				input.nextLine();
			}
			catch (IllegalArgumentException e2) {
				System.out.println("Invalid entry. Try again");
				input.nextLine();
			}
		} while (tryAgain);

		// Get the low value input
		tryAgain = true;
		do {
			try {
				System.out.print("Enter the low value for your problems: " );
				lowValue = input.nextInt();
				if(lowValue < 0) {
					System.out.println("Invalid entry. Try again");
					tryAgain = true;
				} else
					tryAgain = false;
			}
			catch (InputMismatchException e1) {
				System.out.println("Invalid entry. Try again");
				input.nextLine();
			}
			catch (IllegalArgumentException e2) {
				System.out.println("Invalid entry. Try again");
				input.nextLine();
			}
		} while (tryAgain);

		// Get the high value input
		tryAgain = true;
		do {
			try {
		 		System.out.print("Enter the high value for your problems:"); 
				highValue = input.nextInt();
				if(highValue <= 0) {
					System.out.println("Invalid entry. Try again");
					tryAgain = true;
				} else
					tryAgain = false;
			}
			catch (InputMismatchException e1) {
				System.out.println("Invalid entry. Try again");
				input.nextLine();
			}
			catch (IllegalArgumentException e2) {
				System.out.println("Invalid entry. Try again");
				input.nextLine();
			}
		} while (tryAgain);
	}
	
    String GetName() {// get methods to access private variables

    	return name;
	}
    
    String GetOperation() {// get methods to access private variables

    	return operation;
	}
			
	int GetNumproblems() {// get methods to access private variables

		return numProblems;
	}
	
	int GetlowValue()  {// get methods to access private variables

		return lowValue;
	}
	
	
	int GetHighvalue() {// get methods to access private variables

		return highValue;
	}
}

//Problems presented and scored  in this Problems class
class Problems {
	private int number1 = 0; // random number for the first number for +,X,/ or -
	private int number2 = 0;// random number for the second number for +,X,/ or -
	private  int result; // the result of the user to compare to the actual value of the equation
	private  int correct_result; // the result of   the actual value of the equation
	private Scanner input = new Scanner(System.in);
	private  String operation ; // the type of operation which will be the letters A,M,S, or D
	private String operationSymbol; // the type of operation which will be the + - * or /
	private  int numProblems; //  number of problems
	private  int lowValue ; // the lowValue of range
	private  int highValue ; // the highValue of the range

	private String probImage; // printing session summary at end
	private Session mySession;// pass values 

	
	Problems (Driver driver, Session session ){
		operation = driver.GetOperation(); 
		numProblems = driver.GetNumproblems();
		lowValue =  driver.GetlowValue(); 
		highValue = driver.GetHighvalue(); 
		mySession = session;
		probImage = new String();
		switch (operation) {
			case "A": 
			case "a": // switch statement for addition 
				operationSymbol = "+";
				break; 
			case "S": 
			case "s": // switch statement for substraction 
				operationSymbol = "-";
				break; 
			case "M": 
			case "m": // switch statement for multiplication 
				operationSymbol = "*";
				break; 
			case "D": 
			case "d": // switch statement for division 
				operationSymbol = "/";
				break; 
		}
	}
	
	//get the two operands
	void GetFactors() {
		if(operationSymbol != "/") {
			number1 = (int)(Math.floor(Math.random() * (highValue - lowValue + 1)) + lowValue); //random value in range
			number2 = (int)(Math.floor(Math.random() * (highValue - lowValue + 1)) + lowValue); // random value in range
		} else {
			number2 = (int)(Math.floor(Math.random() * (highValue - lowValue + 1)) + lowValue); // random value in range
			if(number2 == 0)
				number2 =1;
			number1 = (int)(Math.floor(Math.random() * (highValue- lowValue  + 1)) + lowValue); //random value in range
		}
	}
	
	//Get the result of the operation
	int equation() {
		switch (operationSymbol) {

		case "+": 
			correct_result = (number1+number2);
			break; 
		case "-":
			correct_result = (number1-number2);
			break;
		case "*":
			correct_result = (number1*number2);
			break; 
		case "/":
			correct_result = (int)(number1*number2/number2);
			break; 
		}
	 
		return correct_result;
	}
	
	//Loop for the number of problems and score
	void Score() {

		for (int i = 1; i<=numProblems; i++) 
		{
			GetFactors();
			int operand1;
			if(operationSymbol != "/") {
				operand1 = number1;
			} else {
				operand1 = number1*number2;
			}	
			
			//Get the result input
			boolean tryAgain = true;
			do {
				try {
					System.out.print( operand1 + " " + operationSymbol + " "  + number2 + " = "); 
					result = input.nextInt();
					if(result <= 0) {
						System.out.println("Invalid entry. Try again");
						tryAgain = true;
					} else
						tryAgain = false;
				}
				catch (InputMismatchException e1) {
					System.out.println("Invalid entry. Try again");
					input.nextLine();
				}
				catch (IllegalArgumentException e2) {
					System.out.println("Invalid entry. Try again");
					input.nextLine();
				}
			} while (tryAgain);
			
			
			correct_result =equation();
			if (result == correct_result) // if else to check if answer is right
			{
				System.out.print("correct\n");
				mySession.AddTallyCorrect();
				probImage = operand1 + " " + operationSymbol + " " + number2 +  " = " + result + " A: " + correct_result + " correct";
				mySession.UpdateprobArray(probImage);					
			}
			else if (result != correct_result)
			{
				System.out.print("incorrect\n");	
				mySession.AddTallyInCorrect();
				probImage = operand1 + " " + operationSymbol + " " + number2 +  " = " + result + " A: " + correct_result + " incorrect";
				mySession.UpdateprobArray(probImage);
			}
				
		} 
	} 
	
	
}

//Session summary prints are done from this class
class Session {
	private String name; 
	private double dendTime ;  // the current time in the time zone
	private  double dtotalTime;// calc for total time in end to solve problems
	private  double dtotalScore; // to calculate total percentage score
	private double startTime ; // method to count time passed 
	private  int numProblems; //  number of problems
	private double tallyCorrect=0.0; // tally starts at 0 so when it goes through the if statement it racks up points
	private double tallyIncorrect=0.0; // tally starts at 0 so when it goes through the else statement it racks up points
	private  String operation ;
	private  int lowValue ; // the lowValue of range
	private  int highValue ; // the highValue of the range
	private String [] probArray;
	private int index=0;

	Session(Driver driver) {
		name = driver.GetName();
		numProblems = driver.GetNumproblems();
		lowValue =  driver.GetlowValue(); 
		highValue = driver.GetHighvalue(); 
		probArray = new String[100];
		switch (driver.GetOperation()) {
			case "A":
			case "a":// needs to include lowercase Char
				operation = "add";
				break;
			case "S":
			case "s":// needs to include lowercase Char
				operation = "substraction";
				break;
			case "M":
			case "m":// needs to include lowercase Char
				operation = "Mulitiplication";
				break;
			case "D":
			case "d": // needs to include lowercase Char
				operation = "Division";
				break;
		}
		
		startTime = System.currentTimeMillis();
	}
	
	void AddTallyCorrect() {// keeping score of correct answers

		tallyCorrect = tallyCorrect + 1;
	}
	
	void AddTallyInCorrect() { // keeping score of wrong answers
		tallyIncorrect = tallyCorrect + 1;
	}

	void UpdateprobArray(String str) { // stores the problems in the array
		probArray[index] = str; // index to go to next element 
		index++; // increment the index
	}
	void printSummary() {
		dendTime = System.currentTimeMillis();// finds the current time for the user
		dtotalTime = (dendTime-startTime)/1000; // calc the total time taken to finish
		dtotalScore = (tallyCorrect)/numProblems*100.0; // calculates the total score in a percentage value
		
		System.out.print("\n Session Summary \n");
		System.out.print("\n" + numProblems + " problems, " + (int)tallyCorrect + " correct, score is " + (int) dtotalScore + ", time is " + (int)dtotalTime + " sec" );
		System.out.print("\n Session: " + name + " " + operation + " " + lowValue  + ", " + highValue + ", " + java.time.LocalDate.now() + ", " +   java.time.LocalTime.now()  + ", " + numProblems + ", " + (int)tallyCorrect + ", " + (int)dtotalScore + ", " + (int)dtotalTime + "\n");
		System.out.print("\n");
		for (int i = 0; i<numProblems; i++) { // goes through the array 
			System.out.print(probArray[i]);
			System.out.print("\n");
		}
		
	}
}

public class TiffanyLourdraj_Project03 {

	public static void main(String[] args) {
		//Get the result input
		boolean tryAgain = true; //for outerloop to repeat session
		boolean tryAgain2 = true; //for inner loop to get y/n input
		String restart; // declare the restart function
		Scanner input = new Scanner(System.in);

		
		do { // do while loop for extra credit 
			Driver driver = new Driver();
	 		Session session = new Session(driver);
	 		
			Problems problems = new Problems(driver, session );
			problems.Score();
			session.printSummary(); // method to print 
			tryAgain = true; // try again true value to restart 
			tryAgain2 = true; // same as above
			do {
				System.out.print("Would you like to try another set of problems? Y/N?" ); // if the user wants to do it again
				restart = input.next();
				if (restart.equalsIgnoreCase("y")) { // repeats if yes
					tryAgain2 = false;
					tryAgain = true;
				}
				else if (restart.equalsIgnoreCase("n")) {
					System.out.print("Thank you for playing! Play again soon.\n" );
					tryAgain2 = false;
					tryAgain = false;
				}
				else {
					System.out.println("Invalid entry. Try again");  // will only accept y or n
					tryAgain2 = true;
					input.nextLine();
				}
				
			} while (tryAgain2);
		} while (tryAgain); 

		
	}
}


