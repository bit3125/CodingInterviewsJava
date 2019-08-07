package round1and2and3;

public class Test39_Epoch2_Solution1 {

	public int MoreThanHalfNum_Solution(int [] array) {
		if (array==null || array.length==0)
			return 0;
		
		int front = 0, rear = array.length-1;
		int mid = array.length/2;
		int pivotIdx = front;
		while(front<=rear){
			pivotIdx = partition(array, front, rear);
			if (pivotIdx == mid)
				break;
			else if (pivotIdx<mid)
				front = pivotIdx+1;
			else if (pivotIdx>mid)
				rear = pivotIdx-1;
		}
		
		//check
		int cnt = 0;
		for (int i=0;i<array.length;i++){
			if (array[i]==array[pivotIdx])
				cnt++;
		}
		if (cnt>array.length/2)
			return array[pivotIdx];
		else
			return 0;
	}
	
	public int partition(int[] array, int start, int end){
		int pivot = array[start];
	
		while(start<end){//TODO
			while(start<end && array[end]>=pivot)
				end--;
			if (start<end)
				array[start] = array[end];
			while(start<end && array[start]<=pivot)
				start++;
			if (start<end)
				array[end] = array[start];
		}
		array[start] = pivot;//***bug:б╘ак
		return start;		
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,2,4,2,5,2,3};
		Test39_Epoch2_Solution1 t = new Test39_Epoch2_Solution1();
		System.out.println(t.MoreThanHalfNum_Solution(array));
		
	}

}
