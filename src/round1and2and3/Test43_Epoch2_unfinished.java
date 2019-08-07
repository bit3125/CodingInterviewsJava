package round1and2and3;

public class Test43_Epoch2_unfinished {

    public int NumberOf1Between1AndN_Solution(int n) {
    	if (n<1)
    		return -1;
    	if (n==1)
    		return 1;
    	
    	int cnt = (n%10==1?1:0);
    	int base = 10;
    	while(n>=base){//TODO
    		cnt += (n/base)*(base/10);
    		base *= 10;
    	}

    	
    	//处理余下的位置
    	base = 1;
    	int curDigit;
    	while(base==-1){//TODO
    		curDigit = n/base%10;
    		if (curDigit==0){
    			
    		}else if (curDigit==1){
    			cnt += n%base+1;
    		}else { //curDigit>1
    			cnt += base;
    		}
    	}
    	
//    	//处理最高位o
//    	if (n/(base/10)==1){//最高位为1
//    		cnt += n%(base/10)+1;
//    	}else{//最高位大于1
//    		cnt += base/10;
//    	}
    	
    	return cnt;
    }
	
	public static void main(String[] args) {
		
	}
}
