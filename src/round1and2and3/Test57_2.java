package round1and2and3;
import java.util.ArrayList;
import java.util.LinkedList;

public class Test57_2 {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer> > alal = new ArrayList<ArrayList<Integer> >();
    	LinkedList<Integer> ll = new LinkedList<Integer>(); 
    	if (sum<=1)
    		return alal;
    	
    	int numCur = 1; //***bug:�������У�������0
    	ll.add(new Integer(numCur));
    	int sumCur = numCur;
    	while(ll.get(0).intValue()<=sum/2){
    		//�˿̵�sumCur��al�ǰ�����numCur��
    		if (sumCur>sum){
    			sumCur -= ll.get(0);
    			ll.remove(0);
    			continue;
    		}
    		
			if (sumCur==sum){
				ArrayList<Integer> alTmp = new ArrayList<Integer>(ll);
    			alal.add(alTmp);
			}
    		
			numCur++;
			ll.add(new Integer(numCur));
    		sumCur += numCur;
    	}
    	
    	return alal;
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}
	
}
