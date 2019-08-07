package round1and2and3;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Test32_2 {
	
	public ArrayList< ArrayList<Integer> > Print(TreeNode root){
		ArrayList< ArrayList<Integer> > print = new ArrayList< ArrayList<Integer> >();
		if (root==null) //robust
			return print;
			
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode pNode=null;
        int curLayerCnt, curLayerNum, nextLayerNum;
        ArrayList<Integer> row = new ArrayList<Integer>();
        
        queue.add(root);
        curLayerCnt = 0;
        nextLayerNum = 0;
        curLayerNum = 1;
        while(!queue.isEmpty()){
        	pNode = queue.poll();
        	row.add(new Integer(pNode.val));
        	curLayerCnt++;
        	
        	if (pNode.left!=null){
        		queue.add(pNode.left);
        		nextLayerNum++;
        	}
        	if (pNode.right!=null){
        		queue.add(pNode.right);
        		nextLayerNum++;
        	}
        	
        	if (curLayerCnt==curLayerNum){
        		print.add(row);
        		row = new ArrayList<Integer>();
        		curLayerCnt = 0;
        		curLayerNum = nextLayerNum;
        		nextLayerNum = 0;
        	}
        }
        
        return print;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		
		
	}

}
