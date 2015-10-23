package utilities;

import java.util.Random;

public class Helper {
	
	/**
	 * generate random number between min and max inclusive of min and max
	 * @param min 
	 * @param max 
	 * @return 
	 */
	public static int getrandomIndex(int min, int max) {
		
		Random r = new Random();
		int randomValue = r.nextInt(max)+min; 
			return randomValue;										
		
	}
	
	public static void main(String[] args){
		for(int i=0;i<100;i++){
		System.out.println(getrandomIndex(1,10)+"");
		}
	}
}
