public class Noswapsort {
	public static void main(String[] args) {
		int[] input = {89,23,100,1,5,3,3,9};
		sortNum(input);
	}
	
	public static void sortNum(int array[]) {
		int[] sortArray = new int[101];
		
		for(int i=0;i<array.length;i++) {
			sortArray[array[i]]++;
		}
		
		for(int i=0;i<sortArray.length;i++) {
			if(sortArray[i]!=0) {
				for(int j=0;j<sortArray[i];j++) {
					System.out.println(i + ", ");
				}
			}
		}
	}
}