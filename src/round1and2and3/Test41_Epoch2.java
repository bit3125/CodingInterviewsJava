/**�㷨������
 * д�ı�Epoch1������
 * ������ѣ��Ұ�С����
 * sizeż������룬size�������Ұ�
 * ��֮ǰ�ȼ��num��Χ�Ƿ�����һ��֮�У�������������һ�룬�û����µ�num
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
	
	/**ϵͳ����ô˷����������ݵĲ���
	 * */
    public void Insert(Integer num) {
    	if ( ((maxHeap.size()+minHeap.size())&1 )==0 ){//ż�����������
    		//num���Ұ뷶Χ������
    		if (!minHeap.isEmpty() && num>minHeap.peek()){
    			minHeap.offer(num);
    			num = minHeap.poll();
    		}
    		maxHeap.offer(num);
    	}else{//�����������Ұ�
    		//num����뷶Χ������
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
		// TODO �Զ����ɵķ������

	}

}
