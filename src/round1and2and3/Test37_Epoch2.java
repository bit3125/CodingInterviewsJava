package round1and2and3;

public class Test37_Epoch2 {

	String Serialize(TreeNode root) {
    	if (root==null) //没有也行
    		return "#,";
    	
    	StringBuilder sb = new StringBuilder();
    	serializeCore(root, sb);
    	
    	return sb.toString();
    }
    
    void serializeCore(TreeNode root, StringBuilder sb){
    	if (root==null){
    		sb.append("#,");
    		return;
    	}
    		
    	sb.append(String.valueOf(root.val)+",");
    	serializeCore(root.left, sb);
    	serializeCore(root.right, sb);
    }
    
    
    int rootIdx;
    TreeNode Deserialize(String str) {
    	if (str==null || str.length()==0) //TODO
    		return null;
    	
    	String[] nodes = str.split(",");
    	rootIdx = 0;
    	return deserializeCore(nodes);
    }
    
    TreeNode deserializeCore(String[] nodes) {
    	if (rootIdx==nodes.length) //没有应该也行
    		return null;
    	
    	//visit
    	String s = nodes[rootIdx];
    	rootIdx++;
    	if (s.equals("#"))
    		return null;
    	TreeNode pRoot = new TreeNode(Integer.valueOf(s));
    	
		// left & right
    	pRoot.left = deserializeCore(nodes);
    	pRoot.right = deserializeCore(nodes);
    	
    	return pRoot;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
