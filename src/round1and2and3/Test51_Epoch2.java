/**Epoch1 ���˽�ָoffer�ϵ�˳�򣺵�����������EPoch1��ͷʹ���˴�β��ͷ�Ĺ鲢���򣬺��鷳
 * дEpoch2��ʱ����û��Ҫ�� ������Ȼ���õݼ���˳��Ϳ��ԣ�д����������
 * 
 * */

package round1and2and3;

import java.util.Arrays;

public class Test51_Epoch2 {

	public static final int MOD = 1000000007;
	
    public int InversePairs(int[] array) {
        if (array==null || array.length==0) //TODO
        	return 0;
    	
        int[] copy = new int[array.length];
        return merge(array, copy, 0, array.length);
    }
    
    public int merge(int[] array,int[] copy, int start, int end){ //(,]
    	if (end-start<=1) //�ݹ���ڣ�length<=1������merge
    		return 0;
    	
    	int mid = (start+end)/2;
    	return (merge(array, copy, start, mid) 
    			+ merge(array, copy, mid, end)
    			+ mergeCore(array, copy, start, mid, mid, end)) % MOD; //***bug: ������ȡMOD =��=��
    }
    
    public int mergeCore(int[] array,int[] copy, int s1, int e1, int s2, int e2){ //[,)
    	if (false) //TODO robust
    		return -1;
    	//�ϲ㺯��merge�ĵݹ����������֤������mergeCore���������鳤�ȶ�>=1
    	
    	int cnt = 0;
    	System.arraycopy(array, s1, copy, s1, e2-s1);
    	int p1=s1, p2=s2, p=s1;
    	while(p1<e1 && p2<e2){
    		if (copy[p1]>copy[p2]){
    			cnt += e2-p2;
    			cnt %= MOD;
    			array[p++] = copy[p1++];
    		}else
    			array[p++] = copy[p2++];
    	}
    	while(p1<e1)//list2Ϊ�գ���ʣ�������
    		array[p++] = copy[p1++]; //***bug: array[p++] = array[p1++];
    	while(p2<e2)//list1Ϊ�գ�����ʣ�������
    		array[p++] = copy[p2++];
    	
    	return cnt;
    }
	
	public static void main(String[] args) {
		
//		int[] data = { 6, 4, 8, 5, 2, 3, 4, 74 };
//		int[] data = { 7, 5, 6, 4 };
		int[] data = {7,5,6,4,11};
//		int[] data = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575 };

		Test51_Epoch2 test = new Test51_Epoch2();
		int cnt = test.InversePairs(data);

		System.out.println(Arrays.toString(data));
		System.out.println();
		System.out.println(cnt);
	}

}
