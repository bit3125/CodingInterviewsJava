package round1and2and3;

public class Test24 {

    public ListNode ReverseList(ListNode head) {
    	ListNode pPrev, pCur, pNext;
    	
    	pPrev = null;
    	pCur = head;
    	while(pCur!=null){
    		pNext = pCur.next;
    		pCur.next = pPrev;
    		
    		// step forward
    		pPrev = pCur;
    		pCur = pNext;
    	}
    	
    	return pPrev;
    }
	
	
//	/* �ݹ鷽��
//	 * */
//	public ListNode ReverseList(ListNode head){
//		/* ����head����֮����������׽������
//		 * */
//		
//		if (head==null){// robust
//			return null;
//		}
//		if (head.next==null){// �ݹ����
//			return head;
//		}
//		
//		ListNode newHead = ReverseList(head.next);
//		head.next.next = head; //head��Ϊ���µ�β���
//		head.next = null; // ԭ�׽ڵ㣨��β�ڵ㣩next����null
//		return newHead;
//	}
//    /* �ɲ������������
//     * 1.������
//     * 2.���ڵ�
//     * 3.˫�ڵ�
//     * 4.��ڵ�
//     * */
    
    public static void main(String[] args) {
		
		int MAXSIZE = 2;
		Test24 test =new Test24();
		
		//create LinkList
		ListNode head = new ListNode(0);
		ListNode pPrev = head;
		for (int i=1;i<MAXSIZE;i++){
			ListNode node = new ListNode(i);
			node.next=null;
			
			pPrev.next=node;
			pPrev = node;
		}
		
		//print LinkList
		pPrev = head;
		while(pPrev != null){
			System.out.println(pPrev.val);
			pPrev = pPrev.next;
		}
		System.out.println();
		
		head = test.ReverseList(head);
		
		pPrev = head;
		while(pPrev != null){
			System.out.println(pPrev.val);
			pPrev = pPrev.next;
		}
		System.out.println();
	}
    
}
