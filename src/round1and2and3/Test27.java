package round1and2and3;

public class Test27 {

	public void Mirror(TreeNode root) {
		root = getMirror(root);
    }
	
	public TreeNode getMirror(TreeNode root){
		if (root == null){// 递归出口
			return null;
		}
		
		TreeNode pTemp = root.left;
		root.left = getMirror(root.right);
		root.right = getMirror(pTemp);
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
