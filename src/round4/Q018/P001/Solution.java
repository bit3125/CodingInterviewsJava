/**
 * round1��д�����ң�������
 * ��ʵֻ�����������
 * 1.ֻ��һ���ڵ㣬Ҫɾ���Ľڵ����ͷ���Ҳ��β�ڵ�
 * 2.��ǰ��case��Ҫɾͷ���
 * 3.��ǰ��case��Ҫɾβ���
 * 4.others
 * ���У�1��2���ܺϲ�Ϊ��ɾ��ͷ��㡱������ֻɾͷ���Ļ��������������ǰ�󲿷����ԱȽϼ�
 * ������һ����������֧
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
