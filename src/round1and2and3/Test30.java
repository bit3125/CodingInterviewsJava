package round1and2and3;
import java.util.Stack;

public class Test30 {
	private Stack<Integer> dataStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int node) {
		Integer dataInt = new Integer(node);
		
		this.dataStack.push(dataInt);
		if (minStack.empty())
			minStack.push(dataInt);
		else{// 非空
			Integer minInt = minStack.peek();
			minStack.push(dataInt.compareTo(minInt)<0?dataInt:minInt);
		}
    }
    
    public void pop() {
        if (dataStack.empty())
        	return;
        
    	dataStack.pop();
    	minStack.pop();
    }
    
    public int top() {
    	//robust??
    	
        return dataStack.peek().intValue();
    }
    
    public int min() {
    	//robust??
    	
        return minStack.peek().intValue();
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
