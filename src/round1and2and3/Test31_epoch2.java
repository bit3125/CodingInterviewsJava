package round1and2and3;

import java.util.Stack;

public class Test31_epoch2 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	if (pushA==null || popA==null || pushA.length!=popA.length)
    		return false;
    	Stack<Integer> stack = new Stack<>();
    	
    	int idxPush = 0;
    	int idxPop = 0;
    	while(idxPush<pushA.length){
    		stack.push(pushA[idxPush]);
    		idxPush++;
    		while(!stack.empty() && stack.peek()==popA[idxPop]){
    			stack.pop();
    			idxPop++;
    		}
    	}
    	
    	return idxPop==popA.length;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
