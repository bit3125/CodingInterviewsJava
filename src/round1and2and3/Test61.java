package round1and2and3;

import java.util.Arrays;

public class Test61 {

    public boolean isContinuous(int [] numbers) {
    	if (numbers==null || numbers.length==0)
    		return false;
    	
    	Arrays.sort(numbers);
    	int idx = 0;
    	int zeroCnt = 0;
    	int dist;
    	
    	while(numbers[idx]==0){
    		idx++;
    	}
    	zeroCnt = idx;
    	while(idx<numbers.length-1){
    		dist = numbers[idx+1]-numbers[idx];
    		if (dist==0)
    			return false;
    		zeroCnt -= dist-1;
    		if (zeroCnt<0)
    			return false;
    		idx++;
    	}

    	return true;
    }
	
	public static void main(String[] args) {
		System.out.println();
		
	}

}
