package round1and2and3;

public class Test39_Epoch2_Solution2 {

	public int MoreThanHalfNum_Solution(int [] array) {
		if (array==null || array.length==0)
			return 0;
		
		int lastIdx = 0;
		int cnt = 1;
		for (int i=1;i<array.length;i++){
			if (array[i]==array[lastIdx])
				cnt++;
			else{
				cnt--;
				if (cnt == 0){
					cnt = 1;
					lastIdx = i;
				}
			}
		}
		
		//check
		cnt = 0;
		for (int i=0;i<array.length;i++){
			if (array[i]==array[lastIdx])
				cnt++;
		}
		if (cnt>array.length/2)
			return array[lastIdx];
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
