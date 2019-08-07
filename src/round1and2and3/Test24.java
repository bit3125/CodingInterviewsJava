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
	
	
//	/* 递归方法
//	 * */
//	public ListNode ReverseList(ListNode head){
//		/* 返回head逆序之后的新链表首结点引用
//		 * */
//		
//		if (head==null){// robust
//			return null;
//		}
//		if (head.next==null){// 递归出口
//			return head;
//		}
//		
//		ListNode newHead = ReverseList(head.next);
//		head.next.next = head; //head成为了新的尾结点
//		head.next = null; // 原首节点（新尾节点）next重置null
//		return newHead;
//	}
//    /* 可测试以下情况：
//     * 1.空链表
//     * 2.单节点
//     * 3.双节点
//     * 4.多节点
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
