package round1and2and3;

public class Test25 {
	/* Tn=On, Sn=O1
	 * 此法最佳
	 * */
	public ListNode Merge(ListNode list1,ListNode list2) {
		ListNode pCur1=list1, pCur2=list2;
		ListNode pNewHead, pNewTail;
		
		if (list1==null && list2==null){
			return null;
		}else if(list1==null){
			return list2;
		}else if (list2==null){
			return list1;
		}
		
		// 以下都是针对两表非空的情况进行处理
		// init pNewHead, pNewTail
		if (pCur1.val<pCur2.val){
			pNewHead = pCur1;
			pCur1 = pCur1.next;
			pNewHead.next = null;
		}else{
			pNewHead = pCur2;
			pCur2 = pCur2.next;
			pNewHead.next = null;
		}
		pNewTail = pNewHead;
		
		// body
		while(pCur1!=null && pCur2!=null){
			if (pCur1.val<pCur2.val){
				pNewTail.next = pCur1;
				pNewTail = pNewTail.next;
				pCur1 = pCur1.next;
				pNewTail.next = null;// 及时清空，安全点
				//上上行结束才能执行上行，不然会断链
			}else{
				pNewTail.next = pCur2;
				pNewTail = pNewTail.next;
				pCur2 = pCur2.next;
				pNewTail.next = null;// 及时清空，安全点
			}
		}
		
		while(pCur1!=null){
			pNewTail.next = pCur1;
			pNewTail = pNewTail.next;
			pCur1 = pCur1.next;
			pNewTail.next = null;// 及时清空，安全点
		}
		while(pCur2!=null){
			pNewTail.next = pCur2;
			pNewTail = pNewTail.next;
			pCur2 = pCur2.next;
			pNewTail.next = null;// 及时清空，安全点
		}
		
		return pNewHead;
	}
	
//	/* Tn=On， Sn=On
//	 * 本质：二路归并排序
//	 * 这里要注意的是：
//	 * 1. 无头结点的链表的边界条件
//	 * 2. 做新链表的时候必须深复制不能浅复制，因为两个旧链表需要分别独立地遍历，要保留原有的结构，浅复制的话会出现链表断裂
//	 * 最后发现这个Sn不是很好看，不是最优的算法
//	 * */
//	public ListNode Merge(ListNode list1,ListNode list2) {
//		ListNode pCur1=list1, pCur2=list2;
//		ListNode pNewHead, pNewTail;
//		
//		if (list1==null && list2==null){
//			return null;
//		}else if(list1==null){
//			return list2;
//		}else if (list2==null){
//			return list1;
//		}
//		
//		// 以下都是针对两表非空的情况进行处理
//		// init pNewHead, pNewTail
//		if (pCur1.val<pCur2.val){
//			pNewHead = new ListNode(pCur1.val);
//			pCur1 = pCur1.next;
//		}else{
//			pNewHead = new ListNode(pCur2.val);
//			pCur2 = pCur2.next;
//		}
//		pNewTail = pNewHead;
//		
//		// body
//		while(pCur1!=null && pCur2!=null){
//			if (pCur1.val<pCur2.val){
//				pNewTail.next = new ListNode(pCur1.val);
//				pNewTail = pNewTail.next;
//				pCur1 = pCur1.next;
//			}else{
//				pNewTail.next = new ListNode(pCur2.val);
//				pNewTail = pNewTail.next;
//				pCur2 = pCur2.next;
//			}
//		}
//		
//		while(pCur1!=null){
//			pNewTail.next = new ListNode(pCur1.val);
//			pNewTail = pNewTail.next;
//			pCur1 = pCur1.next;
//		}
//		while(pCur2!=null){
//			pNewTail.next = new ListNode(pCur2.val);
//			pNewTail = pNewTail.next;
//			pCur2 = pCur2.next;
//		}
//		
//		return pNewHead;
//	}

	public static void test(int MAXSIZE1, int MAXSIZE2){
		Test25 test =new Test25();
		ListNode list1, list2, newHead;
		
		//create LinkList
		list1 = ListNode.createLinkList(MAXSIZE1);
		list2 = ListNode.createLinkList(MAXSIZE2);
		
		//print LinkList
		ListNode.printLinkList(list1);
		ListNode.printLinkList(list2);
		
		//merge
		newHead = test.Merge(list1, list2);
		ListNode.printLinkList(newHead);
	}
	
	public static void main(String[] args) {
			
//		test(0, 0);
//		test(0, 1);
//		test(0, 3);
//		test(1, 1);
		test(1, 3);
//		test(3, 3);
	}

}
