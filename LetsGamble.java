import java.util.Random;
class LetsGamble {
	public static void main(String args[]) {
		int initialAmount = 100;
		int betAmount = 1;

		Random random = new Random();
		int gambleResult = 0;
		int isWinner = 0;
		int isLoser = 1;
		while(initialAmount < 150  && initialAmount > 50){
			gambleResult = random.nextInt(2);
			if(gambleResult==isWinner)
		   	initialAmount+=betAmount;
			else
			   initialAmount-=betAmount;
		}
		if(initialAmount>100)
			System.out.println("IN THE END IT IS : "+ initialAmount +" - AND SO IT IS A WIN");		
		else
			System.out.println("IN THE END IT IS : "+initialAmount + " - AND  SO IT IS A LOSS");
	}
}
