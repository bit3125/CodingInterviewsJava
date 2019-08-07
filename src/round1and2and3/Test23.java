package round1and2and3;

/* ����Ϊ��ѵĽⷨ��
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
		// �ж��������Ƿ���ڻ������������ҵ�����һ��
		pNode = MeetNode(pHead);
		if (pNode==null){// �����ڻ�
			return null;
		}//else
		// cnt���еĽڵ���
		cnt = cntNodesOfCycle(pNode);
		// Ѱ�һ�ͷ�ڵ�
		return FindHead(pHead, cnt);
	}
	
	public ListNode MeetNode(ListNode pHead){
		/* ���ڻ��� return ���е�һ��
		 * �����ڻ��� return null
		 * 
		 * */
		ListNode pFast, pSlow;
		
		pSlow = pHead;
		pFast = pSlow.next;
		
		while(pFast!=null){//pFast�ȵ�����β
			if (pFast == pSlow){
				return pFast;
			}
			
			pSlow = pSlow.next;
			pFast = pFast.next;
			if (pFast!=null){//�ٴ��жϱ߽� �����˴�==null�������һ��while���жϺ�����ѭ��
				pFast = pFast.next;//����һ��
			}
		}//while
		
		// ����ѭ����˵��pFast������β==null
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
		/* ��׳�Ա�֤�����������֤�л�����pFast����cnt�󲻻�Խ��
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

/* ���½ⷨʹ��HashMap���൱��python���ֵ䣩��˼·��Ϊ�򵥣����ǿռ临�ӶȲ��Ǻܺÿ�
 * Tn = On, Sn = On��HashMap��
 * 
 * */
//public class Test23 {
//	
//	public static void main(String[] args) {
//
//	}
//
//	public ListNode EntryNodeOfLoop(ListNode pHead){ 
//		//ֻ����ListNode��Ϊkey����Ϊ�޷���֪�������Ƿ���val��ͬ�Ĳ�ͬ�ڵ㣬�ʲ�����val��key
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


