import java.util.*;
class LetsGamble {
	public static void main(String args[]) {
		int initialAmount = 100;
		int currentAmount = initialAmount;
		int betAmount = 1;
		int gambleResult = 0;
		int ISWINNER = 0;
		int dayCount=0;
		List<Integer> dailyResultList  = new ArrayList<>();
      Random random = new Random();
		while(currentAmount < 150  && currentAmount > 50){
			gambleResult = random.nextInt(2);
			if(gambleResult==ISWINNER){
		   	currentAmount+=betAmount;
				dayCount++;
				dailyResultList.add(gambleResult);
			}

			else{
			   currentAmount-=betAmount;
				dayCount++;
				dailyResultList.add(gambleResult);
			}
	
			if(dayCount==20){
				if(initialAmount>currentAmount)
					System.out.println(initialAmount - currentAmount + " won  after 20 days");		
				else
               System.out.println(currentAmount - initialAmount + " lost  after 20 days");
			}						
		}
		int sum=0;
		System.out.println("The Monthly Sum of bet won is :");
		
		for(int i=1;i<31;i++){
			if(i>9)
				System.out.print(i+" ");
			else
				System.out.print(i+"  ");
		}
		System.out.println(" ");

		for (int i=0;i<dailyResultList.size()-30;i+=30){
			sum=0;
			for(int j=i;j<i+30;j++)	{
				sum += dailyResultList.get(j);
				System.out.print(dailyResultList.get(j)+"  ");
			}
			System.out.println("WON = "+sum+" "+"LOST = "+(30-sum)+" AMOUNT WON = "+sum );			
		}
	}
}
