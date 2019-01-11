
public class SnakesAndLadders {

	public static int ladderIn[] = {3, 6, 20, 36, 63, 68};
	public static int ladderOut[] = {51, 27, 70, 55, 95, 98};
	public static int snakeIn[] = {25, 34, 47, 65, 87, 91, 99};
	public static int snakeOut[] = {5, 1, 19, 52, 57, 61, 69};
	
	public static int ladders(int position){
		 
		for (int i = 0; i < 6; i++){
			if (position == ladderIn[i]){
				System.out.print("You landed on a ladder. You moved from " + position);
				position = ladderOut[i];
				System.out.println(" to " + position);
			}
		}
		 
		return position;
	}
	
	public static int snakes(int position){
		 
		 for (int i = 0; i < 7; i++){
			 if (position == snakeIn[i]){
				 System.out.print("You landed on a snake. You moved from " + position);
				 position = snakeOut[i];
				 System.out.println(" to " + position);
			 }
		 }
		 
		 return position;
	}
	
	public static String ladderDistance(int position){
		String distanceNull = "";
		String distanceOther = "";
		String output = "";
		
		for (int i = 0; i < 6; i++){	
			int distance = ladderIn[i] - position;
			
			if (distance > 0 && distance <= 6){
				if (distanceNull == ""){
					distanceNull = distanceNull + "" + Integer.toString(distance);
					output = distanceNull;
				}
				else {
					distanceOther = distanceNull + " or " + Integer.toString(distance);
					output = distanceOther;
				}
			}
		}
		
		return output;
	}
	
	public static String snakeDistance(int position){
		String distanceNull = "";
		String distanceOther = "";
		String output = "";
		
		for (int i = 0; i < 7; i++){	
			int distance = snakeIn[i] - position;
			
			if (distance > 0 && distance <= 6){
				if (distanceNull == ""){
					distanceNull = distanceNull + "" + Integer.toString(distance);
					output = distanceNull;
				}
				else {
					distanceOther = distanceNull + " or " + Integer.toString(distance);
					output = distanceOther;
				}
			}
		}
		
		return output;
	}
}
