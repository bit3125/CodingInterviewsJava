package round1and2and3;

import java.util.ArrayList;
import java.util.Stack;

public class Test32_3 {
	/* 此为最佳解法
	 * 免去了逆序的时间开销
	 * */
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList< ArrayList<Integer> > print = new ArrayList< ArrayList<Integer> >();
    	if (pRoot==null) //robust
			return print;
			
        TreeNode pNode=null, pSon=null;
        Stack<TreeNode> stack1 = new Stack<TreeNode>(), stack2 = new Stack<TreeNode>();
        Stack<TreeNode> stackCur, stackNext;
        ArrayList<Integer> row ;
        boolean isOdd;
        
        isOdd = true;
        stack1.push(pRoot);
        while( !(stack1.empty() && stack2.empty()) ){
        	row = new ArrayList<Integer>();
        	stackCur = isOdd?stack1:stack2;
        	stackNext = isOdd?stack2:stack1;

        	while(!stackCur.empty()){
        		pNode = stackCur.pop();
            	row.add(new Integer(pNode.val));
            	
            	pSon = isOdd?pNode.left:pNode.right;
            	if (pSon!=null)
            		stackNext.push(pSon);
            	pSon = isOdd?pNode.right:pNode.left;
            	if (pSon!=null)
            		stackNext.push(pSon);
        	}
        	
        	print.add(row);
        	isOdd = !isOdd;
        }
        
        return print;
	}
	
//	/* 此解法在偶数层调用逆序，时间复杂度上非最佳
//	 * */
//	
//    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
//    	ArrayList< ArrayList<Integer> > print = new ArrayList< ArrayList<Integer> >();
//    	if (pRoot==null) //robust
//			return print;
//			
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        TreeNode pNode=null;
//        int curLayerCnt, curLayerNum, nextLayerNum;
//        ArrayList<Integer> row = new ArrayList<Integer>();
//        boolean flag;
//        
//        flag = false;
//        queue.add(pRoot);
//        curLayerCnt = 0;
//        nextLayerNum = 0;
//        curLayerNum = 1;
//        while(!queue.isEmpty()){
//        	pNode = queue.poll();
//        	row.add(new Integer(pNode.val));
//        	curLayerCnt++;
//        	
//        	if (pNode.left!=null){
//        		queue.add(pNode.left);
//        		nextLayerNum++;
//        	}
//        	if (pNode.right!=null){
//        		queue.add(pNode.right);
//        		nextLayerNum++;
//        	}
//        	
//        	if (curLayerCnt==curLayerNum){
//        		if (flag){
//        			Collections.reverse(row);
//        		}
//        		print.add(row);
//        		row = new ArrayList<Integer>();
//        		curLayerCnt = 0;
//        		curLayerNum = nextLayerNum;
//        		nextLayerNum = 0;
//        		flag = !flag;
//        	}
//        }
//        
//        return print;
//    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		boolean b = true;
		System.out.println();
	}

}
