package round4.Q018.P002;

import structures.ListNode;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead==null)
            return null;

        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode prev = head, p = head.next;
        while ( p.next !=null ) {
            if (p.val == p.next.val) {
                prev.next = trimThisVal(p);
                p = prev;
                if (p.next == null) //***bug:�п��ܰ�ʣ�µ�����ȫɾ����
                    break;
            }
            prev = p;
            p = p.next;
        }

        return head.next;
    }

    /**ɾ������ֵ��l�ڵ�ֵͬ�Ľڵ㣬����ʣ�µ�����
     * */
    private ListNode trimThisVal(ListNode l) {
        if (l==null)
            return null;

        // else: l!=null
        ListNode p = l;
        while (p!=null && p.val == l.val)
            p = p.next;
        // p==null || p.val!=l.val
        return p;
    }
}