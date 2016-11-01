public class CountCoin {

   public static void main(String[] args) {
      int[] coinTypes = {1, 2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
      int money = 10000;
      int[] dp = new int[100000];
      
      dp[0]++;
      for(int i=0; i<coinTypes.length; i++) {
         for(int j=coinTypes[i]; j<=money; j++) {
            dp[j] += dp[j-coinTypes[i]];
         }
      }
      System.out.println(dp[money]);
   }

}