package round1and2and3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test32_1_epoch2 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<>();
    	if (root==null)
    		return result;
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	
    	TreeNode curNode;
    	while(!queue.isEmpty()){
    		curNode = queue.poll();
    		result.add(curNode.val);
    		
    		if (curNode.left!=null)
    			queue.offer(curNode.left);
    		if (curNode.right!=null)
    			queue.offer(curNode.right);
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
