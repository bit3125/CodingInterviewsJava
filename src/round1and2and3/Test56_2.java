package round1and2and3;
//её©мнч
public class Test56_2 {

	public int findNumberAppearingOnce(int[] data){
		if (data==null ||data.length==0) //robust
			return -1;
		
		int target = 0;
		
		int base=1, digitSum=0;
		for (int i=0;i<32;i++){
			digitSum = 0;
			for (int j=0;j<data.length;j++){
				digitSum += (data[j]&base);
			}
			if (digitSum%3!=0)
				target += base;
			base = base << 1;
		}
		
		return target;
	}
	
	
	public static void main(String[] args) {
		int[] data = {1,2,3,1,2,3,4,4,4,79,1,2,3};
		Test56_2 test = new Test56_2();
		int target = test.findNumberAppearingOnce(data);
		System.out.println(target);
	}

}
