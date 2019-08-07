package round1and2and3;

public class Test52 {

	/**�㷨˼·������������⣬��������뵽���㷨�ܱ�������ô�Ϳ���ʹ�������첽ָ�뷨��һ������һ�Σ�Ȼ������ͬʱ��
	 * T(m+n) = O(m+n), S(m+n) = O1
	 * */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	int cnt1=0, cnt2=0;
    	ListNode p1=pHead1, p2=pHead2;
    	if (p1==null || p2==null)
    		return null;
    	
    	while(p1!=null){
    		cnt1++;
    		p1 = p1.next;
    	}
    	while(p2!=null){
    		cnt2++;
    		p2 = p2.next;
    	}
    	
    	int dif = cnt1 - cnt2;
    	p1 = dif>=0?pHead1:pHead2;
    	p2 = dif>=0?pHead2:pHead1;
    	dif = dif>=0?dif:-dif;
    	for (int i=0;i<dif;i++)
    		p1 = p1.next;
    	while(p1!=p2){
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	return p1;
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
