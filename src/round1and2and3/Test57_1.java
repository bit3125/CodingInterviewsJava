package round1and2and3;
import java.util.ArrayList;

public class Test57_1 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (array==null || array.length<=1 ) //robust
        	return al;
        
        int front = 0, rear = array.length-1;
        int s;
        while(front<rear){
        	s = array[front]+array[rear];
        	if (s>sum)
        		rear--;
        	else if(s<sum)
        		front++;
        	else if (s==sum){
        		al.add(array[front]);
        		al.add(array[rear]);
        		return al;
        	}
        }
        return al;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
