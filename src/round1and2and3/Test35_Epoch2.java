package round1and2and3;

import structures.RandomListNode;

public class Test35_Epoch2 {

    public RandomListNode Clone(RandomListNode pHead){
    	if (pHead==null)
    		return null;
    	
    	RandomListNode pCur = pHead, pCurNew;
    	RandomListNode newNode, newHead;
    	
    	//create new nodes
    	while(pCur!=null){
    		newNode = new RandomListNode(pCur.label);
    		newNode.next = pCur.next;
    		pCur.next = newNode;
    		
    		pCur = pCur.next.next;
    	}
    	
    	//mark sibling
    	pCur = pHead;
    	while(pCur!=null){
    		pCur.next.random = pCur.random==null?null:pCur.random.next;//***debug
    		pCur = pCur.next.next;
    	}
    	
    	//split
    	newHead = pHead.next; 
    	pCurNew = newHead;
    	pCur = pHead;
    	while(pCur!=null){
    		pCur.next = pCur.next.next;
    		pCurNew.next = pCurNew.next==null?null:pCurNew.next.next;//***bug
    		
    		pCur = pCur.next;
    		pCurNew = pCurNew.next;
    	}
    	
    	return newHead;
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
    
	public static void main(String[] args) {
		Test35_Epoch2 test =new Test35_Epoch2();
		RandomListNode pHead = test.creatList(5);
		RandomListNode pHeadNew;
		pHeadNew = test.Clone(pHead);
		
		test.printList(pHead);
		System.out.println();
		test.printList(pHeadNew);
	}

}
