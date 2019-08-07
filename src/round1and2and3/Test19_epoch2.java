/**
 * ����epoch2������ø�������
 * ������������ʹ������ߣ�
 * 1.ʹ��ѭ�������˴����ĵݹ�
 * 2.ʹ��startOfIdx��Ϊ��Σ�ʡȥ�˴�����copy array����
 * 
 * �߽���ԣ�
 * input = ������null ��ͨ��
 * input = ("", "") ��ͨ��
 * input = ("", "a*") �� ���Ǳ߽���������ǵݹ���� 
 * 
 * */
package round1and2and3;

public class Test19_epoch2 {

	public static boolean match(char[] str, char[] pattern){
		if (str==null||pattern==null)
			return false;
		
		return matchCore(str, pattern, 0, 0);
	}
	
	public static boolean matchCore(char[] str, char[] pattern, int startOfStr, int startOfPattern){
		/* �����������õݹ����
		 * ����������������Ӵ��±�Խ��ʱ����ֱ������whileѭ����ִ�����һ��return
		 * */
		while(startOfStr<str.length && startOfPattern<pattern.length ){
			if (startOfPattern+1<pattern.length && pattern[startOfPattern+1]=='*' ){//*ͨ��������
				if (!isEqual(str[startOfStr], pattern[startOfPattern])){//�жϵ�ǰλ�Ƿ�ƥ��
					startOfPattern += 2;//ֱ�Ӳ�ʹ��*ͨ���������*ͨ���,������ݹ飬��Լ����
				}else{ //isEqual
					//����״̬��ȡ���return
					return ( matchCore(str, pattern, startOfStr, startOfPattern+2 )//��ʹ��*ƥ�䲢����
							||matchCore(str, pattern, startOfStr+1, startOfPattern+2)//��ǰλʹ��һ��*ƥ�䲢����
							||matchCore(str, pattern, startOfStr+1, startOfPattern) );//��ǰλʹ��һ��*ƥ�䲢����ƥ�������ʹ��
				}
			}else {// pattern[startOfPattern]�������*ͨ���ƥ�䣬��ֱ�Ӱ���ǰλƥ��(�� =='.' || ==letter)
				if (!isEqual(str[startOfStr], pattern[startOfPattern]))
					return false;
				//else
				startOfStr++;
				startOfPattern++;
			}
		}
		
		/* ����while�����������
		 * 1.startOfStr==str.length && startOfPattern<pattern.length ��Ϊ�������
		 * 	1.1 patternֻʣ��һ��*ͨ�� �� ��"a*"�� ��ƥ��
		 * 	1.2   ����ƥ��
		 * 2.startOfStr<str.length && startOfPattern==pattern.length => ��ƥ��
		 * 3.startOfStr==str.length && startOfPattern==pattern.length => ƥ��
		 * */
		if (startOfPattern==pattern.length)
			return startOfStr==str.length;
		else //startOfPattern<pattern.length
			return (2==pattern.length-startOfPattern && '*'==pattern[startOfPattern+1]);
			//***bug:�����return����bug�ģ����µ�caseû��ͨ�������ﻹûfix����round4�ɡ�
		
	}
	
	public static boolean isEqual(char a, char b){
		//�жϵ�ǰλ�Ƿ�ƥ��
		return a==b || a=='.' || b=='.';
	}
	
	public static void main(String[] args) {
//		char[] str = "aaa".toCharArray();
//		char[] pattern = "ab*a*c*a".toCharArray();
		char[] str = "".toCharArray();
		char[] pattern = "a*b*".toCharArray();
		
		System.out.println(match(str, pattern));
	}
	
}
