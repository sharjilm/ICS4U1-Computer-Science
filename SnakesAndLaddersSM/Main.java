import java.util.Scanner;

public class Main {

	public static String player1Name;
	public static String player2Name;
	public static String rollNumber;
	public static int turn = 1;
	public static int player1Position = 0;
	public static int player2Position = 0;
	public static int player1Turn = 0;
	public static int player2Turn = 0;
	public static int player1Score;
	public static int player2Score;
	public static boolean game = true;
	public static long startTime;	
	public static long endTime;
	public static long totalTime;
	private static int number;
	
 public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		startTime = System.currentTimeMillis();
		
		System.out.println("Welcome to the Snakes and Ladders game. Player 1, please input your name.");
		System.out.println();
		player1Name = keyboard.nextLine();
		System.out.println();
		
		System.out.println("Player 2, please input your name:");
		System.out.println();
		player2Name = keyboard.nextLine();
		System.out.println();
		
	while (game){
				
		switch (turn){
		
		case 1:
			String nearestLadder1 = SnakesAndLadders.ladderDistance(player1Position);
			String nearestSnake1 = SnakesAndLadders.snakeDistance(player1Position);
			
			if (nearestLadder1 != ""){
				System.out.println("If you roll a " + nearestLadder1 + ", you will land on a ladder!");
			}
			
			if (nearestSnake1 != ""){
				System.out.println("If you roll a " + nearestSnake1 + ", you will land on a snake!");
			}
			
			System.out.println(player1Name + ", please enter 1 into the console to roll the dice.");
			System.out.println();
			rollNumber = keyboard.nextLine();
			System.out.println();
			
			number = Integer.parseInt(rollNumber);
			
			switch (number){
			
			case 1: 
				int rollDice = Dice.getRandomNumber(6, 1);
				System.out.println("You have moved " + rollDice + " spaces.");	
				player1Position += rollDice; 
				player1Position = SnakesAndLadders.ladders(player1Position);
				player1Position = SnakesAndLadders.snakes(player1Position);
				
				if (player1Position > 100){
					player1Position -= rollDice;
				}
				
				System.out.println("Your position is " + player1Position + ".");
				System.out.println();
				break;
				
			default:
				System.out.println("Invalid input. Please enter 1 into the console.");
				System.out.println();
				rollNumber = keyboard.nextLine();
				number = Integer.parseInt(rollNumber);
				System.out.println();
				break;
			}
			
			player1Turn++;
			turn = 2;
			break;
			
		 case 2:
			 	String nearestLadder2 = SnakesAndLadders.ladderDistance(player2Position);
				String nearestSnake2 = SnakesAndLadders.snakeDistance(player2Position);
				
				if (nearestLadder2 != ""){
					System.out.println("If you roll a " + nearestLadder2 + ", you will land on a ladder!");
				}
				
				if (nearestSnake2 != ""){
					System.out.println("If you roll a " + nearestSnake2 + ", you will land on a snake!");
				}
			 
			 System.out.println(player2Name + ", please enter 1 into the console to roll the dice.");
			 System.out.println();
			 rollNumber = keyboard.nextLine();
			 System.out.println();
				
			 number = Integer.parseInt(rollNumber);
				
			 if (number == 1){
				int rollDice = Dice.getRandomNumber(6, 1);
				System.out.println("You have moved " + rollDice + " spaces.");	
				player2Position += rollDice; 
				player2Position = SnakesAndLadders.ladders(player2Position);
				player2Position = SnakesAndLadders.snakes(player2Position);
				
				if (player2Position > 100){
					player2Position -= rollDice;
				}
				
				System.out.println("Your position is " + player2Position + ".");
				System.out.println();
			 }
				
			 player2Turn++;
			 turn = 1;
			 break;
		}
		
		if (player1Position == 100 | player2Position == 100){
			game = false;
		}
		
	}
	
	if (player1Position > player2Position){
		System.out.println("Congratulations " + player1Name + ", you won the game!");
		System.out.println("");
	}
	
	else if (player2Position > player1Position){
		System.out.println("Congratulations " + player1Name + ", you won the game!");
		System.out.println("");
	}

	keyboard.close(); 
	
	endTime = System.currentTimeMillis(); 
	totalTime = (endTime - startTime) / 1000;
	
	player1Score = 100 - player1Turn;
	player2Score = 100 - player2Turn;
	
	String player1Highscore = Integer.toString(player1Score);
	String player2Highscore = Integer.toString(player2Score);
	
	Scorekeeper.fileMaker(player1Name, player2Name, player1Highscore, player2Highscore);
	
 }

} 