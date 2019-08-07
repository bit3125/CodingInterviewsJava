/**依然是基于寻找边界的二分查找
 * 根据题意，假设n=6，missingNum==3，那么数组必然是形如以下的数组：{0,1,2,4,5,6}
 * 故可以将数组分为前后两个子列：idx==value的子列与idx+1==value的子列
 * 于是乎只需要找到第二个子列的左边界idx，即为所求
 * */

package round1and2and3;

public class Test53_2_Epoch2 {

	public int getMissingNumber(int[] numbers){
		if (numbers==null || numbers.length==0) //robust
			return -1;
		
		if (numbers[0]==1)
			return 0;
		else if (numbers[numbers.length-1]==numbers.length-1)
			return numbers.length;
		
		int front = 0;
		int rear = numbers.length-1;
		int mid;
		while(rear-front>1){
			mid = (front+rear)/2;
			if (numbers[mid]==mid){
				front = mid;
			}else {//numbers[mid]==mid+1
				rear = mid;
			}
		}
		
		return rear;
	}
	
	public static void main(String[] args) {
//		int[] data = {0,1,2,3,5,6,7};
//		int[] data = {0};
//		int[] data = {0,1,2,3};
		int[] data = {1,2,3};
		Test53_2_Epoch2 test = new Test53_2_Epoch2();
		System.out.println(test.getMissingNumber(data));
		
	}

}
