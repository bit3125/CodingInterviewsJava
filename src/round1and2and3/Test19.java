package round1and2and3;

import java.util.Arrays;

public class Test19 {
	public static boolean match(char[] str, char[] pattern){
		if (str==null && pattern==null){
			return false;
		}
		return matchCore(str, pattern);
	}
	
	public static boolean matchCore(char[] str, char[] pattern){
		
		if (str.length==0 && pattern.length==0){
			return true;
		}else if (str.length!=0 && pattern.length==0){
			return false;
		}//else if (str.length==0 && pattern.length!=0) (�ϲ�����������ȥ��)
		else{//pattern.length!=0: 1. && str.length!=0 ; 2. && str.length==0  
			if (pattern.length>=2 && pattern[1]=='*'){ // *�����
				if (str.length==0){
					return matchCore(Arrays.copyOfRange(str, 0, str.length), Arrays.copyOfRange(pattern, 2, pattern.length));//*ƥ��0��
				}
				//else str �ǿ�
				if (str[0]==pattern[0] || pattern[0]=='.'){//��λƥ��
					return (   matchCore(Arrays.copyOfRange(str, 0, str.length), Arrays.copyOfRange(pattern, 2, pattern.length)) //*ƥ��0�� 
							|| matchCore(Arrays.copyOfRange(str, 1, str.length), Arrays.copyOfRange(pattern, 2, pattern.length)) //*ƥ��1��
							|| matchCore(Arrays.copyOfRange(str, 1, str.length), Arrays.copyOfRange(pattern, 0, pattern.length)) //*ƥ��n��
							); 
				}else{//��λ��ƥ��
					return matchCore(Arrays.copyOfRange(str, 0, str.length), Arrays.copyOfRange(pattern, 2, pattern.length));//*ƥ��0��
				}
			}else{ // ��*�����
				if (str.length==0){//str Ϊ��
					return false;
				}
				//else str�ǿ� 
				if (str[0]==pattern[0] || pattern[0]=='.'){//��λƥ��
					return matchCore(Arrays.copyOfRange(str, 1, str.length), Arrays.copyOfRange(pattern, 1, pattern.length));
				}else{//��λ��ƥ��
					return false;//TODO
				}
			}
		}
	}
	
	public static void main(String[] args) {
//		char[] s = "aaa".toCharArray();
//		char[] regS = "a.a".toCharArray();
//		char[] regS = "ab*a".toCharArray();
//		char[] regS = "aa.a".toCharArray();
//		char[] regS = "ab*ac*a".toCharArray();
		
//		char[] s = "".toCharArray();
//		char[] regS = ".*".toCharArray();

		char[] s = "aaa".toCharArray();
		char[] regS = "a*a".toCharArray();
		
		System.out.println(s);
		System.out.println(regS);
		System.out.println(match(s, regS));
		
	}

}


//����Ϊ�տ�ʼд�Ĵ�����룬û�п��ǵ�*�����������ƥ��0ƥ��1ƥ��n����Ҫ�õݹ�����
//package bupt.bnrc.lee;

//public class Test19 {
//
//	public static boolean match(char[] str, char[] pattern){
//		int i=0, j=0;
//		boolean matched = true;
////		str = ('a'+new String(str)).toCharArray();
////		pattern = ('a' + new String(pattern)).toCharArray();
//
//		while( i<str.length && j<pattern.length ){
//			
//
//			if ( j+1<pattern.length && pattern[j+1]=='*'){//���*�����
//				if (str[i]==pattern[j] || pattern[j]=='.' ){//��*��regSλ��s���ҵ�match���ˣ�ƥ��
//					j--;//regS����һλ��Ϊ�˵��������j++�������������λ��
//				}else{//��*��regSλû�ҵ�ƥ��
//					i--;//s����һλ��Ϊ�˵��������i++�������������λ��
//					j++;//��+1������*�����ɵ���һλ
//				}
//			}else if(str[i]!=pattern[j] && pattern[j]!='.'){//�����ַ������,��ƥ��
//				matched = false;
//				break;
//			}else{//ƥ�䣬��������
//				;
//			}
//			
//			i++;
//			j++;
//		}
//		if ( !(i==str.length && j==pattern.length) ){//�������Ȳ�һ
//			if (j+2==pattern.length && pattern[j+1]=='*'){//��*��β�����
//				;//����ƥ��ģ�nothing to do
//			}else{
//				matched = false;
//			}
//		}
//		
//		return matched;
//	}
//	
//	public static void main(String[] args) {
////		char[] s = "aaa".toCharArray();
////		char[] regS = "a.a".toCharArray();
////		char[] regS = "ab*a".toCharArray();
////		char[] regS = "aa.a".toCharArray();
////		char[] regS = "ab*ac*a".toCharArray();
//		
//		char[] s = "".toCharArray();
//		char[] regS = ".*".toCharArray();
//		
//		System.out.println(s);
//		System.out.println(regS);
//		System.out.println(match(s, regS));
//		
//	}
//
//}

