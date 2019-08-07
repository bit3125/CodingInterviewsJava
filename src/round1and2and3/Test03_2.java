package round1and2and3;

public class Test03_2 {

	public boolean duplicate(int[] data, int[] duplication){
		if (data==null || data.length==0)
			return false;
		duplication[0] = duplicateCore(data, 1, data.length);
		return true;
	}
	
//	public int duplicateCore(int[] data, int rangeStart, int rangeEnd){//range[)
//		if (rangeStart==rangeEnd-1)//�ݹ���� 
//			return rangeStart;
//		
//		int rangeMiddle = (rangeStart+rangeEnd)/2;
//		int cntLeft=0;//,cntRight=0;
//		//body
//		for (int i=0;i<data.length;i++){
//			if (data[i]<rangeMiddle)//[rangeStart,rangeMiddle), rangeMiddle-rangeStart��ȡֵ 
//				cntLeft++;
//			else//data[i]>=rangeMiddle //[rangeMiddle,rangeEnd)
////				cntRight++;
//				;
//		}
//		if (cntLeft>rangeMiddle-rangeStart)//�ظ�������ǰ���
//			return duplicateCore(data, rangeStart, rangeMiddle);
//		else//�ظ������ں���
//			return duplicateCore(data, rangeMiddle, rangeEnd);
//		//���͵�β�ݹ飬�ɸ�Ϊѭ�������Ż�
//	}
	
	public int duplicateCore(int[] data, int rangeStart, int rangeEnd){//range[)
		int front = 1;
		int rear = data.length-1;
		int mid;
		while(front<rear){ //���һ��������front==rear
			mid = (front+rear)/2;
			int cnt = 0;
			for (int i=0;i<data.length;i++){
				if (data[i]<=mid)
					cnt++;
			}
			if (cnt>mid-front+1){
				rear = mid;
			}else{
				front = mid+1;
			}
		}
		return front;//front==rear
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Test03_2 test = new Test03_2();
		int[] data = {2,3,5,4,3,2,6,7};
		int[] duplication = new int[1];
		
		test.duplicate(data, duplication);
		System.out.println(duplication[0]);
		Integer i = 10;
		Integer t=10;
		System.out.println(i==t);
	}

}
