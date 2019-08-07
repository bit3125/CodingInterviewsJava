package round1and2and3;

public class Test55_2 {

	/**算法思路：写在书上了
	 * */
    public boolean IsBalanced_Solution(TreeNode root) {
    	if (root==null)
    		return true;//牛客示例true
    	depthOfTree(root);
    	
    	return isBalancedCore(root);
    }
    
    public boolean isBalancedCore(TreeNode root){
    	if (root==null)
    		return true;
    	int leftDepth = root.left==null?0:root.left.val;
    	int rightDepth = root.right==null?0:root.right.val;
    	
    	return ( abs(leftDepth-rightDepth)<=1 ) && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    
    public int depthOfTree(TreeNode root){
    	if (root==null) //递归出口 
    		return 0;
    	
    	root.val = Integer.max(depthOfTree(root.left), depthOfTree(root.right))+1;
    	return root.val;
    }
    
    public int abs(int n){
    	return n>=0?n:-n;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
