package sort;

import java.util.Arrays;

/**算法具体分析见《数据结构（王道）
 * 
 * */
public class QuickSort {

	public static void quickSortMain(int[] data){
		if (data==null || data.length==0) //robust
			return;
		quickSort(data, 0, data.length);
	}
	
	public static void quickSort(int[] data, int start, int end){
		if (start>=end) //递归出口 //***bug:没有这句判断条件的话会无限递归（start==idx的情况会一直递归下去。递归一定要有递归出口啊！.
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
			while( front<rear && data[rear]>=pivot) //移动rear找数填front空位
				rear--;
//			if (data[rear]<pivot)//无需这个
				data[front] = data[rear];
			while( front<rear && data[front]<=pivot) //移动front找数填rear空位
				front++;
//			if (data[front]>pivot) //无需这个
				data[rear] = data[front];
		}
		data[front] = pivot;
		return front;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		int[] data = {654,4,48,2,4,6,8,9,7,3,8,1,6,9,7,2,5,4,6,};
		quickSortMain(data);
		
		System.out.println(Arrays.toString(data));
	}

}
