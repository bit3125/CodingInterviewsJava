/**epoch1是用c++写的
 * 
 * */

package round1and2and3;

public class Test18_2 {

    public ListNode deleteDuplication(ListNode pHead){
    	if (pHead==null || pHead.next==null)
    		return pHead;//至少会有两个节点
    	
    	ListNode newHead = new ListNode(-1);
    	newHead.next = pHead;
    	
    	ListNode pPrev, pCur ;
    	pPrev = newHead;
    	pCur = newHead.next;
    	while(pCur!=null && pCur.next!=null){//只有pCur与pCur.next都存在才能进入循环
    		if (pCur.val == pCur.next.val){//发现pCur是重复节点，则连着pCur一起删除
    			while(pCur.next!=null && pCur.val==pCur.next.val)
    				pCur = pCur.next;
    			pCur = pCur.next;//此时pCur停在重复数字节点的最后一位上，让他再向前走一步
    			pPrev.next = pCur;
    		}else{//pCur非重复节点，则往下走
    			pPrev = pCur;
    			pCur = pCur.next;
    		}
    	}
    	
    	return newHead.next;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
