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
    	if (startPre>=endPre||startIn>=endIn) //�ݹ����
    		return null;
//    	else if (endPre-startPre==1){ //���ڵ�����ʱ�Ż��ٶ�
//    		TreeNode pRoot = new TreeNode(pre[startPre]);
//    		return pRoot;
//    	}
    	//else ������һ���ڵ�
    	
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
		// TODO �Զ����ɵķ������

	}

}
