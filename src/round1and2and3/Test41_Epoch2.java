/**算法分析：
 * 写的比Epoch1清晰了
 * 左半大根堆，右半小根堆
 * size偶数入左半，size奇数入右半
 * 入之前先检查num范围是否在另一半之中，若是则先入另一半，置换出新的num
 * */

package round1and2and3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test41_Epoch2 {

	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
		@Override
		public int compare(Integer a, Integer b){
			return b.compareTo(a);
		}
	});
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	
	/**系统会调用此方法进行数据的插入
	 * */
    public void Insert(Integer num) {
    	if ( ((maxHeap.size()+minHeap.size())&1 )==0 ){//偶数，推入左半
    		//num∈右半范围，调整
    		if (!minHeap.isEmpty() && num>minHeap.peek()){
    			minHeap.offer(num);
    			num = minHeap.poll();
    		}
    		maxHeap.offer(num);
    	}else{//奇数，推入右半
    		//num∈左半范围，调整
    		if (!maxHeap.isEmpty() && num<maxHeap.peek()){
    			maxHeap.offer(num);
    			num = maxHeap.poll();
    		}
    		minHeap.offer(num);
    	}
    }

    public Double GetMedian() {
        if ( ((maxHeap.size()+minHeap.size())&1 )==0 )
        	return (maxHeap.peek()+minHeap.peek())/2.0;
        else
        	return maxHeap.peek()*1.0;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
