/**Epoch2回头来看，这里使用的方法是有缺陷的
 * 光使用value的值无法唯一确定一个数，万一有两个等value的数字在一起就无法区分了，会造成很多麻烦
 * 故使用一个唯一的index来确定是比较好的
 * 故此处的Epoch1算法是有缺陷的
 * 
 * */

package round1and2and3;
import java.util.Deque;
import java.util.LinkedList;

public class Test59_2 {

	private Deque<Integer> psbMax = new LinkedList<Integer>();
	private Deque<Integer> queue = new LinkedList<Integer>();
	
	public void push_back(Integer n){
		while(!psbMax.isEmpty()){
			if (psbMax.getLast()<n)
				psbMax.removeLast();
			else
				break;
		}
		psbMax.addLast(n);
		queue.addLast(n);
		
	}
	
	public Integer pop_front(){
		if (queue.isEmpty())
			return null;
		
		Integer curNum = queue.removeFirst();
		if (curNum==psbMax.getFirst())
			//若队首是当前的最大元素，则从psbMax中pop他；若不是当前最大，早就被psbMax给pop了
			psbMax.removeFirst();
		
		return curNum;
	}
	
	public Integer max(){
		return psbMax.getFirst();
	}
	
	public static void main(String[] args) {
		Test59_2 test = new Test59_2();
		int[] data = {2,3,4,2,6,2,5,1};
		for (int i=0;i<4;i++){
			test.push_back(data[i]);
			System.out.println(test.max());
		}
		System.out.println();
		
		test.pop_front();
		System.out.println(test.max());
		test.pop_front();
		System.out.println(test.max());
		test.pop_front();
		System.out.println(test.max());
		test.push_back(data[4]);
		System.out.println(test.max());
	}

}
