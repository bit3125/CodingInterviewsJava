package round1and2and3;

//牛客没有

public class Test53_1 {

	public int GetNumberOfK(int[] array, int k){
		if (array==null || array.length==0) //robust
			return 0;
		
		int leftIdx, rightIdx, cnt;
		leftIdx = getBoundary(array, k, 'l');
		if (leftIdx==-1)
			return 0;
		rightIdx = getBoundary(array, k, 'r');
		return rightIdx-leftIdx+1;
	}
	
	public int getBoundary(int[] data, int target, char lr){
	//robust
		int start = 0, end = data.length-1; //[,]
		int mid;
		
		while (start<=end){
			mid = (start+end)/2;
			if (data[mid]==target){
				if (lr == 'l'){
					if (mid==0 || data[mid-1]!=target)
						return mid;
					else
						end = mid-1;
				}else if (lr=='r'){
					if (mid==data.length-1 || data[mid+1]!=target)
						return mid;
					else start = mid+1;
				}
			}
			else if (data[mid]<target)
				start = mid+1;
			else//if data[mid]>target
				end = mid-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		int[] data = {1,1,2,6,8,9,11,13,20,21};
		int[] data = {21};
		int target = 22;
		Test53_1 test = new Test53_1();
		System.out.println(test.GetNumberOfK(data, target));
	
	}

}
