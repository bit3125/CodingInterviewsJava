/**epoch1����c++д��
 * 
 * */

package round1and2and3;

public class Test18_2 {

    public ListNode deleteDuplication(ListNode pHead){
    	if (pHead==null || pHead.next==null)
    		return pHead;//���ٻ��������ڵ�
    	
    	ListNode newHead = new ListNode(-1);
    	newHead.next = pHead;
    	
    	ListNode pPrev, pCur ;
    	pPrev = newHead;
    	pCur = newHead.next;
    	while(pCur!=null && pCur.next!=null){//ֻ��pCur��pCur.next�����ڲ��ܽ���ѭ��
    		if (pCur.val == pCur.next.val){//����pCur���ظ��ڵ㣬������pCurһ��ɾ��
    			while(pCur.next!=null && pCur.val==pCur.next.val)
    				pCur = pCur.next;
    			pCur = pCur.next;//��ʱpCurͣ���ظ����ֽڵ�����һλ�ϣ���������ǰ��һ��
    			pPrev.next = pCur;
    		}else{//pCur���ظ��ڵ㣬��������
    			pPrev = pCur;
    			pCur = pCur.next;
    		}
    	}
    	
    	return newHead.next;
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
