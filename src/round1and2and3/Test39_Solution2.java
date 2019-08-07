package round1and2and3;

public class Test39_Solution2 {

	/**Ëã·¨¶ş£º
	 * 
	 * */
	public int MoreThanHalfNum_Solution(int [] array) {
		if (array==null || array.length==0) //robust
			return 0;
		
		int idx=0, cnt=0;
		int curNum = -1;
		for (int i=0;i<array.length;i++){
			if (cnt==0){
				curNum=array[i];
				cnt++;
			}else{//cnt!=0
				if (curNum == array[i])
					cnt++;
				else
					cnt--;
			}
		}
		
		//check
		cnt=0;
		for (int i=0;i<array.length;i++){
			if (array[i]==curNum)
				cnt++;
		}
		int mid = array.length/2;
		if (cnt<=mid)
			return 0;
		
		return curNum;
	}
	
	
	public static void main(String[] args) {
		int[] array = {1,2,3,2,2,2,5,4,2,};
		Test39_Solution2 test = new Test39_Solution2();
		System.out.println(test.MoreThanHalfNum_Solution(array));;
		
	}

}
