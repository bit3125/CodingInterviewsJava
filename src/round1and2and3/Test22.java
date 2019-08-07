package round1and2and3;

/* 更好的解法：Tn=On， Sn=O1
 * 不需要额外的数组存储引用
 * 而且只需遍历链表一次（名义上--）
 * 
 * */
public class Test22 {
	public static void main(String[] args){
		int MAXSIZE = 7;
		int k = 7;
		ListNode head = new ListNode(0);
		ListNode pPrev = head;
		for (int i=1;i<MAXSIZE;i++){
			ListNode node = new ListNode(i);
			node.next=null;
			
			pPrev.next=node;
			pPrev = node;
		}
		
		pPrev = head;
		while(pPrev != null){
			System.out.println(pPrev.val);
			pPrev = pPrev.next;
		}
		
		Test22 test = new Test22();
		System.out.println(test.FindKthToTail(head, k));
		
	}
	
	public ListNode FindKthToTail(ListNode head, int k){
		if (head==null || k<=0 ){ //空链表 || k<=0非法
			return null;
		}
		
		ListNode p1 = head, p2;

		p1 = head;
		for (int i=0;i<k-1;i++){
			p1 = p1.next;
			if (p1==null){ // k>链表长度
				return null;
			}
		}

		p2 = head;
		while(p1.next!=null){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}
	
}


//
///* Tn=On,Sn=On
// * 
// * */
//public class Test22 {
//
//	public static ListNode FindKthToTail(ListNode head,int k) {
//		if (head==null){
//			return null;
//		}
//		
//		ArrayList<ListNode> ps = new ArrayList<ListNode>();
//		ListNode pNode = head;
//		int idx ;
//		
//		while(pNode!=null){
//			ps.add(pNode);
//			pNode = pNode.next;
//		}
//		
//		idx = ps.size()-k;
//		if ( idx<0 || idx>=ps.size() ){
//			return null;
//		}
//		
//		return ps.get(idx);
//	}
//	
//	public static void main(String[] args) {
//		int MAXSIZE = 10;
//		int k = 9;
//		ListNode head = new ListNode(0);
//		ListNode pPrev = head;
//		for (int i=1;i<MAXSIZE;i++){
//			ListNode node = new ListNode(i);
//			node.next=null;
//			
//			pPrev.next=node;
//			pPrev = node;
//		}
//		
//		pPrev = head;
//		while(pPrev != null){
//			System.out.println(pPrev.val);
//			pPrev = pPrev.next;
//		}
//		
//		System.out.println(FindKthToTail(head, k).val);
//		
//	}
//
//}
