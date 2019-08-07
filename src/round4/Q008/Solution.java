/**
 * perfect
 * */

package round4.Q008;

import structures.TreeLinkNode;

public class Solution {

    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode==null) // case:pNode==null
            return null;

        if (pNode.right != null) { // 1. has right subtree
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        } else { // 2. has not
            while (pNode.next!=null && pNode != pNode.next.left)
                pNode = pNode.next;
            return pNode.next; // null or pNode.next. case: single node tree
        }
    }
}