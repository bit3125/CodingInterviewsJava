package round1and2and3;

/* 以下为最佳的解法，
 * Tn = On, Sn = O1
 * 
 * */
public class Test23 {
	public static void main(String[] args){
		
	}
	
	public ListNode EntryNodeOfLoop(ListNode pHead){ 
		//init
		ListNode pNode, pCur, pNext;
		int cnt;
		//robust
		if (pHead==null){
			return null;
		}
		
		//body
		// 判断链表中是否存在环，若存在则找到环中一点
		pNode = MeetNode(pHead);
		if (pNode==null){// 不存在环
			return null;
		}//else
		// cnt环中的节点数
		cnt = cntNodesOfCycle(pNode);
		// 寻找环头节点
		return FindHead(pHead, cnt);
	}
	
	public ListNode MeetNode(ListNode pHead){
		/* 存在环则 return 环中的一点
		 * 不存在环则 return null
		 * 
		 * */
		ListNode pFast, pSlow;
		
		pSlow = pHead;
		pFast = pSlow.next;
		
		while(pFast!=null){//pFast先到达链尾
			if (pFast == pSlow){
				return pFast;
			}
			
			pSlow = pSlow.next;
			pFast = pFast.next;
			if (pFast!=null){//再次判断边界 ，若此处==null则进入下一次while的判断后跳出循环
				pFast = pFast.next;//再走一步
			}
		}//while
		
		// 跳出循环，说明pFast到达链尾==null
		return pFast;
	}
	
	public int cntNodesOfCycle(ListNode pNode){
		ListNode pCur = pNode.next;
		int cnt = 1;
		
		while(pCur!=pNode){
			pCur = pCur.next;
			cnt++;
		}
		
		return cnt;
	}
	
	public ListNode FindHead(ListNode pHead, int cnt){
		/* 健壮性保证：输入的链表保证有环，且pFast经过cnt后不会越界
		 * */
		ListNode pFast=pHead, pSlow=pHead;
		
		for (int i=0;i<cnt;i++){
			pFast = pFast.next;
		}
		
		while(pFast!=pSlow){
			pFast = pFast.next;
			pSlow = pSlow.next;
		}
		
		return pFast;
	}
	
//	class ListNode{
//		int val;
//		ListNode next = null;
//		
//		ListNode(int val) {
//			this.val = val;
//		}
//	}
}

/* 以下解法使用HashMap（相当于python的字典），思路较为简单，但是空间复杂度不是很好看
 * Tn = On, Sn = On（HashMap）
 * 
 * */
//public class Test23 {
//	
//	public static void main(String[] args) {
//
//	}
//
//	public ListNode EntryNodeOfLoop(ListNode pHead){ 
//		//只能用ListNode作为key，因为无法得知链表中是否有val相同的不同节点，故不能用val做key
//		HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
//		ListNode pNode = pHead;
//		
//		if (pHead == null){
//			return null;
//		}
//		
//		while(pNode!=null){
//			if (hashMap.containsKey(pNode)){
//				return pNode;
//			}else{
//				hashMap.put(pNode, 1);
//				pNode = pNode.next;
//			}
//		}
//		
//        return null;
//    } 
//	
//	class ListNode {
//		   int val;
//		   ListNode next = null;
//
//		   ListNode(int val) {
//		       this.val = val;
//		   }
//	}
//
//}
//
//


