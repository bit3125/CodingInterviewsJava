/**Epoch2��ͷ����������ʹ�õķ�������ȱ�ݵ�
 * ��ʹ��value��ֵ�޷�Ψһȷ��һ��������һ��������value��������һ����޷������ˣ�����ɺܶ��鷳
 * ��ʹ��һ��Ψһ��index��ȷ���ǱȽϺõ�
 * �ʴ˴���Epoch1�㷨����ȱ�ݵ�
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
			//�������ǵ�ǰ�����Ԫ�أ����psbMax��pop���������ǵ�ǰ�����ͱ�psbMax��pop��
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
