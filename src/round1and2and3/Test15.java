package round1and2and3;

public class Test15 {

    public int NumberOf1(int n) {
    	int cnt = 0;
    	int and = 1;
    	
    	while(and!=0){
    		if ((n&and)==and)
    			cnt++;
    		and = and<<1;
    	}
    	return cnt;
    	
//    	if (sign){
//    		while(n>0){
//    			if ((n&1)==1)
//    				cnt++;
//    			n = n>>1;
//    		}
//    	}else{
//    		int and = 1;
//    		while(and!=0){
//    			if ((n&and)==and)
//    				cnt++;
//    			and = and<<1;
//    		}
//    	}
//    	return cnt;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test15 test = new Test15();
		
		System.out.println(test.NumberOf1(0));
	}

}
