/**Epoch1使用的是基于普通的二分查找
 * Epoch2使用的是基于寻找边界的二分查找
 * Epoch2的思路更清晰！好顶赞！
 * 
 * */

package round1and2and3;

public class Test53_1_Epoch2 {

    public int GetNumberOfK(int[] array , int k) {
        if (array==null || array.length==0)
        	return 0;
        
        int leftIdx = findBoundary(array, k, 'l');
        int rightIdx = findBoundary(array, k, 'r');
        
        return (leftIdx==-1 || rightIdx==-1)?0:rightIdx-leftIdx+1;
    }
    
    public int findBoundary(int[] array, int target, char mode){
    	if (mode=='l'){
    		if (array[0]==target)
    			return 0;
    	}else if (mode=='r'){
    		if (array[array.length-1]==target)
    			return array.length-1;
    	}
    	
    	int front = 0; //point to the left section
    	int rear = array.length-1; //point to the right section
    	int mid;
    	while(rear-front>1){
    		mid = (front+rear)/2;
    		if (mode=='l'){
    			if (array[mid]>=target){
    				rear = mid;
    			}else
    				front = mid;
    		}else if (mode=='r'){
    			if (array[mid]<=target){
    				front = mid;
    			}else //array[mid]>target
    				rear = mid;
    		}
    	}
    	
    	//return -1 if not found
    	return ( mode=='l'?(array[rear]==target?rear:-1):(array[front]==target?front:-1) );
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
