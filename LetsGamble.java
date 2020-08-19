import java.util.Random;
class LetsGamble {
	public static void main(String args[]) {
		int initialAmount = 100;
		int currentAmount = initialAmount;
		int betAmount = 1;

		Random random = new Random();
		int gambleResult = 0;
		int isWinner = 0;
		int isLoser = 1;
		int dayCount=0;
		while(initialAmount < 150  && initialAmount > 50){
			gambleResult = random.nextInt(2);
			if(gambleResult==isWinner){
		   	currentAmount+=betAmount;
				dayCount++;
			}

			else{
			   currentAmount-=betAmount;
				dayCount++;
			}

			if(dayCount==20){
				if(initialAmount>currentAmount)
					System.out.println(initialAmount - currentAmount + " lost  after 20 days");		
				else
               System.out.println(currentAmount - initialAmount + " won  after 20 days");
			}						
		}
	}
}
