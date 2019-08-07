/**��Ȼ�ǻ���Ѱ�ұ߽�Ķ��ֲ���
 * �������⣬����n=6��missingNum==3����ô�����Ȼ���������µ����飺{0,1,2,4,5,6}
 * �ʿ��Խ������Ϊǰ���������У�idx==value��������idx+1==value������
 * ���Ǻ�ֻ��Ҫ�ҵ��ڶ������е���߽�idx����Ϊ����
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
