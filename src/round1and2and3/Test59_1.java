package round1and2and3;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Test59_1 {

    public ArrayList<Integer> maxInWindows(int [] num, int size){
    	ArrayList<Integer> maxes = new ArrayList<Integer>();
    	Deque<Integer> curWinIdxs = new LinkedList<Integer>();
    	if (num==null || num.length<size ||size==0)//robust
    		return maxes;
    	
    	//init queue
    	for (int i=0;i<size;i++){
    		Integer curNumIdx = new Integer(i);
    		while (!curWinIdxs.isEmpty()){//移除队列中所有比curNum小的数
    			if (num[curWinIdxs.getLast()]<num[curNumIdx])
    				curWinIdxs.removeLast();
				else
					break;
    		}
    		curWinIdxs.addLast(curNumIdx);//插入curNum
    	}
    	maxes.add(new Integer(num[curWinIdxs.getFirst()]));
    	
    	//body
    	for (int i=size;i<num.length;i++){
    		if (curWinIdxs.getFirst()<=i-size)//移除已经出窗的
    			curWinIdxs.removeFirst();
    		
    		Integer curNumIdx = new Integer(i);
    		while (!curWinIdxs.isEmpty()){//移除队列中所有比curNum小的数
    			if (num[curWinIdxs.getLast()]<num[curNumIdx])
    				curWinIdxs.removeLast();
				else
					break;
    		}
    		curWinIdxs.addLast(curNumIdx);//插入curNum
    		maxes.add(new Integer(num[curWinIdxs.getFirst()]));
    	}
    	
    	return maxes;
    }
    
    public static void main(String[] args){
    	int[] data = {2,3,4,2,6,2,5,1};
    	
    	Test59_1 test = new Test59_1();
    	ArrayList<Integer> al = test.maxInWindows(data, 3);
    	
    	for (int i=0;i<al.size();i++){
    		System.out.println(al.get(i));
    	}
    	
    	
    }
}
