/**算法分析：普通二分查找
 * 
 * */

package round1and2and3;

public class Test53_3_Epoch2 {

	public int getNumberSameAsIdndex(int[] numbers){
		if (numbers==null||numbers.length==0)
			return -1;
		
		int front = 0;
		int rear = numbers.length-1;
		int mid;
		while(front<=rear){
			mid = (front+rear)/2;
			if (numbers[mid]==mid)
				return mid;
			else if (numbers[mid]<mid){
				front = mid+1;
			}else{ //numbers[mid]>mid
				rear = mid-1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] numbers ={-3,-1,1,3,5};
		
		Test53_3_Epoch2 test = new Test53_3_Epoch2();
		int result = test.getNumberSameAsIdndex(numbers);
		System.out.println(result);
		
	}

}
