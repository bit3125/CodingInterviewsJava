package round1and2and3;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    
    public static ListNode createLinkList(int maxSize){
		/* maxSize>=0
		 * */
		
    	if (maxSize==0){
    		return null;
    	}
    	
		ListNode pHead = new ListNode(0);
		ListNode pPrev = pHead;
		for (int i=1;i<maxSize;i++){
			ListNode node = new ListNode(i);
			node.next=null;
			
			pPrev.next=node;
			pPrev = node;
		}
		
		return pHead;
	}
    
    public static void printLinkList(ListNode pHead){
    	ListNode pPrev = pHead;
		while(pPrev != null){
			System.out.println(pPrev.val);
			pPrev = pPrev.next;
		}
		System.out.println();
    }
    
}