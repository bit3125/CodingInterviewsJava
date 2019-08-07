package round1and2and3;

public class Test42 {

    public int FindGreatestSumOfSubArray(int[] array) {
    	if (array==null || array.length==0)
    		return -1;
    	
        int[] sumsOfEndWithThis = new int[array.length];
        sumsOfEndWithThis[0] = array[0];
        for (int i=1;i<array.length;i++)
        	sumsOfEndWithThis[i] = sumsOfEndWithThis[i-1]>=0?(sumsOfEndWithThis[i-1]+array[i]):array[i];
        
    	int max = sumsOfEndWithThis[0];
    	for (int i=0;i<sumsOfEndWithThis.length;i++){
    		if (sumsOfEndWithThis[i]>max)
    			max = sumsOfEndWithThis[i];
    	}
    	
    	return max;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
