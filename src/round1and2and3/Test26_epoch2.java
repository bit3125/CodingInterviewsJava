/**算法分析：时间复杂度O(n*m), n为root1节点数，m为root2节点数
 * 
 * 关于子函数递归出口的推导：画真值表如下
 * 
 * root1==null root2==null hasTopSubstructure
 * 1			1			1
 * 0			1			0
 * 1			0			1
 * 0			0			?
 * 
 * */

package round1and2and3;

public class Test26_epoch2 {

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {//root1树中是否含有root2树结构
		if (root2==null) //牛客示例中，root2空树的示例返回false。这里在源头处给予截住，不能放在子函数中，因为子函数必定遍历到空节点，是true的情况
			return false;
		if (root1==null)
			return hasTopSubstructure(root1, root2);
		
		//else : root1!=null
		return hasTopSubstructure(root1, root2) 
				||hasTopSubstructure(root1.left, root2) 
				||hasTopSubstructure(root1.right, root2);
	}
	
	public boolean hasTopSubstructure(TreeNode root1, TreeNode root2){//root1树的`顶部`是否含有root2树的结构
		if (root1==null)
			return root2==null;
		else if (root2==null)
			return true;
		
		//else: root1!=null && root2!=null
		return (root1.val==root2.val && hasTopSubstructure(root1.left, root2.left) && hasTopSubstructure(root1.right, root2.right));
	}

	public static void main(String[] args) {

	}

}
