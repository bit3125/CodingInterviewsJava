package round1and2and3;

import java.util.ArrayList;
import java.util.Stack;

public class Test06 {

	/**�ݹ�ⷨ
	 * Tn = On, Sn = On���ݹ�ջ��
	 * */
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//    	ArrayList<Integer> al = new ArrayList<Integer>();
//    	
////        if (listNode==null) //robust
////        	return al;
//    	printCore(al, listNode);
//        return al;
//    }
//    
//    public void printCore(ArrayList<Integer> al, ListNode listNode){
//    	if (listNode==null) //�ݹ����
//    		return;
//    	
//    	printCore(al, listNode.next);
//    	al.add(new Integer(listNode.val));
//    }
	
	/**ջ�ⷨ
	 * Tn = On, Sn = On
	 * */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	ArrayList<Integer> al = new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();
    	
//        if (listNode==null) //robust
//        	return al;
        
        while (listNode!=null){
        	stack.push(new Integer(listNode.val));
        	listNode = listNode.next;
        }
        while(!stack.empty()){
        	al.add(stack.peek());
        	stack.pop();
        }
        
        return al;
    }
    
    /**��ת����ⷨ���Ͳ�д�ˣ�
     * Tn = On, Sn = O1
     * */

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		
	}

}
