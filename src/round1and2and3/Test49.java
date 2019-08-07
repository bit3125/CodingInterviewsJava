package round1and2and3;

public class Test49 {

	/**算法思路：使用类“素数筛法”
	 * 不可行，因为index的大小远超于内存可用空间，得另觅他法
	 * */
//	public static int MAXSIZE = 10000;
//	private boolean[] isPrime = new boolean[MAXSIZE];
//	private boolean[] isUgly = new boolean[MAXSIZE];
//	private int[] primes = new int[MAXSIZE];
//	private int[] uglys = new int[MAXSIZE];
//	private int primeSize = 0;
//	private int uglySize = 0;
//
//	public int GetUglyNumber_Solution(int index) {
//		if (index - 1 < 0) // robust
//			return -1;
//		else if (index - 1 > MAXSIZE - 1)
//			return -2;
//
//		if (uglySize != 0)
//			return uglys[index - 1];
//
//		// init
//		getPrimes();
//		for (int i = 0; i < isUgly.length; i++)
//			isUgly[i] = true;
//		isUgly[0] = false;
//		isUgly[1] = true;
//
//		// mark uglys
//		for (int i = 3; i < primeSize; i++) { // ***bug:i < primes.length
//			// {2,3,5,7,...}
//			// System.out.println(primes[i]);//***debug
//			for (int j = primes[i]; j < isUgly.length; j += primes[i]) {// ***bug:int
//																		// j =
//																		// i*i
//				isUgly[j] = false;
//			}
//		}
//
//		// save uglys
//		for (int i = 0; i < isUgly.length; i++) {
//			if (isUgly[i]) {
//				uglys[uglySize] = i;
//				uglySize++;
//			}
//		}
//
//		return uglys[index - 1];
//	}
//
//	public void getPrimes() {
//		if (primeSize != 0)
//			return;
//
//		for (int i = 0; i < isPrime.length; i++)
//			isPrime[i] = true;
//		isPrime[0] = false;
//		isPrime[1] = false;
//
//		for (int i = 2; i < isPrime.length; i++) {
//			if (!isPrime[i])
//				continue;
//			// else
//			primes[primeSize] = i;
//			primeSize++;
//			for (int j = i * i; j < isPrime.length; j += i)
//				isPrime[j] = false;
//		}
//	}
//
//	public static void main(String[] args) {
//		// TODO 自动生成的方法存根
//		Test49 test = new Test49();
//		int ugly = test.GetUglyNumber_Solution(1);
//
//		// for (int i = 0; i < test.primeSize; i++) {
//		// System.out.println(test.primes[i]);
//		// }
//		System.out.println(ugly);
//
//		for (int i = 0; i < test.uglySize; i++) {
//			System.out.println(test.uglys[i]);
//		}
//	}
	
	
	/**算法思路：使用的是剑指offer上的算法
	 * */
	public static int MAXSIZE = 5000;
	
    public int GetUglyNumber_Solution(int index) {
    	if (index<=0)
    		return 0;
    	
    	int[] bases = {2,3,5};
    	int[] mins = new int[3];
    	int[] boundIdxs = new int[3];
    	int[] uglys = new int[MAXSIZE];
    	int size;
    	int uglyCur, min;
    	
    	//init
    	uglys[0] = 1;
    	for (int i=0;i<bases.length;i++){
    		boundIdxs[i] = 0;
    	}
    	size = 1;
    	
    	//cal
    	while(size<index){
    		for (int i=0;i<3;i++){//逐base
        		for (int j=boundIdxs[i];j<size;j++){//逐ugly
        			uglyCur = uglys[j]*bases[i];
        			if (uglyCur>uglys[size-1]){
        				mins[i] = uglyCur;
        				boundIdxs[i] = j;
        				break;
        			}
        		}
        	}
        	min = min(mins);
        	uglys[size] = min;
        	size++;
    	}
    	
        return uglys[index-1];
    }
    
    public int min(int[] mins){
    	int min = mins[0];
    	for (int i=0;i<mins.length;i++){
    		if (mins[i]<min)
    			min = mins[i];
    	}
    	return min;
    }
	
	public static void main(String[] args) {
		int index = 1500;
		
		
		Test49 test = new Test49();
		int ugly = test.GetUglyNumber_Solution(index);
	}

}
