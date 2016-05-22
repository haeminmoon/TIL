
public class MinHandlingStr {
	public static void main(String[] args) {
		String s1 = "HAEMINMOON";
		String s2 = "HAEMIN";
		
		System.out.println(getDistance(s1, s2));
	}
	private static int getDistance(String s1, String s2) {
	    int longStrLen = s1.length() + 1;
	    int shortStrLen = s2.length() + 1;
	 
	    int[] cost = new int[longStrLen];
	    int[] newcost = new int[longStrLen];
	 
	    for (int i = 0; i < longStrLen; i++) {
	        cost[i] = i;
	    }
	 
	    for (int j = 1; j < shortStrLen; j++) {

	        newcost[0] = j;
	 

	        for (int i = 1; i < longStrLen; i++) {

	          int match = 0;
	          if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
	            match = 1;
	          }
	          

	            int replace = cost[i - 1] + match;
	            int insert = cost[i] + 1;
	            int delete = newcost[i - 1] + 1;
	 

	            newcost[i] = Math.min(Math.min(insert, delete), replace);
	        }
	 
	        
	        int[] temp = cost;
	        cost = newcost;
	        newcost = temp;
	    }
	 
	    return cost[longStrLen - 1];
	}
}
