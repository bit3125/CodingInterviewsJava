package round1and2and3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Test59_1_Epoch2 {

    public ArrayList<Integer> maxInWindows(int [] num, int size){
    	ArrayList<Integer> result = new ArrayList<>();
    	if (num==null || num.length==0 || size<=0 || num.length<size)
    		return result;
    		
    	Deque<Integer> d = new LinkedList<>();
    	
    	//init
    	for (int i=0;i<size;i++){
    		while(!d.isEmpty() && num[d.getLast()]<num[i])
				d.removeLast();
    		d.offerLast(i);
    	}
    	result.add(num[d.getFirst()]); 
    	
    	//slide
    	for (int i=size;i<num.length;i++){
    		if (d.getFirst()<=i-size)
    			d.removeFirst();
    		while(!d.isEmpty() && num[d.getLast()]<num[i])
				d.removeLast();
    		d.offerLast(i);
    		
    		result.add(num[d.getFirst()]); //得到当前新滑窗的max
    	}
    	
        return result;
    }
	
	public static void main(String[] args) {
		Deque<Integer> d = new LinkedList<>();
		
		d.offer(1);
		d.offer(2);
		System.out.println(d.peek());
	}

}
