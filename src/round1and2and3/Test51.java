package round1and2and3;

public class Test51 {

	private int cnt = 0;
	public int MOD = 1000000007;
	public int InversePairs(int[] array) {
		cnt = 0;
		mergeSortMain(array);
		return cnt;
	}

	public void mergeSortMain(int[] data) {
		if (data == null || data.length == 0) // robust
			return;

		int[] copy = new int[data.length];
		mergeSort(data, copy, 0, data.length);
	}

	public void mergeSort(int[] data, int[] copy, int start, int end) {
		if (start >= end - 1) // 递归出口
			return;
		int mid = (start + end) / 2;
		mergeSort(data, copy, start, mid);
		mergeSort(data, copy, mid, end);
		merge(data, copy, start, mid, end);
	}/* 注意其与quickSort的区别，后者是自顶向下：先partition再递归；前者是自底向上：先递归再merge */

	public void merge(int[] data, int[] copy, int start, int mid, int end) {
		if (!(start < mid && mid < end)) // robust TODO
			return;
		// declare 
			//***bug:不同于一般的mergeSort，本题背景下的mergeSort应该是从后往前进行merge！
		int p1 = mid-1, p2 = end-1, p = end-1;
		for (int i = start; i < end; i++)
			copy[i] = data[i];
		// merge
		while (start<=p1 && mid<=p2) {
			if (copy[p1] <= copy[p2]) {
				data[p--] = copy[p2--];
			} else {
				cnt += p2 - mid + 1;
				if (cnt>=MOD)
					cnt = cnt%MOD;
				data[p--] = copy[p1--];
			}
		}
		while (start<=p1)
			data[p--] = copy[p1--];
		while (mid<=p2)
			data[p--] = copy[p2--];
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		int[] data = { 6, 4, 8, 5, 2, 3, 4, 74 };
//		int[] data = { 7, 5, 6, 4 };
		int[] data = {7,5,6,4,11};
//		int[] data = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575 };

		Test51 test = new Test51();
		test.mergeSortMain(data);

		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		System.out.println();
		System.out.println(test.cnt);

	}

}
