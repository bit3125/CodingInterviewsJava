package round1and2and3;

//����ţ����û��
/**�㷨˼·��
 * �Ѷ����ڣ����ճ���˼·��Ҫɾ���ýڵ�pNode������Ҫ�иýڵ�����νڵ��ָ�루�޸���pNext)
 * �����ﲻ��Ѱ��·����pNext��val��ֵ��pNode��Ȼ��ɾ��pNext���ﵽͬ����Ч��
 * 
 * �������������
 * 1.pToBeDeleted==pListHead
 * 		1.1.pListHead.next==null
 * 		1.2.pListHead.next!=null
 * 2.pToBeDeleted!=pListHead
 * 		2.1.pToBeDeleted.next==null
 * 		2.2.pToBeDeleted.next!=null
 * ��Ҫ�ֱ���
 * */
public class Test18_1 {

	public ListNode DeleteNode(ListNode pListHead, ListNode pToBeDeleted){
		if (pListHead==null || pToBeDeleted==null)//robust
			return null;
		
		if (pListHead==pToBeDeleted)//ɾ��ͷ���
			return pListHead.next;//����ͷ����Ƿ���β��㣬������
		//else ��ɾ��ͷ���
		if (pToBeDeleted.next==null){//ɾ��β���
			//ֻ�ܴ�ͷ����
			ListNode pNode = pListHead;
			while(pNode.next.next!=null)
				pNode = pNode.next;
			pNode.next = null;
		}else{//ɾ����β���
			pToBeDeleted.val = pToBeDeleted.next.val;
			pToBeDeleted.next = pToBeDeleted.next.next;
		}
		return pListHead;
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
