package round1and2and3;
import java.util.Stack;

public class Test31 {
	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
	    Stack<Integer> stack = new Stack<Integer>();
	    int idxPush=0, idxPop=0;
	    
	    //robust
	    if (pushA.length==0 || popA.length==0 || pushA.length!=popA.length)
	    	return false;
	    
		while(idxPush<pushA.length){// ���������1.��ȫƥ�䣬��idxPush��idxPopͬʱ==length 2.��ƥ�䣬��ѹջ�����ѿյ���ջ����δ��
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
		// TODO �Զ����ɵķ������

	}

}
