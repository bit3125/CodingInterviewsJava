package sort;

public class MergeSort {

	public void mergeSortMain(int[] data){
		if (data==null || data.length==0) //robust
			return ;
		
		int[] copy = new int[data.length];
		mergeSort(data, copy, 0, data.length);
	}
	
	public void mergeSort(int[] data, int[] copy, int start, int end){
		if (start>=end-1) //递归出口
			return ;
		int mid = (start+end)/2;
		mergeSort(data, copy, start, mid);
		mergeSort(data, copy, mid, end);
		merge(data, copy, start, mid, end);
	}/*注意其与quickSort的区别，后者是自顶向下：先partition再递归；前者是自底向上：先递归再merge*/
	
	public void merge(int[] data, int[] copy, int start, int mid, int end){
		if ( !(start<mid && mid<end) ) //robust TODO
			return;
		//declare
		int p1 = start, p2 = mid, p=start;
		for (int i=start;i<end;i++)
			copy[i] = data[i];
		//merge
		while(p1<mid && p2<end){
			if (copy[p1]<=copy[p2]){
				data[p++] = copy[p1++];
			}else{
				data[p++] = copy[p2++];
			}
		}
		while(p1<mid)
			data[p++] = copy[p1++];
		while(p2<end)
			data[p++] = copy[p2++];		
	}
	
	public static void main(String[] args) {
		int[] data = {6,4,8,5,2,3,4,74};
		
		MergeSort ms = new MergeSort();
		ms.mergeSortMain(data);

		for (int i=0;i<data.length;i++){
			System.out.println(data[i]);
		}
	}

}
