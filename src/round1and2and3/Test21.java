package round1and2and3;

/* ���µ��㷨Tn=O(n)��Sn=O(n)���ÿռ任ʱ�䣬�ܱ�֤������ż��������Կռ���򲻷����ı�
 * ����ʹ���������ac
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
//		while( pFront<pBack ){ // ֻ��Ҫ����߽��������ɣ���Ϊ���һ����������Խ�緢��
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

///*�����㷨�������¼��裺
// * ���������ɸ���ż����ɣ�-��=ż����������������
// * ---=====----=====---====
// * ���������α꣬pFrontָ���һ��ż���εĵ�һ��ż����pBackָ���һ��ż���κ�ĵ�һ�������εĵ�һ������
// * Ȼ�󽻻��������α��ϵ�����������ʵ������Ų��ǰ����
// * ����㷨�����ܱ�֤������ż����֮�����Դ��򲻷����ı�
// * �ұȽ��鷳��ͬ����Ч��ʹ��ͷβ�����α겻�����м俿£�ķ���˼·����
// * 
// * ʹ�����¼����߽��⣺
// * 1. ---===---
// * 2. ��
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
//		while(pFront<len && array[pFront]%2!=0){//��pFront��λ�ڵ�һ��ż���εĵ�һ��ż����
//			pFront++;
//		}
//		pBack=pFront+1;//��ʼ��Ϊָ��pFront�ĺ�һλ,����һ��ż���κ�ĵ�һ�������εĵ�һ�������ϣ���һ�����ڣ�
//
//		/*
//		 * pBack��ʼ����ʱ�����pFront���棬
//		 * ������Զ��pFront���棬�������ܵ�ǰ��ȥ�����غϡ�
//		 * pBack��ÿ��while��ʼ��ʱ��ǰ��Ķ��ǵ�һ��ż����
//		 * */
//		//body
//		while(pBack<len){//pBackǰ����ǵ�һ��ż���Σ�pBackԽ��˵���������
//			
//			while(pBack<len && array[pBack]%2!=1){//��pBack��λ�ڵ�һ��ż���κ�ĵ�һ�������εĵ�һ��������
//				pBack++;
//			}//while
//			if (pBack<len){//pBackδԽ�磬��Ŀ������
//				//swap
//				tmp = array[pFront];
//				array[pFront] = array[pBack];
//				array[pBack] = tmp;
//				
//				//step forward
//				pFront++;//��pFront��λ�ڵ�һ��ż���εĵ�һ������
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
