package round1and2and3;

public class Test36 {

    public TreeNode Convert(TreeNode pRootOfTree) {
    	if (pRootOfTree==null) //�ݹ���� 
    		return null;
    	
    	TreeNode pList, pListPrev, pListNext;
    	
    	pListPrev = Convert(pRootOfTree.left);
    	pListNext = Convert(pRootOfTree.right);
    	
    	//left=prev, right=next
    	/***bug(Huge!):����concatLists������Ҫ���ǣ�������������������ε�����˫������
    	 * �ʽ�pRoot�����ʱ��������������ָ�룬��Ϊһ�������������룬�������ɻ�·
    	 */
    	pRootOfTree.left = null;
    	pRootOfTree.right = null;
    	pList = concatLists(pListPrev, pRootOfTree);
    	pList = concatLists(pList, pListNext);

    	return pList;
    }
    
    public TreeNode concatLists(TreeNode pHead1, TreeNode pHead2){
    	/**������������Ѿ����ε�˫��������������1.�м䶼��˫��ָ�룻2.ͷβ�ڵ�ֻ�е���ָ�룬��һָ��δ��
    	 * ���ص������Ӻú����˫����������ͬ��
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
    	// return���Ǽ���������ڵ�����������pRoot
    	if (pRoot==null){//�ݹ����
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
		// TODO �Զ����ɵķ������
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
