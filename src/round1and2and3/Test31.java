package round1and2and3;
import java.util.Stack;

public class Test31 {
	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
	    Stack<Integer> stack = new Stack<Integer>();
	    int idxPush=0, idxPop=0;
	    
	    //robust
	    if (pushA.length==0 || popA.length==0 || pushA.length!=popA.length)
	    	return false;
	    
		while(idxPush<pushA.length){// 两种情况：1.完全匹配，则idxPush与idxPop同时==length 2.不匹配，则压栈序列已空但出栈序列未空
			stack.push(pushA[idxPush]);
			idxPush++;
			while(stack.peek()==popA[idxPop]){
				stack.pop();
				idxPop++;
				if (stack.empty())//***bug
					break;
			}
		}
		
		return idxPop==popA.length; 
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
