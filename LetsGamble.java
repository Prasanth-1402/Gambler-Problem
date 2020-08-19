import java.util.Random;
class LetsGamble {
	public static void main(String args[]) {
		int initialAmount = 100;
		int betAmount = 1;

		Random random = new Random();
		int gambleResult = random.nextInt(2);
		int isWinner = 0;
		int isLoser = 1;
		if(gambleResult == isWinner)
			System.out.println("HURRAY!!! ITS A WIN");
		else
			System.out.println("BETTER LUCK NEXT TIME.!");
	}
}
