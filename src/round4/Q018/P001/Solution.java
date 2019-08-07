/**
 * round1里写的略乱，看这里
 * 其实只有四种情况：
 * 1.只有一个节点，要删除的节点既是头结点也是尾节点
 * 2.非前面case，要删头结点
 * 3.非前面case，要删尾结点
 * 4.others
 * 其中，1与2都能合并为“删除头结点”来处理，只删头结点的话无需连接链表的前后部分所以比较简单
 * ，于是一共有三个分支
 * */

package round4.Q018.P001;

import structures.ListNode;

public class Solution {

    public ListNode DeleteNode(ListNode pListHead, ListNode pToBeDeleted) {
        if (pListHead==null || pToBeDeleted==null)
            return null;

        if (pToBeDeleted == pListHead) { // head node :1 node only or others
            return pToBeDeleted.next;
        } else if (pToBeDeleted.next == null) { // not head node but tail node
            ListNode p = pListHead;
            while (p.next != pToBeDeleted)
                p = p.next;
            p.next = null;
            return pListHead;
        } else { // not head node, not tail node, node num > 1
            pToBeDeleted.val = pToBeDeleted.next.val;
            pToBeDeleted.next = pToBeDeleted.next.next;
            return pListHead;
        }
    }
}
