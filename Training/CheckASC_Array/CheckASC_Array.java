public class CheckASC_Array {

	public static void main(String[] args) {
		int[] testArray_1 = {1, 0, 0, 4, 5, 6, 7};
		int[] testArray_2 = {1, 1, 4, 1, 5, 3, 7};
		
		System.out.println(checkArray(testArray_1));
	}
	
	public static boolean checkArray(int[] array) {
		int prev=array[0];
		boolean isSorted = true;	//Already sorted or not
		
		for(int i = 1; i < array.length - 1; i++) {
			if(array[i] <= prev) {
				
				isSorted = false;
				
				for(int j=i-1; j >= 0; j--) {
					
					int[] swapArray = array.clone(); 
					
					int temp = swapArray[i];
					swapArray[i] = swapArray[j];
					swapArray[j] = temp;
										
					if(checkASC(swapArray)) 
						return true;
				}
			}
			prev = array[i];
		}
		
		if(!isSorted)
			return false;
		else
			return true;
	}
	
	public static boolean checkASC(int[] swapArray) {
	
		/*debug Code*/
		for(int i: swapArray) {
			System.out.print(i +" ");
		}
		System.out.println();
		
		boolean isASC = true;
			
		for(int k = 0; k < swapArray.length - 2 ; k++) {
			if(swapArray[k] > swapArray[k+1])
				isASC = false;	
		}
		
		return isASC;
	}
	
}
