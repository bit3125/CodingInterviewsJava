package round1and2and3;

public class Test55_1 {

	private int maxDepth = 0;
    public int TreeDepth(TreeNode root) {
        if (root==null)
        	return 0;
        
        preOrder(root, 0);
        return maxDepth;
    }
    
    public void preOrder(TreeNode root, int curDepth){
    	if (root==null)
    		return;
    	
    	curDepth++;
    	if (curDepth>maxDepth)
    		maxDepth = curDepth;
    	preOrder(root.left, curDepth);
    	preOrder(root.right, curDepth);
    	//回溯:参数传值无需回溯
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
