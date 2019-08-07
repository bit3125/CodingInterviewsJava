/**�㷨��������WA���㷨�������кܶ�ֵ��˼���ĵط�������˼����Epoch1һ�£�����Ѱ��LastLeftIdxʹ���˶���������˼��
 * ���Ǵ���ĵط�Ҳ������������޷���֤����ȷʵ��BST�����У����޷���֤sequence�Ĺ����ԣ�������ʹ�ö��ֵĻ����ܻ�������ѭ����
 * �ʴ˴�����ʹ��binary search��������ܣ���ȥ��binary search֮�����solution2��
 * 
 * ��Solution2
 * */

package round1and2and3;

public class Test33_Epoch2_Solution1 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null || sequence.length==0)
        	return false;
        
        return isBST(sequence, 0, sequence.length-1);
    }
    
    public boolean isBST(int[] sequence, int front, int rear){//[,]
    	//sequence[rear]Ϊ��
    	if (rear-front<=0) //���ڵ���
    		return true;
    	
    	//else: �ڵ���>=2
    	int LastLeftIdx = findLastLeftIdx(sequence, front, rear);
    	
    	return satisfyLessMore(sequence, front, rear, LastLeftIdx) 
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
    	
    	//sequence[rear] Ϊ����
    	if (sequence[front]>sequence[rear])//��ΪBST��������
    		return front-1;
    	else if (sequence[rear-1]<sequence[rear])//��ΪBST��������
    		return rear-1;
    	
    	//else:��ΪBST�����������Դ���
    	int left = front;
    	int right = rear-1;
    	int mid;
    	while(right-left>1){
    		mid = (left+right)/2;
    		if (sequence[mid]<sequence[rear])
    			front = mid;
    		else if (sequence[mid]>sequence[rear])
    			rear = mid;
    	}
    	
    	return left;
    }
    
    /**�ж����ҵ��ı߽����������������Ļ���lessmore��ϵ�Ƿ����
     * 
     * */
    public boolean satisfyLessMore(int[] data, int front, int rear, int LastLeftIdx){//[,]
    	//�ϲ㺯��isBST��֤��rear-front>=2��ƽ������find��֤��LastLeftIdxȡֵΪ[front-1,rear-1](rearΪ����)
    	
    	for (int i=front;i<=LastLeftIdx;i++){
    		if (data[i]>data[rear])
    			return false;
    	}
    	for (int i=LastLeftIdx+1;i<=rear-1;i++){
    		if (data[i]<data[rear])
    			return false;
    	}
    	
    	return true;
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
