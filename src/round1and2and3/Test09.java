package round1and2and3;
import java.util.Stack;

public class Test09 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(new Integer(node));
    }
    
    public int pop() {
    	if (stack2.empty())
    		while(!stack1.empty())
    			stack2.push(stack1.pop());
    		
    	if (stack2.empty()) //robust
    		return -1;
    	
    	return stack2.pop().intValue(); 
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
