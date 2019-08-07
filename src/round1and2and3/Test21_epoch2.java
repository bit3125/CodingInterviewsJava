/**�˴�д�ľ������㽣ָoffer�ϵ��㷨������ţ���ϵ��㷨Ҫ���ȶ�����
 * �����ȶ�������뵽��˼·�ǶԵģ�����ʹ�ø�����������ݴ�
 * ������дһ����
 * */

package round1and2and3;

import java.util.Arrays;

public class Test21_epoch2 {

	public static void reOrderArray(int[] array){
		if (array==null || array.length==0)
			return;
		
		int front, rear;
		int tmp;
		front = 0;
		rear = array.length-1;
		while(front<rear){
			while(front<rear && (array[front]&1)==1)
				front++;
			while(front<rear && (array[rear]&1)==0)
				rear--;
			
			if (front>=rear)
				break;
			//swap
			tmp = array[front];
			array[front] = array[rear];
			array[rear] = tmp;
				
		}
	}


	public static void main(String[] args) {
		int[] array = new int[]{3,4,2,4,8,7,9,6};
		reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}

}
