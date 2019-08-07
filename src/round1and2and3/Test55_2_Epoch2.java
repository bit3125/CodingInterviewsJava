package round1and2and3;

public class Test55_2_Epoch2 {

    public boolean IsBalanced_Solution(TreeNode root) {
    	if (root==null)
    		return true;
    	
    	calDepth(root);
    	return isBalanced(root);
    }
    
    public boolean isBalanced(TreeNode root){
    	if (root==null)
    		return true;
    	
    	TreeNode pL = root.left, pR = root.right;
    	return isBalanced(root.left) 
    			&& isBalanced(root.right) 
    			&& Math.abs( (pL==null?0:pL.val) - (pR==null?0:pR.val) )<=1; //***bug:NullPointerError
    }
    
    public int calDepth(TreeNode root){
    	if (root==null)
    		return 0;
    	
    	root.val = Integer.max(calDepth(root.left), calDepth(root.right))+1;
    	return root.val;
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
