package round1and2and3;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Test32_1 {

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> print = new ArrayList<Integer>();
		if (root==null) //robust
			return print;
		
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode pNode=null;
        
        queue.add(root);
        while(!queue.isEmpty()){
        	pNode = queue.poll();
        	print.add(pNode.val);
        	
        	if (pNode.left!=null)
        		queue.add(pNode.left);
        	if (pNode.right!=null)
        		queue.add(pNode.right);
        }
        
        return print;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		
		
	}

}
