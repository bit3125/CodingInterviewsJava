/**基于快排partition思想的算法：寻找中位数
 * 
 * */
package round1and2and3;

public class Test39_Solution1 {

	public int MoreThanHalfNum_Solution(int[] array) {
		if (array == null || array.length == 0) // robust
			return -1;

		int start = 0, end = array.length;
		int mid = (start + end - 1) / 2;
		int pivotIdx;

		pivotIdx = partition(array, start, end);
		while (pivotIdx != mid) {
			if (pivotIdx > mid)
				pivotIdx = partition(array, start, pivotIdx);
			else // pivotIdx<mid
				pivotIdx = partition(array, pivotIdx + 1, end);
		}

		// check if midNum is the right answer
		int cnt = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == array[pivotIdx])
				cnt++;
		}
		if (cnt < mid + 1)
			return 0;

		return array[pivotIdx];
	}

	public int partition(int[] array, int start, int end) {
		if (start >= end)
			return -1;
		if (start == end - 1)
			return start;

		int pivot = array[start];
		int front = start, rear = end - 1;// ***bug:front = start+1

		while (front < rear) {
			while (front < rear && array[rear] >= pivot)
				rear--;
			if (!(array[rear] >= pivot))
				array[front] = array[rear];
			while (front < rear && array[front] <= pivot)
				front++;
			if (!(array[front] <= pivot))
				array[rear] = array[front];
		}
		array[front] = pivot;

		return front;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
