package round1and2and3;

import java.util.ArrayList;
import java.util.Stack;

public class Test06 {

	/**递归解法
	 * Tn = On, Sn = On（递归栈）
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
//    	if (listNode==null) //递归出口
//    		return;
//    	
//    	printCore(al, listNode.next);
//    	al.add(new Integer(listNode.val));
//    }
	
	/**栈解法
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
    
    /**反转链表解法（就不写了）
     * Tn = On, Sn = O1
     * */

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		
	}

}
