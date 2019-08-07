package round1and2and3;
//её©мнч
public class Test63 {

	public int maxProfit(int[] data){
		if (data==null || data.length<=1) //robust
			return -1;
		
		//init
		int[] f = new int[data.length];
		for (int i=0;i<f.length;i++)
			f[i]=0;
		f[0] = 0;
		f[1] = data[1]-data[0];
		
		//body
		for(int i=2;i<f.length;i++){
			int curProfit = data[i]-data[i-1];
			f[i] = f[i-1]>=0?(f[i-1]+curProfit):curProfit;
		}
		
		//search for max
		int maxProfit = f[0];
		for (int i=0;i<f.length;i++)
			if (f[i]>maxProfit)
				maxProfit = f[i];
			
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] data = {9,11,8,5,7,12,16,14};
//		int[] data = {1,2};
		
		Test63 test = new Test63();
		System.out.println(test.maxProfit(data));
	
	}

}
