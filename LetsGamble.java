import java.util.*;
class LetsGamble {
    public static int STARTAMOUNT = 100;
    public static int ISWINNER = 1;

    public static void main(String args[]) {
        List<Integer>  daysWon= new ArrayList<>();
        monthlyResult(STARTAMOUNT);
    }

    private static  int monthlyResult(int initialAmount){
        int winAmount=0,loseAmount=0,monthDayCount=1,winDayCount=0;
        List<Integer>  daysWon= new ArrayList<>();
        while(monthDayCount<=30) {
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
            }
            if (initialAmount < 100) {
                loseAmount = loseAmount + (100 - initialAmount);
            }
            if (monthDayCount==20) {
                System.out.println("In 20 Days : ");
                System.out.print("    Won : :" + winAmount);
                System.out.println("    Lost  : : " + loseAmount);
            }
            monthDayCount++;
        }
        System.out.print("DAYS WON : ");
        for(int i=0;i<daysWon.size();i++){
            if((int)daysWon.get(i)==1) {
                winDayCount++;
            }
        }
            System.out.println(winDayCount+" LOST DAYS : "+(30-winDayCount));
        System.out.println(" ");

        if(winAmount>loseAmount){
            System.out.println("WON AT THE END OF THE MONTH : "+winAmount);
            return winAmount;
        }else
            System.out.println("LOST AT THE END OF THE MONTH : "+loseAmount);
        return loseAmount;
    }
}
