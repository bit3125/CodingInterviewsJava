package round1and2and3;

public class Test11 {

	public int minNumberInRotateArray(int [] array) {
	    if (array==null || array.length==0)
	    	return 0;
		
	    int start = 0, end = array.length-1; //[,]
	    int mid;
	    
	    if (array[start]<array[end]) //特殊情况1：旋转0位的旋转数组（普通顺序数组）
	    	return array[start];
	    
	    while(end-start>1){//这里与二分查找不一样 
			mid = (start+end)/2;
			
			//特殊情况2
			if (array[start]==array[mid] && array[mid]==array[end]){//若出现三个指针指向的数全等的情况
				//无法使用类二分查找（因为无法确定到底分界点在哪一段中），退化为线性查找
				while(start<end){
					if (array[start]>array[start+1]){
						return array[start+1];
					}
					start++;
				}
				return array[end];//遍历完了没找到，说明从头到尾都是一样大的数。随便return一个
			}
			//else 只可能出现array[mid]==array[start]或array[mid]==array[end]的情况，三个非全等
			//那么，两个判断条件都要取等，因为当其中两个相等的时候，说明他们的这一段与<的情况一样，为连续数列，边界点在另一段中 
            if (array[start]<=array[mid]) 
                start = mid;
            else if (array[mid]<=array[start])
                end = mid;
		}
	    return array[end];
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test11 test = new Test11();
//		int[] array = {4,5,1,2,3,};
//		int[] array = {1,1,1,1,1,1,0,1,1,1,};
//		int[] array = {5,1,2,3,4,};
		int[] array = {1,2,3,4,5};
		System.out.println(test.minNumberInRotateArray(array));
	}

}
