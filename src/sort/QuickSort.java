package sort;

import java.util.Arrays;

/**�㷨��������������ݽṹ��������
 * 
 * */
public class QuickSort {

	public static void quickSortMain(int[] data){
		if (data==null || data.length==0) //robust
			return;
		quickSort(data, 0, data.length);
	}
	
	public static void quickSort(int[] data, int start, int end){
		if (start>=end) //�ݹ���� //***bug:û������ж������Ļ������޵ݹ飨start==idx�������һֱ�ݹ���ȥ���ݹ�һ��Ҫ�еݹ���ڰ���.
			return ;
		
		int pivotIdx = partition(data, start, end);
		quickSort(data, start, pivotIdx);
		quickSort(data, pivotIdx+1, end);
	}
	
	public static int partition(int[] data, int start, int end){//[)
		if (start>=end) //robust
			return start;
		
		int pivot = data[start];
		int front=start, rear=end-1;
		
		while(front<rear){
			while( front<rear && data[rear]>=pivot) //�ƶ�rear������front��λ
				rear--;
//			if (data[rear]<pivot)//�������
				data[front] = data[rear];
			while( front<rear && data[front]<=pivot) //�ƶ�front������rear��λ
				front++;
//			if (data[front]>pivot) //�������
				data[rear] = data[front];
		}
		data[front] = pivot;
		return front;
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		int[] data = {654,4,48,2,4,6,8,9,7,3,8,1,6,9,7,2,5,4,6,};
		quickSortMain(data);
		
		System.out.println(Arrays.toString(data));
	}

}
