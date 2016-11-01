
public class Palindrome {

   public static void main(String[] args) {
      String str = "oncn";
      
      solve(str);
   }
   public static int solve(String str){
        String input = str;
        int length = input.length();
        int[] arr = new int[length + 1];

        arr[length] = length;
        arr[length - 1] = length;

        for (int i = length - 2; i >= 0; i--) {
            char c = input.charAt(i);
            int j = arr[i+1];
            while (true) {
                if (c == input.charAt(j-1)) {
                    arr[i] = j-1;
                    break;
                }
                if (j == length) {
                    arr[i] = length;
                    break;
                }
                j = arr[j];
            }
        }
        int j = length;
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (c == input.charAt(j-1)) {
                j--;
            } else {
                while (j < length) {
                    j = arr[j];
                    if (c == input.charAt(j-1)) {
                        j--;
                        break;
                    }
                }
            }
        }
        return length+j;
    }

}