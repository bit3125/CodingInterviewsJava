package round1and2and3;

public class Test43 {

    public int NumberOf1Between1AndN_Solution(int n){
    	if (n<=0)
    		return 0;//ţ����0
    	//������1234����
    	int cntTotal = 0;
    	int cntCur = 0;
    	int base = 10, basePrev = 1;
    	int digitCur = 0;
    	int remainder;
    	while(basePrev<=n){
    		remainder = n%base;
    		cntCur = n/base*(basePrev);//�ȼ��㵱ǰλ��1~1000�ڵĳ���1����
    		digitCur = remainder/(basePrev);//���㵱ǰλ����ֵ
    		//Ȼ�����1001~1234�����ڵ�ǰλ����1�Ĵ���
    		if (digitCur ==0)
    			;
    		else if (digitCur == 1){//����1��˵�����cycle����һ������
    			cntCur += remainder%(basePrev)+1;
    		}else if (digitCur >= 2){//����2��˵�����cycleȫ������
    			cntCur += basePrev;
    		}
    		cntTotal += cntCur;//���������е�ǰλ����1�Ĵ����ۼ�����
    		base *= 10;
    		basePrev *= 10;
    	}
    	
    	return cntTotal;
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Test43 test = new Test43();
		int n = 1;
		System.out.println(test.NumberOf1Between1AndN_Solution(n));
	}

}
