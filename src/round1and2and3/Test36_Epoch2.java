package round1and2and3;

public class Test36_Epoch2 {
	
	/**��pRootOfTreeΪ���ڵ��BSTת��Ϊ˫������
	 * 
	 * */
    public TreeNode Convert(TreeNode pRootOfTree) {
    	if(pRootOfTree==null) //�������concatLinkedLists�������п���Ϊnull
    		return null;
    	
    	TreeNode result;
    	// left & right
    	
    	TreeNode leftList = Convert(pRootOfTree.left);
    	TreeNode rightList = Convert(pRootOfTree.right);
    	//visit
    	pRootOfTree.left = null;
    	pRootOfTree.right = null;
    	result = concatLinkedLists(leftList, pRootOfTree);
    	result = concatLinkedLists(result, pRootOfTree, rightList);
    				
    	return result;			
    }
    
    public TreeNode concatLinkedLists(TreeNode h1, TreeNode h2){
    	if (h1==null)
    		return h2;
    	else if (h2==null)
    		return h1;
    	
    	//else : h1!=null && h2!=null
    	TreeNode pCur = h1;
    	while(pCur.right!=null)
    		pCur = pCur.right;
    	pCur.right = h2;
    	h2.left = pCur;
    	
    	return h1;
    }
    
    public TreeNode concatLinkedLists(TreeNode h1, TreeNode t1, TreeNode h2){
    	if (h1==null)
    		return h2;
    	else if (h2==null)
    		return h1;
    	
    	//else : h1!=null && h2!=null
    	t1.right = h2;
    	h2.left = t1;
    	
    	return h1;
    }
    
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
