/**Epoch2的这种算法还要额外维护三个队列来存储ugly的计算结果，带来额外的Sn，完全没有必要
 * 这题还是剑指offer上的算法写的好（Epoch1)
 * 虽然会有一丢丢的重复计算开销，但是依然是On的Tn以及无需Queue的Sn
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
    		uglys[uglyCnt] = findNewUgly(qs, uglys[uglyCnt-1]); //***bug:uglys[uglyCnt++] = findNewUgly(qs, uglys[uglyCnt-1]),这里uglyCnt++好像在赋值之前就完成了
    		uglyCnt++;
    		updateQueues(qs, bases, uglys[uglyCnt-1]);
    	}
    	
    	return uglys[uglys.length-1];
    }
    
    /**找到新的目标丑数并将其移出队列
     * */
    public int findNewUgly(Queue<Integer>[] qs, int maxBound){
    	//肯定至少会有一个数满足条件
    	int minValue = Integer.MAX_VALUE;
    	Queue<Integer> targetQ = null;
    	for (Queue<Integer> q : qs){
    		int curNum = q.peek();
    		while (curNum==maxBound){ //最多只会有一次
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
    
    //向队列中更新新的丑数
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
