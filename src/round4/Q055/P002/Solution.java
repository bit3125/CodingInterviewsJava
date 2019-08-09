package round4.Q055.P002;

import structures.TreeNode;

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        int[] dep = new int[1];
        return isBalancedTree(root, dep);
    }

    public boolean isBalancedTree(TreeNode root, int[] dep) {
        if (root == null) {
            dep[0] = 0;
            return true;
        }

        // left & right
        int[] leftDep = new int[1], rightDep = new int[1];
        boolean leftAndRightIs = isBalancedTree(root.left, leftDep) && isBalancedTree(root.right, rightDep);
        // visit
        dep[0] = Integer.max(leftDep[0], rightDep[0]) + 1;
        return leftAndRightIs && (Math.abs(leftDep[0] - rightDep[0]) <= 1);
    }
}
