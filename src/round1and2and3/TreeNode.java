package round1and2and3;

public class TreeNode {// 其实应该叫BinaryTreeNode
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
    
    public void printInOrder(){
    	printInOrderCore(this);
    }
    
    private static void printInOrderCore(TreeNode pRoot){
    	if (pRoot==null)
    		return;
    	
    	printInOrderCore(pRoot.left);
    	System.out.println(pRoot.val);
    	printInOrderCore(pRoot.right);
    }
}