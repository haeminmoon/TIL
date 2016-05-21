public class BinarySearch {
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int resultForBinary, resultRecursionBinary;
		
		resultForBinary = forBinary(array, 3);
		resultRecursionBinary = recursionBinary(array, 3, 0, array.length-1, 0);
		
		System.out.println("forBinary : " +resultForBinary);
		System.out.println("recursionBinary : "+resultRecursionBinary);
	}
	
	public static int recursionBinary(int array[], int findNum, int low, int high, int mid) {
	
		if(low <= high) {	
			mid=(low+high)/2;
			
			if(array[mid] > findNum)
				return recursionBinary(array, findNum, low, mid-1, mid);
			else if(array[mid] < findNum)
				return recursionBinary(array, findNum, mid+1, high, mid);
			else
				return mid;
		}
		
		return -1;
	}
	
	public static int forBinary(int array[], int findNum) {
		
		int low, mid;
		int high=array.length - 1;
		
		for(low=0; low <= high ; ) {
			mid = (low+high)/2;
			
			if(array[mid] > findNum)
				high = mid - 1;
			else if(array[mid] < findNum)
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}

}
