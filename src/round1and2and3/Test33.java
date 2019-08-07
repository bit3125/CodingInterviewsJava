package round1and2and3;

public class Test33 {

	/* 默认左小右大？
	 * */
	public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0) //robust
        	return false;//牛客认为空树不是BST
		return isBST(sequence, 0, sequence.length);
    }
	
	public boolean isBST(int[] sequence, int start, int end){
		if (start==end)
			return true;
		
		boolean is ;
		int rootVal = sequence[end-1];
		int idx = start;
		while(idx<end-1 && sequence[idx]<rootVal){//***bug:idx<end-1才行，因为要扣掉rootVal所在
			idx++;
		}//当 (idx==end || sequence[idx]>pRoot.val) (即idx为理论上左右子树的分界点)时退出
		
		return     moreThan(sequence, idx, end-1, rootVal)//***bug:end-1 
				&& isBST(sequence, start, idx) 
				&& isBST(sequence, idx, end-1);//***bug:end-1
		// 逻辑表达式子式的执行与否，一般是按序执行，若前面已满足后面就不会继续执行
	}
	
	public boolean moreThan(int[] sequence, int start, int end, int rootVal){
		if (start==end)
			return true;
		
		for (int i=start;i<end;i++){
			if (sequence[i]<rootVal)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Test33 test = new Test33();
//		int[] sequence = {5,7,6,9,11,10,8};
		int[] sequence = {1,2};
		System.out.println(test.VerifySquenceOfBST(sequence));
	
	}
	
}
