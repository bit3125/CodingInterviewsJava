package round1and2and3;

/* 整体思路：
 * 二叉树对称的定义：二叉树与其镜像一样则为对称二叉树
 * 等价命题：（画图发现）该二叉树左右子树互为镜像=>该二叉树与其镜像一样=>则为对称二叉树
 * 
 * 也即，将问题转化为，判断两棵二叉树是否互为镜像
 * 判断互为镜像条件：
 * 1.根节点同值；
 * 2.root1.left与root2.right互为镜像 && root1.right与root2.left互为镜像
 * 
 * 
 * */

public class Test28 {

	boolean isSymmetrical(TreeNode pRoot){
        if (pRoot==null){
        	return true;// 空树竟然是true- -
        }
		return isMirror(pRoot.left, pRoot.right);
    }
	
	public boolean isMirror(TreeNode root1, TreeNode root2){
		/* 用于判断两棵树是否互为镜像
		 * */
		
		//递归出口
		if (root1==null && root2==null){
			return true;
		}else if (root1==null || root2==null){
			return false;
		}//else 二者皆不为空
		
		boolean is = false;
		if (root1.val!=root2.val){
			is = false;
		}else if (!isMirror(root1.left, root2.right)){
			is = false;
		}else if (!isMirror(root1.right, root2.left)){
			is = false;
		}else {
			is = true;
		}
		//is = root1.val==root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left)
		
		return is;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
