/**
 * round2应该写的不对！
 * 主函数也应该递归调用自己才对，否则的话整个Solution只能判断到root1原树的左右子节点的情况
 * 再往下的子结构就判断不出来了
 *
 * */

package round4.Q026;

import structures.TreeNode;

public class Solution {
    /**
     * 判断root1中是否有root2这个子结构
     * */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1==null )
            return false;
        else if (root2==null) // 牛客的示例
            return false;

        return hasSubtreeCore(root1, root2)
                || HasSubtree(root1.left, root2)
                || HasSubtree(root1.right, root2);
    }

    /**
     * 判断当t1根节点与t2根节点重合的时候，t2是否是t1的子结构
     * */
    private boolean hasSubtreeCore(TreeNode t1, TreeNode t2) {
        if (t2==null)
            return true;
        if (t1==null) // t2!=null
            return false;

        // else: t2!=null && t1!=null
        return t1.val==t2.val && hasSubtreeCore(t1.left, t2.left) && hasSubtreeCore(t1.right, t2.right);
    }
}