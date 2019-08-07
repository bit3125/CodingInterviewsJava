package round1and2and3;

public class Test56_1_Epoch2 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
    	if (array==null || array.length==0)
    		return ;
    	
    	int xor0 = 0, xor1 = 0;
    	for (int n : array)
    		xor0 ^= n;
    	
    	int base = findRightOneBase(xor0);
    	//split into two groups
    	// && search for targets seperately
    	xor0 = 0;
    	xor1 = 0;
    	for (int i=0;i<array.length;i++){
    		if ((array[i]&base)!=0){ //该位为1
    			xor1 ^= array[i];
    		}else
    			xor0 ^= array[i];
    	}
    	num1[0] = xor1;
    	num2[0] = xor0;
    }
    
    public int findRightOneBase(int n){
    	int base = 1;
    	while( (base & n)==0 )
    		base <<= 1;
    	
    	return base;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
