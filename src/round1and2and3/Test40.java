package round1and2and3;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Test40 {
	/**基于partition的解法
	 * Tn = On, Sn = O1
	 * */
//    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//    	ArrayList<Integer> al = new ArrayList<Integer>();
//    	if (input==null || input.length==0 || k<=0 || k>input.length)
//    		return al;
//    	
//    	int pivotIdx = partition(input, 0, input.length);
//    	while (pivotIdx+1!=k){
//    		if (pivotIdx+1<k)
//    			pivotIdx = partition(input, pivotIdx+1, input.length);
//    		else if (pivotIdx+1>k)
//    			pivotIdx = partition(input, 0, pivotIdx);
//    	}
//    	
//    	for (int i=0;i<k;i++)
//    		al.add(new Integer(input[i]));
//    	
//    	return al;
//    }
//    
//    public int partition(int[] array, int start, int end){
//    	int pivot = array[start];
//    	int front = start, rear = end-1;
//    	while(front<rear){
//    		while(front<rear && array[rear]>=pivot)
//    			rear--;
//    		if (!(array[rear]>=pivot))
//    			array[front] = array[rear];
//    		while(front<rear && array[front]<=pivot)
//    			front++;
//    		if (!(array[front]<=pivot))
//    			array[rear] = array[front];
//    	}
//    	array[front] = pivot;
//    	
//    	return front;
//    }
	
	/**解法二：基于大根堆的解法
	 * Tn = O(n*logk), Sn = Ok
	 * 且不修改原数组
	 * */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	if (input==null || input.length==0 || k>input.length || k<=0) //robust
    		return al;
    	
    	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
    		@Override
    		public int compare(Integer n1, Integer n2){
    			return n2.compareTo(n1);
    		}
    	});
    	
    	for (int i=0;i<k;i++)
    		maxHeap.add(new Integer(input[i]));
    	for (int i=k;i<input.length;i++){
    		if (input[i]<maxHeap.peek()){
    			maxHeap.poll();
    			maxHeap.add(new Integer(input[i]));
    		}
    	}
    	while(!maxHeap.isEmpty())
    		al.add(maxHeap.poll());
    	
    	return al;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}

}
