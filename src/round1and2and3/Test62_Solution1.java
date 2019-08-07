package round1and2and3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test62_Solution1 {

    public int LastRemaining_Solution(int n, int m) {
        if (n<=0 || m<=0)
        	return -1;
        			
    	List<Integer> cycle = new LinkedList<>();
        for (int i=0;i<n;i++){
        	cycle.add(i);
        }
        
        Iterator<Integer> iter = cycle.iterator();
        while(cycle.size()>1){
        	for (int i=0;i<m;i++){
        		if (!iter.hasNext()){
        			System.out.println("restart");
        			iter = cycle.iterator();
        		}
        	}
        	iter.remove();
        }
        
        return cycle.get(0);
    } 
	
	public static void main(String[] args) {
		Test62_Solution1 t = new Test62_Solution1();
		int n = 5;
		int m = 3;
				
		
		
	}

}
