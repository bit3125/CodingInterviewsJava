package round1and2and3;

public class Test33 {

	/* Ĭ����С�Ҵ�
	 * */
	public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0) //robust
        	return false;//ţ����Ϊ��������BST
		return isBST(sequence, 0, sequence.length);
    }
	
	public boolean isBST(int[] sequence, int start, int end){
		if (start==end)
			return true;
		
		boolean is ;
		int rootVal = sequence[end-1];
		int idx = start;
		while(idx<end-1 && sequence[idx]<rootVal){//***bug:idx<end-1���У���ΪҪ�۵�rootVal����
			idx++;
		}//�� (idx==end || sequence[idx]>pRoot.val) (��idxΪ���������������ķֽ��)ʱ�˳�
		
		return     moreThan(sequence, idx, end-1, rootVal)//***bug:end-1 
				&& isBST(sequence, start, idx) 
				&& isBST(sequence, idx, end-1);//***bug:end-1
		// �߼����ʽ��ʽ��ִ�����һ���ǰ���ִ�У���ǰ�����������Ͳ������ִ��
	}
	
	public boolean moreThan(int[] sequence, int start, int end, int rootVal){
		if (start==end)
			return true;
		
		for (int i=start;i<end;i++){
			if (sequence[i]<rootVal)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Test33 test = new Test33();
//		int[] sequence = {5,7,6,9,11,10,8};
		int[] sequence = {1,2};
		System.out.println(test.VerifySquenceOfBST(sequence));
	
	}
	
}
