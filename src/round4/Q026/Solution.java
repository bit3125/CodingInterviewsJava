/**
 * round2Ӧ��д�Ĳ��ԣ�
 * ������ҲӦ�õݹ�����Լ��Ŷԣ�����Ļ�����Solutionֻ���жϵ�root1ԭ���������ӽڵ�����
 * �����µ��ӽṹ���жϲ�������
 *
 * */

package round4.Q026;

import structures.TreeNode;

public class Solution {
    /**
     * �ж�root1���Ƿ���root2����ӽṹ
     * */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1==null )
            return false;
        else if (root2==null) // ţ�͵�ʾ��
            return false;

        return hasSubtreeCore(root1, root2)
                || HasSubtree(root1.left, root2)
                || HasSubtree(root1.right, root2);
    }

    /**
     * �жϵ�t1���ڵ���t2���ڵ��غϵ�ʱ��t2�Ƿ���t1���ӽṹ
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