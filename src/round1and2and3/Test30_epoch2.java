package round1and2and3;

import java.util.Stack;

public class Test30_epoch2 {

	private Stack<Integer> dataStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
    public void push(int node) {
        dataStack.push(node);
        minStack.push(Integer.min(node, minStack.empty()?Integer.MAX_VALUE:minStack.peek()));
    }
    
    public void pop() {
        if (!dataStack.empty()){
        	dataStack.pop();
        	minStack.pop();
        }
    }
    
    public int top() {
    		return dataStack.peek();
    }
    
    public int min() {
        	return minStack.peek();
    }
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
