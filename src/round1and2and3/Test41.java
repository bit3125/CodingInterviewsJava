package round1and2and3;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Test41 {
	/**�㷨һ������partition�����ߵ�ȡ��λ���㷨
	 * Tn��һ�β��룩= O1, Tn��������λ�� = On, Sn = On��ʹ����һ��������������������ʽ�洢��������
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
//    	if (al.size()%2==1)//������
//    		return new Double(al.get(pivotIdx).intValue());
//    	else {//ż����
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
	
	/**�㷨�������ڴ���ѵ����ߵ�ȡ��λ�����㷨:����ʵ�֣��Ǵ���ģ�
	 * Tn = O(n*logk), Sn = O(logk)
	 * */
	
	/**�㷨�������ڴ����+С���ѵ�����ȡ��λ�����㷨
	 * Tn��һ�β��룩 = O(logn) ,Tn��������λ�� = O(1), Sn = On
	 * 
	 * ���������ѣ�����������Ҳ�С���ѣ��������AVL�Ĺ��ܡ�
	 * ���ʹ��maxHeap��������е�С���У��Ҳ�ʹ��minHeap��������еĴ����
	 * ʼ�ձ�֤ maxHeap.size()>=minHeap.size() && maxHeap.size()-minHeap.size()<2 (ģ��AVL,���Ͳ��ҵ��ʱ�临�Ӷ�)
	 * maxHeap��minHeap�Ѷ���ŵĶ����ܶ��е���λ������ֵ���Ǵ�С���еķֽ��
	 * ÿ�β���������ʱ�������߱Ƚϣ�Ȼ���������С���л��Ǵ�����
	 * �ڲ�����������AVL���������е�������֤size��Ҫ��
	 * ���� ��
	 * ҪômaxHeap.size()==minHeap.size()�� median = (max.peek+min.peek)/2
	 * ҪômaxHeap.size()==minHeap.size()+1��median = max.peek
	 * */
	public int MAXSIZE = 1000;
	public int size = 0;
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
		@Override
		public int compare(Integer n1, Integer n2){
			return n2.compareTo(n1);
		}
	});//С���(���ȣ������������������max.size==min.size+1)
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
		@Override
		public int compare(Integer n1, Integer n2){
			return n1.compareTo(n2);
		}
	});//����
	
    public void Insert(Integer num) {
    	if (maxHeap.isEmpty()){//ȫ��
    		maxHeap.add(num);
    	}else if (minHeap.isEmpty()){//�󲻿��ҿ�
    		if (maxHeap.peek().intValue()>num){//***bug
    			minHeap.add(maxHeap.poll());
    			maxHeap.add(num);
    		}else
    			minHeap.add(num);
    	}else{//�Էǿ� //***bug
    		if (num.intValue()<=maxHeap.peek().intValue())
    			maxHeap.add(num);
    		else
    			minHeap.add(num);
    	}
    	
    	//adjust AVL
		if (maxHeap.size()-minHeap.size()>1)//����Ҷ�2
			minHeap.add(maxHeap.poll());
		else if (minHeap.size()-maxHeap.size()>0)//�ұ����
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
		// TODO �Զ����ɵķ������
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
