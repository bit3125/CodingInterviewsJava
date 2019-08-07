package round1and2and3;

public class Test07 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	if (pre==null || in==null || pre.length==0 || in.length==0) //robust
    		return null;
    	
    	return reConstructCore(pre, in, 0, pre.length, 0, in.length);
    }
    
    public TreeNode reConstructCore(int[] pre, int[] in, 
    		int startPre, int endPre, int startIn ,int endIn){
    	
    	if (endPre-startPre != endIn-startIn) //robost 
    		return null;
    	if (startPre>=endPre||startIn>=endIn) //递归出口
    		return null;
//    	else if (endPre-startPre==1){ //单节点子树时优化速度
//    		TreeNode pRoot = new TreeNode(pre[startPre]);
//    		return pRoot;
//    	}
    	//else 至少有一个节点
    	
    	int rootIdxAtPre = startPre;
    	int rootVal = pre[rootIdxAtPre];
    	int rootIdxAtIn = startIn;
    	while(in[rootIdxAtIn]!=rootVal){
    		rootIdxAtIn++;
    	}
    	int leftTreeCnt = rootIdxAtIn-startIn;
    	
    	TreeNode pRoot = new TreeNode(rootVal);
    	pRoot.left = reConstructCore(pre, in, startPre+1, startPre+1+leftTreeCnt, startIn, rootIdxAtIn);
    	pRoot.right = reConstructCore(pre, in, startPre+1+leftTreeCnt, endPre, rootIdxAtIn+1, endIn);
    	
    	return pRoot;
    }
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
