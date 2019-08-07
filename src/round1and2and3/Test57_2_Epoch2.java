/**Epoch明显思路+代码更漂亮
 * 
 * */

package round1and2and3;

import java.util.ArrayList;

public class Test57_2_Epoch2 {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<>();
    	if (sum<=0)
    		return results;
    	
    	int front = 1, rear = 1;
    	int curSum = 1;
    	while(rear<=sum/2+1){ //经过分析不用管front与rear的相对关系，肯定不会越界
    		if (curSum==sum){
    			if (front<rear) //至少含有两个数
    				results.add(createResult(front, rear));
    			rear++;
    			curSum += rear;
    		}else if (curSum<sum){
    			rear++;
    			curSum += rear;
    		}else { //curSum>sum
    			curSum -= front;
    			front++;
    		}
    	}
    	
    	return results;
    }
    
    public ArrayList<Integer> createResult(int front, int rear){
    	if (front>rear)
    		return null;
    	
    	ArrayList<Integer> result = new ArrayList<>();
    	while(front<=rear)
    		result.add(front++);
    	return result;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
