package round1and2and3;

public class Test28_epoch2 {

    public boolean isSymmetrical(TreeNode pRoot){
        if (pRoot==null)
        	return true;

        return areSymmetrical(pRoot.left, pRoot.right);
    }
    
    public boolean areSymmetrical(TreeNode root1, TreeNode root2){
    	if (root1==null && root2==null)
    		return true;
    	else if (root1==null ^ root2==null)
    		return false;
    	
    	//else : root1!=null && root2!=null
    	return root1.val==root2.val && areSymmetrical(root1.left, root2.right) && areSymmetrical(root1.right, root2.left);
    }
    
}
