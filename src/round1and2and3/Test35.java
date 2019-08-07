package round1and2and3;

public class Test35 {
	/**���Ž�
	 * Tn=On�� Sn=O1
	 * */
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	public RandomListNode Clone(RandomListNode pHead){
		if (pHead==null) //robust
			return null;
		
		RandomListNode pCur, pTmp, pCurNew, pHeadNew;
		
		//copy list
		pCur = pHead;
		while(pCur!=null){
			pTmp = new RandomListNode(pCur.label);
			pTmp.random = null;
			pTmp.next = pCur.next;
			pCur.next = pTmp;
			
			pCur = pCur.next.next;//***bug:pCur.next
		}
		
		//copy random pointer
		pCur = pHead;
		while(pCur!=null){
			if (pCur.random!=null){//***bug:
				pCur.next.random = pCur.random.next;
			}
			pCur = pCur.next.next;//***bug:�����Ƿ���random��Ҫ�ݽ�pCur
		}
		
		//take apart lists
		pHeadNew = pHead.next;
		pCur = pHead;
		pCurNew = pHeadNew;
		while(pCur!=null){
			pCur.next = pCur.next.next;
			pCurNew.next = pCurNew.next==null?pCurNew.next:pCurNew.next.next;//***bug:����ĩ.next.next�����
			
			pCur = pCur.next;
			pCurNew = pCurNew.next;
		}
		
		return pHeadNew;
	}
	
	public RandomListNode creatList(int range){
		if (range<=0)
			return null;
		
		RandomListNode pHead = new RandomListNode(0);
		RandomListNode pCur=pHead;
		for (int i=1;i<range;i++){
			pCur.next = new RandomListNode(i);
			pCur = pCur.next;
		}
		
		return pHead; 
	}

	public void printList(RandomListNode pHead){
		RandomListNode pCur = pHead;
		while(pCur!=null){
			System.out.println(pCur.label);
			pCur = pCur.next;
		}
	}
	
//	/**ʹ����HashMap���ռ任ʱ��
//	 * Tn=On��Sn=On
//	 * 
//	 * */
//	public RandomListNode Clone(RandomListNode pHead){
//		if (pHead==null)
//			return null;
//		HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<RandomListNode, RandomListNode>();
//    	RandomListNode pHeadNew, pNode, pNodeNew;
//    	
//    	//����ͷ���
//    	pNode = new RandomListNode(-1);
//    	pNode.next = pHead;
//    	pHead = pNode; 
//    	
//    	pHeadNew = new RandomListNode(-1);
//    	pHeadNew.next = null;
//    	
//    	pNode = pHead.next;
//    	pNodeNew = pHeadNew;
//    	while(pNode != null){// pNode��pNodeNew����һλ
//    		pNodeNew.next = new RandomListNode(pNode.label);
//    		pNodeNew.next.next = null;
//    		pNodeNew.next.random = null;
//			hashMap.put(pNode, pNodeNew.next);//�洢�¾�����ڵ��Ӧ��ϵ��map
//    		
//    		pNodeNew = pNodeNew.next;
//    		pNode = pNode.next;
//    	}
//    	
//    	pNode = pHead.next;
//    	pNodeNew = pHeadNew.next;
//    	while(pNode != null){// pNode��pNodeNewͬ��
//    		if (pNode.random!=null){
//    			pNodeNew.random = hashMap.get(pNode.random);
//    		}
//    		
//    		pNode = pNode.next;
//    		pNodeNew = pNodeNew.next;
//    	}
//    	
//    	pHeadNew = pHeadNew.next;
//		return pHeadNew;
//    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Test35 test =new Test35();
		RandomListNode pHead = test.creatList(5);
		RandomListNode pHeadNew;
		pHeadNew = test.Clone(pHead);
		
		test.printList(pHead);
		System.out.println();
		test.printList(pHeadNew);
		
	}
	
	

}
