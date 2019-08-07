package round1and2and3;

public class Test27_epoch2 {

    public void Mirror(TreeNode root) {
        if (root==null)
        	return ;
        
        Mirror(root.left);
        Mirror(root.right);
        
        //visit
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
