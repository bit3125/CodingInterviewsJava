package round1and2and3;

public class Test56_2_Epoch2 {

	public int findNumberAppearingOnce(int[] data){
		if (data==null || data.length==0)
			return -1;
		
		int bitSum;
		int target = 0;
		for (int base = 1,i=0;i<32;i++,base <<= 1){
			bitSum = 0;
			for (int n : data)
				bitSum += (n&base)==0?0:1;
			if (bitSum%3!=0)
				target += base;
		}
		
		return target;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(Integer.MIN_VALUE-1);
	}

}
