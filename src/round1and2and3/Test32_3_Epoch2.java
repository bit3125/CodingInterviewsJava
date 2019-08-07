/**epoch1 epoch2写的各有千秋
 * */

package round1and2and3;

import java.util.ArrayList;
import java.util.Stack;

public class Test32_3_Epoch2 {

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<>();
    	if (pRoot==null)
    		return results;
    	
    	Stack<TreeNode> sEven = new Stack<>();
    	Stack<TreeNode> sOdd = new Stack<>();
    	
    	TreeNode curNode;
    	sEven.push(pRoot);
    	ArrayList<Integer> result;
    	
    	while( !sEven.empty() ){ //(!sEven.empty())||(!sOdd.empty()) 
    		result = new ArrayList<>();
    		while(!sEven.empty()){
    			curNode = sEven.pop();
    			result.add(curNode.val);
    			
    			if (curNode.left!=null)
    				sOdd.push(curNode.left);
    			if (curNode.right!=null)
    				sOdd.push(curNode.right);
    		}
    		if (!result.isEmpty())
    			results.add(result);
    		
    		result = new ArrayList<>();
    		while(!sOdd.empty()){
    			curNode = sOdd.pop();
    			result.add(curNode.val);
    			
    			if (curNode.right!=null)
    				sEven.push(curNode.right);
    			if (curNode.left!=null)
    				sEven.push(curNode.left);
    		}
    		if (!result.isEmpty())
    			results.add(result);
    	}
    	
    	return results;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
