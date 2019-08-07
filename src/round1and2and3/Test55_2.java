package round1and2and3;

public class Test55_2 {

	/**�㷨˼·��д��������
	 * */
    public boolean IsBalanced_Solution(TreeNode root) {
    	if (root==null)
    		return true;//ţ��ʾ��true
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
    	if (root==null) //�ݹ���� 
    		return 0;
    	
    	root.val = Integer.max(depthOfTree(root.left), depthOfTree(root.right))+1;
    	return root.val;
    }
    
    public int abs(int n){
    	return n>=0?n:-n;
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
