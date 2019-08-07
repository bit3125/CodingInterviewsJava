package round1and2and3;

//牛客没有

public class Test53_2 {

	public int getMissingNumber(int[] data) {
		if (data==null || data.length==0) //robust
			return -1;

		//declare
		int start = 0, end = data.length - 1; // [,]
		int mid;
		//boundary condition
		if (data[0]!=0)
			return 0;
		else if (data[data.length-1]==data.length-1)
			return data.length;
		//body
		while (start <= end) {
			mid = (start + end) / 2;
			if (data[mid]!=mid)
				end = mid - 1;
			else{// if (data[mid] == mid) {
				if (data[mid+1] != mid+1) //find u!
					return mid+1;
				else //data[mid+1]==mid+1
					start = mid+1;
			}
		}
		return -1;//useless
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		int[] data = {0,1,2,3,5,6,7};
		int[] data = {0};
		Test53_2 test = new Test53_2();
		System.out.println(test.getMissingNumber(data));
	}

}
