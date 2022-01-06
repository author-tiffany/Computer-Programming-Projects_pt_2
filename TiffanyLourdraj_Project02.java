
import java.util.Scanner;

//user inputs prompted and captured in this driver class
class Driver {
	private String name; // defining the string name
	private  String operation; // calling upon the value of the type of operation which will be the letters A,M,S, or D
	private  int numProblems; // calling upon method for number of problems
	private  int lowValue; // calling upon the method for the lowValue of range, private so only driver can see it
	private  int highValue; // calling upon the method for the highValue of the range
	private Scanner input = new Scanner(System.in);
	
	
	Driver() { // driver class that outputs the questions
		System.out.print("Hi, please tell me your name: " );
		name = input.next();
		System.out.print("Enter \"A\" for Addition, \"S\" for Subtraction, \"M\" for Multiplication, \"D\" for Division:" );
		operation = input.next();
		System.out.print("Enter the number of problems you wish to work:" );
		numProblems = input.nextInt();
		System.out.print("What are the low and high numbers you want in your problems? \n"+ "" );
		System.out.print("Enter the low value for your problems: " );
		lowValue = input.nextInt();
 		System.out.print("Enter the high value for your problems:"); 
		highValue = input.nextInt();
	}
	
    String GetName() { // get methods to access private variables
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
	private Session mySession; // pass values 
	
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
	 
		return correct_result; // save value of correct result
	}
	
	//Loop for the number of problems and score
	void Score() {

		for (int i = 1; i<=numProblems; i++)  // before there was switch statement, but now its for loop
		{
			GetFactors();
			int operand1;
			if(operationSymbol != "/") {
				operand1 = number1;
			} else {
				operand1 = number1*number2;
			}			
			System.out.print
			( operand1 + " " + operationSymbol + " "  + number2 + " = "); 
			result = input.nextInt();
			correct_result =equation();
			if (result == correct_result) // if else to check if answer is right
			{
				System.out.print("correct\n");
				mySession.AddTallyCorrect();
				probImage = operand1 + " " + operationSymbol + " " + number2 +  " = " + result + " A: " + correct_result + " correct";
				mySession.UpdateprobArray(probImage);	// putting it in the session and saving it to the array to print out later				
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
	private String name; // the name of the participant
	private double dendTime ; // the current time in the time zone
	private  double dtotalTime; // calc for total time in end to solve problems
	private  double dtotalScore; // to calculate total percentage score
	private double startTime ; // method to count time passed 
	private  int numProblems; //  number of problems
	private double tallyCorrect=0.0; // tally starts at 0 so when it goes through the if statement it racks up points
	private double tallyIncorrect=0.0; // tally starts at 0 so when it goes through the else statement it racks up points
	private  String operation ; // checks the operation of the problem 
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
			case "a": // needs to include lowercase Char for addition
				operation = "Addition";
				break;
			case "S":
			case "s": // needs to include lowercase Char for addition
				operation = "Subtraction";
				break;
			case "M":
			case "m":// needs to include lowercase Char for addition
				operation = "Multiplication";
				break;
			case "D":
			case "d":// needs to include lowercase Char for addition
				operation = "Division";
				break;
		}
		
		startTime = System.currentTimeMillis();
	}
	
	void AddTallyCorrect() { // keeping score of correct answers
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
		dendTime = System.currentTimeMillis(); // current time 
		dtotalTime = (dendTime-startTime)/1000; // to find the total time taken to solve
		dtotalScore = (tallyCorrect)/numProblems*100.0; // score formula for percentage
		
		System.out.print("\n Session Summary \n");
		System.out.print("\n" + numProblems + " problems, " + (int)tallyCorrect + " correct, score is " + (int) dtotalScore + ", time is " + (int)dtotalTime + " sec" );
		System.out.print("\n Session: " + name + " " + operation + " " + lowValue  + ", " + highValue + ", " + java.time.LocalDate.now() + ", " +   java.time.LocalTime.now()  + ", " + numProblems + ", " + (int)tallyCorrect + ", " + (int)dtotalScore + ", " + (int)dtotalTime + "\n");
		System.out.print("\n");
		for (int i = 0; i<numProblems; i++) { // for loop to print problem per line
			System.out.print(probArray[i]); // 
			System.out.print("\n");
		}
		
	}
}

public class TiffanyLourdraj_Project02 { // the main class that instantiates the new methods

	public static void main(String[] args) { // default format for 
 		Driver driver = new Driver();
 		Session session = new Session(driver);
 		
		Problems problems = new Problems(driver, session );
		problems.Score(); // calculating the total score
		session.printSummary(); // calls on print summary
	}
		
	
	


}


