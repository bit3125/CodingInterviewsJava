package round1and2and3;

public class Test43 {

    public int NumberOf1Between1AndN_Solution(int n){
    	if (n<=0)
    		return 0;//牛客是0
    	//以下拿1234举例
    	int cntTotal = 0;
    	int cntCur = 0;
    	int base = 10, basePrev = 1;
    	int digitCur = 0;
    	int remainder;
    	while(basePrev<=n){
    		remainder = n%base;
    		cntCur = n/base*(basePrev);//先计算当前位在1~1000内的出现1次数
    		digitCur = remainder/(basePrev);//计算当前位的数值
    		//然后计算1001~1234区间内当前位出现1的次数
    		if (digitCur ==0)
    			;
    		else if (digitCur == 1){//若是1，说明这个cycle走了一部分了
    			cntCur += remainder%(basePrev)+1;
    		}else if (digitCur >= 2){//若是2，说明这个cycle全走完了
    			cntCur += basePrev;
    		}
    		cntTotal += cntCur;//两段区间中当前位出现1的次数累加起来
    		base *= 10;
    		basePrev *= 10;
    	}
    	
    	return cntTotal;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test43 test = new Test43();
		int n = 1;
		System.out.println(test.NumberOf1Between1AndN_Solution(n));
	}

}
