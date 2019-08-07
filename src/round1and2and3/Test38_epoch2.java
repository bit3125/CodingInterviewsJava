/**ţ���϶������Ҫ��
 * 1.���ظ���ʹ��HashSetʵ�֣�û�����Ӹ��Ӷȿ���
 * 2.�ֵ���ʹ��sortʵ�֣������Ӷ�O(nlogn)�����������Ӷ�O(n!)
 * 
 * �㷨������˼·��epoch1��һ����
 * ��Ȼepoch2д�ı�epoch1�ֿ��ֺã�
 * 
 * */

package round1and2and3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Test38_epoch2 {

	public ArrayList<String> Permutation(String str) {
		Set<String> set = new HashSet<>();
		if (str==null || str.length()==0)
			return new ArrayList<String>();
		
		permutationCore(str.toCharArray(), set, 0);
		
		ArrayList<String> result = new ArrayList<String>(set);
		result.sort(new Comparator<String>() {
			@Override
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		});
		return result;
	}
	
	/*
	 * idx:����Ҫ������λ��
	 * */
	public void permutationCore(char[] chars,Set<String> set, int idx ){
		if (idx>=chars.length){ //�ݹ����
			set.add(new String(chars));
			return ;
		}
		
		permutationCore(chars, set, idx+1);//idxλ��Ϊchars[idx]
		for (int i=idx+1;i<chars.length;i++){//idxλ��Ϊchars[i]
			swap(chars, idx, i);
			permutationCore(chars, set, idx+1);
			//����
			swap(chars, idx, i);
		}
		//��ʵ��������Ҳ���Ժϲ�����
		
	}
	
	public void swap(char[] chars, int idx1, int idx2){
		char tmp = chars[idx1];
		chars[idx1] = chars[idx2];
		chars[idx2] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
