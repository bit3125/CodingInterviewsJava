package round1and2and3;

public class Test26 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {// 其实应该叫做hasSubstructure
    	if (root2==null){// robust
    		return false;
    	}
    	if (root1==null){// 递归出口
    		return false;
    	}
    	
    	boolean has = false;
    	
    	// 使用多重分支结构，避免了做不必要的子树遍历，节省开销
    	// 实际上：
    	// has = hasTopSubstructure(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
		if (hasTopSubstructure(root1, root2)){
			has = true;
		}else if (hasTopSubstructure(root1.left, root2)){
			has = true;
		}else if (hasTopSubstructure(root1.right, root2)){
    		has = true;
    	}else{
    		has = false;
    	}
		
    	return has;
    }
	
    public boolean hasTopSubstructure(TreeNode root1, TreeNode root2){
    	
    	// 递归出口
    	if (root2==null){
    		return true;
    	}else if(root1==null){// root2未空root1先空
    		return false;
    	}
    	
    	if ( root1.val!=root2.val ){// 根节点已经匹不上则直接免去了左右子树的递归，节省开销
    		return false;
    	}else{// 否则进一步判断左右子树
    		return hasTopSubstructure(root1.left, root2.left) 
    			&& hasTopSubstructure(root1.right, root2.right); 
    	}
    	
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
	}

}

