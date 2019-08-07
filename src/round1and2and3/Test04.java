package round1and2and3;
import java.util.Arrays;

public class Test04 {

	public boolean Find(int target, int [][] array) {
		if (array==null||array.length==0||array[0].length==0) //robust
			return false;
		
		int rangeUp=0, rangeRight=array[0].length-1;
		int upRightNum ;
		
		while (rangeRight>=0 && rangeUp<=array.length-1){
			//单列||单行 优化为二分查找
			if (rangeUp==array.length-1){
				int[] newArray = Arrays.copyOfRange(array[rangeUp], 0, rangeRight+1);//***bug:copyOfRange:[from,to)
				return binarySearch(target, newArray); //优化为二分查找
			}else if (rangeRight==0){
				int[] newArray = new int[array.length-rangeUp];
					//***bug:[array.length-1-rangeUp].这里是在while的开头进行检查，
					//upRightNum还没有经过检查，故要连着当前的这个数一起进入binarySearch
				for (int i=rangeUp, j=0;i<array.length;i++,j++)
					newArray[j]=array[i][0];
				return binarySearch(target, newArray); //优化为二分查找
			}
			
			//else
			upRightNum = array[rangeUp][rangeRight];
			if (upRightNum==target)
				return true;
			if (target<upRightNum)
				rangeRight--;
			else if (target>upRightNum)
				rangeUp++;
		}
		
		return false;
    }
	
	public boolean binarySearch(int target, int[] data){
		if (data==null||data.length==0) //robust
			return false;
		
		int start=0, end=data.length-1;//[start, end]
		int mid;
		while(start<=end){
			mid=(start+end)/2;//***bug:漏写
			if (data[mid]==target)
				return true;
			else if (target<data[mid]){
				end=mid-1;
			}
			else if (data[mid]<target){
				start=mid+1;
			}
		}
		
		return false;
	}
	
//	public boolean binarySearch(int target, int[] data){
//		for (int i=0;i<data.length;i++){
//			if (data[i]==target)
//				return true;
//		}
//		return false;
//	}
	
//	/**递归算法
//	 * 典型的尾递归，可以优化为循环
//	 * */
//	public boolean Find(int target, int [][] array) {
//		if (array==null||array.length==0||array[0].length==0) //robust
//			return false;
//		
//		return findCore(target, array, 0, array[0].length-1);
//    }
//	public boolean findCore(int target, int[][] array, int rangeUp, int rangeRight){//[up,down],[left,right]
//		if (rangeRight<0 ||rangeUp>array.length-1)//递归出口
//			return false;
//		
//		int upRightNum = array[rangeUp][rangeRight];
//		if(upRightNum==target)//递归出口
//			return true;
//		else if (target<upRightNum)
//			return findCore(target, array, rangeUp, rangeRight-1);
//		else //if (target>upRightNum)
//			return findCore(target, array, rangeUp+1, rangeRight);
//	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test04 test = new Test04();
//		int[][] array = {{1,2,8,9,},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//		int target = 7;
		
		int[][] array = {{1,2,8,9},{4,7,10,13},};
		int target = 7;
		
//		int[][] array = {{1,2,8,9,},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//		int target = 5;
		System.out.println(test.Find(target, array));
	}

}
