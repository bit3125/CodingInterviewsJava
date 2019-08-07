package round1and2and3;

public class Test53_3 {

	public int getNumberSameAsIdndex(int[] numbers){
		if (numbers==null || numbers.length==0) //robust
			return -1;

		//declare
		int start = 0, end = numbers.length - 1; // [,]
		int mid;
		//body
		while (start <= end) {
			mid = (start + end) / 2;
			if (numbers[mid]==mid)
				return mid;
			else if (numbers[mid]<mid)
				start = mid+1;
			else if (numbers[mid]>mid)
				end = mid-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] numbers ={-3,-1,1,3,5};
		
		Test53_3 test = new Test53_3();
		int result = test.getNumberSameAsIdndex(numbers);
		System.out.println(result);
		
	}

}
