package sort;

public class QuickSort_PartitionRecursion {

	public static void quickSortMain(int[] data) {
		if (data == null || data.length == 0) // robust
			return;
		partition(data, 0, data.length);
	}

	public static int partition(int[] data, int start, int end) {// [)
		if (start >= end) // robust
			return -1;
		if (start==end-1) // 递归出口
			return start;

		int pivot = data[start];
		int front = start, rear = end - 1;

		while (front < rear) {
			while (front < rear && data[rear] >= pivot)
				rear--;
			if (data[rear] < pivot)
				data[front] = data[rear];
			while (front < rear && data[front] <= pivot)
				front++;
			if (data[front] > pivot)
				data[rear] = data[front];
		}
		data[front] = pivot;
		
		partition(data, start, front);
		partition(data, front+1, end);
		return front;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

//		int[] data = { 654, 4, 48, 2, 4, 6, 8, 9, 7, };
		int[] data = { 4,};
		quickSortMain(data);

		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

}
