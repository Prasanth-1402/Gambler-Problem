import java.util.*;
class LetsGamble {
    public static int STARTAMOUNT = 100;
    public static int ISWINNER = 1;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
		  char userInput = 'y';
		  while(true){ 
			 boolean proceed = monthlyResult(STARTAMOUNT);
			 if(proceed == true){
			    System.out.println("Hurray!! You Won .... Wanna continue ??? ");
			    System.out.println(" Press \'N\' or \'n\' to terminate");
			    userInput = scan.nextLine().charAt(0);
			    if(userInput=='N'||userInput=='n')
				    break;
			  }
			  if(proceed==false){
				System.out.println("OOPS!! Sorry, You lost..! ");
				break;
			  }		  
		 }
    }

    private static  boolean monthlyResult(int initialAmount){
        int winAmount=0,loseAmount=0,monthDayCount=0,winDayCount=0;
        int[]  daysWon= new int[30];
        HashMap<Integer,Integer> map = new HashMap<>();

        while(monthDayCount<30) {
            initialAmount = 100;
            Random random = new Random();

            while (initialAmount < 150 && initialAmount > 50) {
                int result = random.nextInt(2);
                if (result == ISWINNER)
                    initialAmount++;
                else
                    initialAmount--;
            }

            if (initialAmount > 100) {
                winAmount = loseAmount + (initialAmount - 100);
                daysWon[monthDayCount]=1;
                winDayCount++;
            }
            if (initialAmount < 100) {
                loseAmount = loseAmount + (100 - initialAmount);
                daysWon[monthDayCount]=-1;
            }

            if (monthDayCount==20) {
                System.out.println("In 20 Days : ");
                System.out.print("    Won : :" + winAmount);
                System.out.println("    Lost  : : " + loseAmount);
            }
            monthDayCount++;
        }
        System.out.print("DAYS WON : ");

            System.out.println(winDayCount+" LOST DAYS : "+(30-winDayCount));
        for(int i=0;i<daysWon.length;i++){
            if((int)daysWon[i]==1) {
                winDayCount++;
            }
        }
        map.put(1,0);
        map.put(-1,0);
        Integer curr = null;
        int count = 0;
        for (int val : daysWon) {
            if (curr == null) {
                curr = val;
                count = 1;
            }
            else if (curr != val) {
                if(count>map.get(curr))
                    map.put(curr,count);

                curr = val;
                count = 1;
            }
            else {
                ++count;
            }
        }
        System.out.println(" ");


        int countDay =0, MaxLoseDay =0;
        while(countDay <map.get(-1)){
            countDay =1;
            MaxLoseDay=0;
            for(int i=0;i<daysWon.length-1;i++){
                if(daysWon[i]==-1 && daysWon[i+1]==-1){
                    countDay++;
                    if(countDay ==map.get(-1)){
                        MaxLoseDay =i+1;
                        break;
                    }
                }
            }
        }
        System.out.println("MaxLost Day = "+ (MaxLoseDay+1));

        countDay=0;
        int maxGainDay=0;
        while(countDay <map.get(1)){
            countDay =1;
            maxGainDay=0;
            for(int i=0;i<daysWon.length-1;i++){
                if(daysWon[i]==1 && daysWon[i+1]==1){
                    countDay++;
                    if(countDay ==map.get(1)){
                        maxGainDay =i+1;
                        break;
                    }
                }
            }
        }
        System.out.println("Max Gain Day = "+ (maxGainDay+1));
        
        if(winAmount>loseAmount){
            System.out.println("WON AT THE END OF THE MONTH : "+winAmount);
            return true;
        }else
            System.out.println("LOST AT THE END OF THE MONTH : "+loseAmount);
        return false;
    }
}
