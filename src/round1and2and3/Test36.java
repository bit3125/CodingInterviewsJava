package round1and2and3;

public class Test36 {

    public TreeNode Convert(TreeNode pRootOfTree) {
    	if (pRootOfTree==null) //递归出口 
    		return null;
    	
    	TreeNode pList, pListPrev, pListNext;
    	
    	pListPrev = Convert(pRootOfTree.left);
    	pListNext = Convert(pRootOfTree.right);
    	
    	//left=prev, right=next
    	/***bug(Huge!):由于concatLists函数的要求是，必须输入的是两个成形的有序双向链表，
    	 * 故将pRoot输入的时候必须清空其左右指针，作为一个成形链表输入，否则会造成环路
    	 */
    	pRootOfTree.left = null;
    	pRootOfTree.right = null;
    	pList = concatLists(pListPrev, pRootOfTree);
    	pList = concatLists(pList, pListNext);

    	return pList;
    }
    
    public TreeNode concatLists(TreeNode pHead1, TreeNode pHead2){
    	/**输入的是两个已经成形的双向有序链表，即：1.中间都有双向指针；2.头尾节点只有单向指针，另一指针未空
    	 * 返回的是链接好后的新双向有序链表，同上
    	 */
    	if (pHead1==null){
    		if (pHead2==null)
    			return null;
    		else
    			return pHead2;
    	}else if (pHead2==null){
    		return pHead1;
    	}//else
    	
    	// find the last node of pHead1
    	TreeNode pCur = pHead1;
    	while(pCur.right!=null)
    		pCur = pCur.right;
    		
    	//join together
    	pCur.right = pHead2;
    	pCur.right.left = pCur;
    	
    	return pHead1;
    }
    
    public TreeNode createBST(int[] vals){
    	if (vals.length==0)//0<start<end<=data.length
    		return null;
    	TreeNode pRoot = null;
    	
    	for (int i=0;i<vals.length;i++){
    		pRoot = createBSTNode(pRoot, vals[i]);
    	}
    	return pRoot;
    }
    
    public TreeNode createBSTNode(TreeNode pRoot, int val){ 
    	// return的是加入完这个节点后的新子树的pRoot
    	if (pRoot==null){//递归出口
    		return new TreeNode(val);
    	}
		
    	if (val<pRoot.val){
    		pRoot.left = createBSTNode(pRoot.left, val);
    	}else{//val>pRoot.val
    		pRoot.right = createBSTNode(pRoot.right, val);
    	}
    	return pRoot;
    }
    

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] vals = {4, 2, 6, 1, 3, 5, 7};
		Test36 test = new Test36();
		TreeNode bst = test.createBST(vals);
		TreeNode list ;
		
		bst.printInOrder();
		System.out.println();
		
		list = test.Convert(bst);
		
		TreeNode pCur = list;
		while(pCur!=null){
			System.out.println(pCur.val);
			pCur = pCur.right;
		}
	}

	
}
