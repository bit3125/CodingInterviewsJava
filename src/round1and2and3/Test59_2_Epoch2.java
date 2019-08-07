/**Epoch2较之Epoch1做了改进， 使用index来唯一确定一个数
 * 
 * */

package round1and2and3;

import java.util.Deque;
import java.util.LinkedList;

public class Test59_2_Epoch2 {

	static private class Number{
		private int index;
		private int value;
		
		private Number(int index, int value){
			this.index = index;
			this.value = value;
		}
		
	}
	
	private Deque<Number> maxQ = new LinkedList<>();
	private Deque<Number> dataQ = new LinkedList<>();
	int indexCnt = 0;
	
	public int max(){
		if (!maxQ.isEmpty())
			return maxQ.getFirst().value; 
		
		return Integer.MAX_VALUE;
	}
	
	public void push_back(int n){
		indexCnt++;
		Number newNum = new Number(indexCnt, n);
		while(!maxQ.isEmpty() || maxQ.getLast().value<newNum.value)
			maxQ.removeLast();
		maxQ.addLast(newNum);
		dataQ.addLast(newNum);
	}
	
	public void pop_front(){
		if (dataQ.isEmpty())
			return ;
		
		Number popNum = dataQ.peek();
		if (!maxQ.isEmpty() && maxQ.getFirst().index <= popNum.index)
			maxQ.removeFirst();
		dataQ.removeFirst();
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
