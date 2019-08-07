/**Epoch2�������㷨��Ҫ����ά�������������洢ugly�ļ����������������Sn����ȫû�б�Ҫ
 * ���⻹�ǽ�ָoffer�ϵ��㷨д�ĺã�Epoch1)
 * ��Ȼ����һ�������ظ����㿪����������Ȼ��On��Tn�Լ�����Queue��Sn
 * */

package round1and2and3;

import java.util.LinkedList;
import java.util.Queue;

public class Test49_Epoch2 {

    public int GetUglyNumber_Solution(int index) {
    	if (index<=0)
    		return 0;
    	
    	//init
    	int[] bases = new int[]{2,3,5}; 
    	int[] uglys = new int[index];
    	uglys[0] = 1;
    	int uglyCnt = 1;
    	//init qs
    	Queue<Integer>[] qs = new Queue[3];
    	for (int i=0;i<qs.length;i++){
    		qs[i] = new LinkedList<Integer>();
    	}
    	updateQueues(qs, bases, 1);
    	
    	//search for target uglyNum
    	while(uglyCnt<uglys.length){ 
    		uglys[uglyCnt] = findNewUgly(qs, uglys[uglyCnt-1]); //***bug:uglys[uglyCnt++] = findNewUgly(qs, uglys[uglyCnt-1]),����uglyCnt++�����ڸ�ֵ֮ǰ�������
    		uglyCnt++;
    		updateQueues(qs, bases, uglys[uglyCnt-1]);
    	}
    	
    	return uglys[uglys.length-1];
    }
    
    /**�ҵ��µ�Ŀ������������Ƴ�����
     * */
    public int findNewUgly(Queue<Integer>[] qs, int maxBound){
    	//�϶����ٻ���һ������������
    	int minValue = Integer.MAX_VALUE;
    	Queue<Integer> targetQ = null;
    	for (Queue<Integer> q : qs){
    		int curNum = q.peek();
    		while (curNum==maxBound){ //���ֻ����һ��
    			q.poll();
    			curNum = q.peek();
    		}
    		if (curNum>maxBound && curNum<minValue){
    			targetQ = q; 
    			minValue = curNum;
    		}
    	}
    	
    	targetQ.poll();
    	return minValue;
    }
    
    //������и����µĳ���
    public void updateQueues(Queue<Integer>[] qs,int[] bases, int newUglyNum){
    	for (int i=0;i<bases.length;i++)
    		qs[i].offer(newUglyNum*bases[i]);
    }
	
	public static void main(String[] args) {
		Test49_Epoch2 t = new Test49_Epoch2();
		int index = 7;
		t.GetUglyNumber_Solution(index);
	}

}
