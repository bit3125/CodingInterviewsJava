package round1and2and3;

/* 以下的算法Tn=O(n)，Sn=O(n)，用空间换时间，能保证奇数（偶数）的相对空间次序不发生改变
 * 最终使用这个方法ac
 * */
public class Test21 {
	
	public static void reOrderArray(int[] array){
		int[] odds = new int [array.length];
		int[] evens = new int [array.length];
		
		int j=0, k=0;
		for (int i=0;i<array.length;i++){
			if (array[i]%2==1){
				odds[j]=array[i];
				j++;
			}else{
				evens[k]=array[i];
				k++;
			}
		}
		
		int idx = 0;
		for (int m=0;m<j;m++,idx++){
			array[idx]=odds[m];
		}
		for (int n=0;n<k;n++,idx++){
			array[idx]=evens[n];
		}
		
	}
	public static void main(String[] args) {
//		int[] array = {1,9,5,4,5,3,6,4,5,7,8,2,1,6,79};
//		int[] array = {};
//		int[] array = {2,2,2,1,1};
//		int[] array = {3,5,7,2,2,2,1,1};
//		int[] array = {1,3,5,2,4,6};
		int[] array = {1,3,5,2,4,6,1,3,2,8,1,9};
		reOrderArray(array);

		for (int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}		
	}
	
}

//public class Test21 {
//	
//	public static void reOrderArray(int[] array){
//		int pFront = 0, pBack = array.length-1;
//		int tmp;
//		while( pFront<pBack ){ // 只需要这个边界条件即可，因为这个一定先于数组越界发生
//			while(array[pFront]%2!=0){
//				pFront++;
//			}
//			while(array[pBack]%2!=1){
//				pBack--;
//			}
//			
//			if ( pFront<pBack ){
//				break;
//			}
//			//swap
//			tmp = array[pBack];
//			array[pBack] = array[pFront];
//			array[pFront] = tmp;
//			pFront++;
//			pBack--;
//		}
//	}
//	
//	public static void main(String[] args){
//	
////		int[] array = {1,9,5,4,5,3,6,4,5,7,8,2,1,6,79};
////		int[] array = {};
////		int[] array = {2,2,2,1,1};
////		int[] array = {3,5,7,2,2,2,1,1};
////		int[] array = {1,3,5,2,4,6};
//		int[] array = {1,3,5,2,4,6,1,3,2,8,1,9};
//		reOrderArray(array);
//	
//		for (int i=0;i<array.length;i++){
//			System.out.println(array[i]);
//		}		
//	}
//	
//}

///*以下算法基于以下假设：
// * 数列由若干个奇偶段组成，-奇=偶，类似以下这样子
// * ---=====----=====---====
// * 设置两个游标，pFront指向第一个偶数段的第一个偶数，pBack指向第一个偶数段后的第一个奇数段的第一个奇数
// * 然后交换这两个游标上的数，慢慢地实现奇数挪到前面来
// * 这个算法并不能保证奇数（偶数）之间的相对次序不发生改变
// * 且比较麻烦，同样地效果使用头尾两个游标不断向中间靠拢的方法思路更简单
// * 
// * 使用以下几个边界检测：
// * 1. ---===---
// * 2. 空
// * 3. ===---
// * 4. ---===
// * 5. ---===---===---
// * */

//public class Test21 {
//
//	public static void reOrderArray(int[] array){
//		//declare
//		int len = array.length;
//		int pBack=0, pFront=0;
//		int tmp;
//		
//		//init
//		while(pFront<len && array[pFront]%2!=0){//把pFront定位在第一个偶数段的第一个偶数上
//			pFront++;
//		}
//		pBack=pFront+1;//初始化为指向pFront的后一位,即第一个偶数段后的第一个奇数段的第一个奇数上（不一定存在）
//
//		/*
//		 * pBack初始化的时候就在pFront后面，
//		 * 并将永远在pFront后面，永不会跑到前面去或者重合。
//		 * pBack在每次while开始的时候，前面的都是第一个偶数段
//		 * */
//		//body
//		while(pBack<len){//pBack前面的是第一个偶数段，pBack越界说明排序好了
//			
//			while(pBack<len && array[pBack]%2!=1){//把pBack定位在第一个偶数段后的第一个奇数段的第一个奇数上
//				pBack++;
//			}//while
//			if (pBack<len){//pBack未越界，是目标奇数
//				//swap
//				tmp = array[pFront];
//				array[pFront] = array[pBack];
//				array[pBack] = tmp;
//				
//				//step forward
//				pFront++;//把pFront定位在第一个偶数段的第一个数上
//				pBack++;
//			}//if
//			
//		}//while
//	}
//	
//	public static void main(String[] args) {
////		int[] array = {1,9,5,4,5,3,6,4,5,7,8,2,1,6,79};
////		int[] array = {};
////		int[] array = {2,2,2,1,1};
////		int[] array = {3,5,7,2,2,2,1,1};
////		int[] array = {1,3,5,2,4,6};
//		int[] array = {1,3,5,2,4,6,1,3,2,8,1,9};
//		reOrderArray(array);
//
//		for (int i=0;i<array.length;i++){
//			System.out.println(array[i]);
//		}		
//	}
//
//}
