package round1and2and3;

public class Test48 {

	/**�㷨˼·�����Ͷ�̬�滮
	 * 
	 * ��f[i]Ϊ��str[i]��β�Ĳ��ظ��Ӵ��������ֵ
	 * ���ƹ�ʽ��f[i] = max{g[i-1,i]*(f[i-1]+1),1 } //���󣬲���������
	 * ��ʼ������f[0] = 1
	 * ����g[i-1,i] = 1, if str[i]��������str[i-1]��β�Ĳ��ظ���Ӵ�
	 * 			 0, if str[i]������str[i-1]��β�Ĳ��ظ���Ӵ�
	 * 
	 * Tn = On^2
	 * */
//	public int longestSubstringWithoutDuplication(String str){
//		if (str==null || str.length()==0)
//			return -1;
//		
//		int[] longestSubStrStartWith = new int[str.length()];
//		int[] f = new int[str.length()];
//		f[0] = 1;
//		longestSubStrStartWith[0] = 0;
//		
//		for (int i=1;i<str.length();i++){
//			if ( str.substring(longestSubStrStartWith[i-1], i).contains(str.substring(i,i+1)) ){//���Ӵ�
//				f[i] = 1;
//				longestSubStrStartWith[i] = i; 
//			}else{//���Ӿ��Ӵ�
//				f[i] = f[i-1]+1;
//				longestSubStrStartWith[i] = longestSubStrStartWith[i-1];
//			}
//		}
//		
//		int max = f[0];
//		for (int i=0;i<str.length();i++)
//			if (f[i]>max)
//				max = f[i];
//		return max;
//	}
	
	/**������Լ���Ķ�̬�滮�㷨������һ��Сƫ��
	 * �㷨˼·�����Ͷ�̬�滮
	 * 
	 * ��f[i]Ϊ��str[i]��β�Ĳ��ظ��Ӵ��������ֵ
	 * ���ƹ�ʽ��f[i] = max{g[i-1,i]*(f[i-1]+1),1 } //���󣬲���������
	 * ��ʼ������f[0] = 1
	 * ����g[i-1,i] = 1, if str[i]��������str[i-1]��β�Ĳ��ظ���Ӵ�
	 * 			 0, if str[i]������str[i-1]��β�Ĳ��ظ���Ӵ�
	 * 
	 * Tn = On^2
	 * */
	public int longestSubstringWithoutDuplication(String str){
		if (str==null || str.length()==0)
			return -1;
		
		int[] f = new int[str.length()];
		int[] latestAppearIdxs = new int[26];

		//init
		f[0] = 1;
		for (int i=0;i<26;i++)
			latestAppearIdxs[i]=-1;
		latestAppearIdxs[str.charAt(0)-'a'] = 0;
			
		//dp
		for (int i=1;i<str.length();i++){
			if (latestAppearIdxs[str.charAt(i)-'a'] < i-f[i-1])//��һ���ظ����ַ���str[i-1]����Ӵ�֮��
				f[i] = f[i-1]+1;
			else//��һ���ظ����ַ���str[i-1]����Ӵ�֮��
				f[i] = i-latestAppearIdxs[str.charAt(i)-'a'];
			latestAppearIdxs[str.charAt(i)-'a'] = i;
		}
		
		int max = f[0];
		for (int i=0;i<str.length();i++)
			if (f[i]>max)
				max = f[i];
		return max;
	}
	
	public static void main(String[] args) {
		
		String str = "arabcacfr";
		
		Test48 test = new Test48();
		int max = test.longestSubstringWithoutDuplication(str);
		System.out.println(max);
	}

}
