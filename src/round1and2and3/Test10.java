package round1and2and3;

public class Test10 {

//	/**递归解法
//	 * */
//    public int Fibonacci(int n) {
//    	if (n<0) //robust
//    		return -1;
//    	if (n==0)
//    		return 0;
//    	if (n==1)
//    		return 1;
//    	return Fibonacci(n-1)+Fibonacci(n-2);
//    }
	
	/**循环解法
	 * */
	public int Fibonacci(int n){
		if (n<0 || n>39) //robust
			return -1;
    	
    	int[] array = new int[40];
    	array[0]=0;
    	array[1]=1;
    	for (int i=2;i<=n;i++)
    		array[i]=array[i-1]+array[i-2];
		
		return array[n];
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
