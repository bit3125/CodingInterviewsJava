package round1and2and3;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Test41 {
	/**算法一：基于partition的离线的取中位数算法
	 * Tn（一次插入）= O1, Tn（查找中位） = On, Sn = On（使用了一个辅助数组来以离线形式存储数据流）
	 * 
	 * */
//	public int MAXSIZE = 1000;
//	private ArrayList<Integer> al = new ArrayList<Integer>();
//	
//    public void Insert(Integer num) {
//        al.add(new Integer(num));
//    }
//
//    public Double GetMedian() {
//        
//    	int mid = al.size()/2;
//    	int pivotIdx = partition(al, 0, al.size());
//    	while(pivotIdx!=mid){
//    		if (pivotIdx>mid)
//    			pivotIdx = partition(al, 0, pivotIdx);
//			else if (pivotIdx<mid)
//				pivotIdx = partition(al, pivotIdx+1, al.size());
//    	}
//    	
//    	if (al.size()%2==1)//奇数个
//    		return new Double(al.get(pivotIdx).intValue());
//    	else {//偶数个
//    		Integer left = al.get(pivotIdx), right;
//    		mid = mid-1;
//    		while(pivotIdx!=mid){
//        		if (pivotIdx>mid)
//        			pivotIdx = partition(al, 0, pivotIdx);
//    			else if (pivotIdx<mid)
//    				pivotIdx = partition(al, pivotIdx+1, al.size());
//        	}
//    		right = al.get(pivotIdx);
//    		return new Double((left.intValue()+right.intValue())/2.0);
//    	}
//    }
//    
//    public int partition(ArrayList<Integer> al, int start, int end){
//    	Integer pivot = al.get(start);
//    	int front = start, rear = end-1;
//    	
//    	while(front<rear){
//    		while(front<rear && al.get(rear).intValue()>=pivot.intValue())
//    			rear--;
//    		if (al.get(rear).intValue()<pivot.intValue())
//    			al.set(front, al.get(rear));
//    		while(front<rear && al.get(front).intValue()<=pivot.intValue())
//    			front++;
//    		if (al.get(front).intValue()>pivot.intValue())
//    			al.set(rear, al.get(front));
//    	}
//    	al.set(front, pivot);
//    	
//    	return front;
//    }
	
	/**算法二：基于大根堆的在线的取中位数的算法:不可实现！是错误的！
	 * Tn = O(n*logk), Sn = O(logk)
	 * */
	
	/**算法三：基于大根堆+小根堆的离线取中位数的算法
	 * Tn（一次插入） = O(logn) ,Tn（查找中位） = O(1), Sn = On
	 * 
	 * 建立两个堆，左侧大根堆与右侧小根堆，用来替代AVL的功能。
	 * 左侧使用maxHeap存放总序列的小半列，右侧使用minHeap存放总序列的大半列
	 * 始终保证 maxHeap.size()>=minHeap.size() && maxHeap.size()-minHeap.size()<2 (模仿AVL,降低查找的最坏时间复杂度)
	 * maxHeap与minHeap堆顶存放的都是总队列的中位数可能值，是大小子列的分界点
	 * 每次插入新数的时候与两者比较，然后决定加入小子列或是大子列
	 * 在插入后进行类似AVL的左右子列调整，保证size的要求
	 * 最终 ：
	 * 要么maxHeap.size()==minHeap.size()， median = (max.peek+min.peek)/2
	 * 要么maxHeap.size()==minHeap.size()+1，median = max.peek
	 * */
	public int MAXSIZE = 1000;
	public int size = 0;
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
		@Override
		public int compare(Integer n1, Integer n2){
			return n2.compareTo(n1);
		}
	});//小侧堆(优先，如果总数是奇数个，max.size==min.size+1)
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
		@Override
		public int compare(Integer n1, Integer n2){
			return n1.compareTo(n2);
		}
	});//大侧堆
	
    public void Insert(Integer num) {
    	if (maxHeap.isEmpty()){//全空
    		maxHeap.add(num);
    	}else if (minHeap.isEmpty()){//左不空右空
    		if (maxHeap.peek().intValue()>num){//***bug
    			minHeap.add(maxHeap.poll());
    			maxHeap.add(num);
    		}else
    			minHeap.add(num);
    	}else{//皆非空 //***bug
    		if (num.intValue()<=maxHeap.peek().intValue())
    			maxHeap.add(num);
    		else
    			minHeap.add(num);
    	}
    	
    	//adjust AVL
		if (maxHeap.size()-minHeap.size()>1)//左比右多2
			minHeap.add(maxHeap.poll());
		else if (minHeap.size()-maxHeap.size()>0)//右比左多
			maxHeap.add(minHeap.poll());
    }

    public Double GetMedian() {
        int size = maxHeap.size()+minHeap.size();
    	if (size%2==0)
        	return new Double((maxHeap.peek().intValue()+minHeap.peek().intValue())/2.0);
        else
        	return new Double(maxHeap.peek().intValue());
    } 
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test41 test = new Test41();
//		int[] array = {5};
//		int[] array = {5,2};
//		int[] array = {5,2,3};
		int[] array = {5,2,3,4,1,6,7,0,8,9};
		for (int i=0;i<array.length;i++){
			test.Insert(new Integer(array[i]));
		}
		System.out.println(test.GetMedian());
		
	}

}
