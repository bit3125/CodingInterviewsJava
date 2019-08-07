/**ACͨ����
 * ���忴��һ�£�д�ı�Epoch1 �����˲��٣�
 * 
 * */

package round1and2and3;

public class Test33_Epoch2_Solution2 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null || sequence.length==0)
        	return false;
        
        return isBST(sequence, 0, sequence.length-1);
    }
    
    public boolean isBST(int[] sequence, int front, int rear){ //[,]
    	//sequence[rear]Ϊ��
    	if (rear-front<=0) //���ڵ���
    		return true;
    	
    	//else: �ڵ���>=2
    	int LastLeftIdx = findLastLeftIdx(sequence, front, rear);
    	
    	return satisfyMore(sequence, front, rear, LastLeftIdx) 
    			&& isBST(sequence, front, LastLeftIdx) 
    			&& isBST(sequence, LastLeftIdx+1, rear-1);
    }
    
    /* 
     * param: front, rear  inclusive
     * return: �����������һ��Ԫ�ص��±꣬��Ϊ����return front-1��
     * LastLeftIdxȡֵΪ[front-1,rear-1](rearΪ����)
     * */
    public int findLastLeftIdx(int[] sequence, int front, int rear){//inclusive
    	//����߽��жϣ��ϲ㺯���ѱ�֤�˽ڵ���>=2
    	for (int i=front;i<rear;i++){
    		if (sequence[i]>sequence[rear])
    			return i-1;
    	}
    	
    	return rear-1;
    }
    
    public boolean satisfyMore(int[] data, int front , int rear, int LastLeftIdx){
    	//data[rear]Ϊ���ڵ�
    	for (int i=LastLeftIdx+1;i<rear;i++){
    		if (data[i]<data[rear])
    			return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		Test33_Epoch2_Solution2 t = new Test33_Epoch2_Solution2();
		int[] sequence = {4,8,6,12,16,14,10};
		boolean is = t.VerifySquenceOfBST(sequence);
		System.out.println(is);
	}

}
