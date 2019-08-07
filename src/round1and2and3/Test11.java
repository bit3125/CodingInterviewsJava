package round1and2and3;

public class Test11 {

	public int minNumberInRotateArray(int [] array) {
	    if (array==null || array.length==0)
	    	return 0;
		
	    int start = 0, end = array.length-1; //[,]
	    int mid;
	    
	    if (array[start]<array[end]) //�������1����ת0λ����ת���飨��ͨ˳�����飩
	    	return array[start];
	    
	    while(end-start>1){//��������ֲ��Ҳ�һ�� 
			mid = (start+end)/2;
			
			//�������2
			if (array[start]==array[mid] && array[mid]==array[end]){//����������ָ��ָ�����ȫ�ȵ����
				//�޷�ʹ������ֲ��ң���Ϊ�޷�ȷ�����׷ֽ������һ���У����˻�Ϊ���Բ���
				while(start<end){
					if (array[start]>array[start+1]){
						return array[start+1];
					}
					start++;
				}
				return array[end];//��������û�ҵ���˵����ͷ��β����һ������������returnһ��
			}
			//else ֻ���ܳ���array[mid]==array[start]��array[mid]==array[end]�������������ȫ��
			//��ô�������ж�������Ҫȡ�ȣ���Ϊ������������ȵ�ʱ��˵�����ǵ���һ����<�����һ����Ϊ�������У��߽������һ���� 
            if (array[start]<=array[mid]) 
                start = mid;
            else if (array[mid]<=array[start])
                end = mid;
		}
	    return array[end];
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Test11 test = new Test11();
//		int[] array = {4,5,1,2,3,};
//		int[] array = {1,1,1,1,1,1,0,1,1,1,};
//		int[] array = {5,1,2,3,4,};
		int[] array = {1,2,3,4,5};
		System.out.println(test.minNumberInRotateArray(array));
	}

}
