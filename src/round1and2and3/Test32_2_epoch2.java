package round1and2and3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test32_2_epoch2 {

    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	if (pRoot==null)
        	return result;
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	int curCnt, nextCnt;
    	
    	queue.offer(pRoot);
    	curCnt = 1;
    	nextCnt = 0;
    	while(!queue.isEmpty()){
    		ArrayList<Integer> row = new ArrayList<>();
    		while(row.size()<curCnt){
    			TreeNode curNode = queue.poll();
    			row.add(curNode.val);
    			
    			if (curNode.left!=null){
    				queue.offer(curNode.left);
    				nextCnt++;
    			}
    			if (curNode.right!=null){
    				queue.offer(curNode.right);
    				nextCnt++;
    			}
    		}
    		
    		result.add(row);
    		curCnt = nextCnt;
    		nextCnt = 0;
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
