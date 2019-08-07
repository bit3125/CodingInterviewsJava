package round1and2and3;

public class Test54 {

	private int cnt = 0;
	private TreeNode target = null;
	private boolean beFound = false;
    TreeNode KthNode(TreeNode pRoot, int k){
    	if (pRoot==null || k<=0)
    		return null;
    	
    	cnt = 0;
    	target = null;
    	beFound = false;
    	searchKthNode(pRoot, k);
    	return target;
    }
    
    void searchKthNode(TreeNode pRoot, int k){
    	if (pRoot == null || beFound)
    		return;
    	
    	searchKthNode(pRoot.left, k);
    	//visit;
    	cnt++;
    	if (cnt==k){
    		target = pRoot;
    		return;
    	}
    	searchKthNode(pRoot.right, k);
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
