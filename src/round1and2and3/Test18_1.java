package round1and2and3;

//本题牛客中没有
/**算法思路：
 * 难度在于：按照常规思路，要删除该节点pNode，必须要有该节点的上游节点的指针（修改其pNext)
 * 故这里不走寻常路，将pNext的val赋值给pNode，然后删除pNext，达到同样的效果
 * 
 * 共有四种情况：
 * 1.pToBeDeleted==pListHead
 * 		1.1.pListHead.next==null
 * 		1.2.pListHead.next!=null
 * 2.pToBeDeleted!=pListHead
 * 		2.1.pToBeDeleted.next==null
 * 		2.2.pToBeDeleted.next!=null
 * 需要分别考虑
 * */
public class Test18_1 {

	public ListNode DeleteNode(ListNode pListHead, ListNode pToBeDeleted){
		if (pListHead==null || pToBeDeleted==null)//robust
			return null;
		
		if (pListHead==pToBeDeleted)//删除头结点
			return pListHead.next;//无论头结点是否是尾结点，都可以
		//else 非删除头结点
		if (pToBeDeleted.next==null){//删除尾结点
			//只能从头遍历
			ListNode pNode = pListHead;
			while(pNode.next.next!=null)
				pNode = pNode.next;
			pNode.next = null;
		}else{//删除非尾结点
			pToBeDeleted.val = pToBeDeleted.next.val;
			pToBeDeleted.next = pToBeDeleted.next.next;
		}
		return pListHead;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
