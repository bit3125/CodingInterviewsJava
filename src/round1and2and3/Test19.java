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
		}//else if (str.length==0 && pattern.length!=0) (合并到下面的情况去了)
		else{//pattern.length!=0: 1. && str.length!=0 ; 2. && str.length==0  
			if (pattern.length>=2 && pattern[1]=='*'){ // *的情况
				if (str.length==0){
					return matchCore(Arrays.copyOfRange(str, 0, str.length), Arrays.copyOfRange(pattern, 2, pattern.length));//*匹配0个
				}
				//else str 非空
				if (str[0]==pattern[0] || pattern[0]=='.'){//此位匹配
					return (   matchCore(Arrays.copyOfRange(str, 0, str.length), Arrays.copyOfRange(pattern, 2, pattern.length)) //*匹配0个 
							|| matchCore(Arrays.copyOfRange(str, 1, str.length), Arrays.copyOfRange(pattern, 2, pattern.length)) //*匹配1个
							|| matchCore(Arrays.copyOfRange(str, 1, str.length), Arrays.copyOfRange(pattern, 0, pattern.length)) //*匹配n个
							); 
				}else{//此位不匹配
					return matchCore(Arrays.copyOfRange(str, 0, str.length), Arrays.copyOfRange(pattern, 2, pattern.length));//*匹配0个
				}
			}else{ // 非*的情况
				if (str.length==0){//str 为空
					return false;
				}
				//else str非空 
				if (str[0]==pattern[0] || pattern[0]=='.'){//此位匹配
					return matchCore(Arrays.copyOfRange(str, 1, str.length), Arrays.copyOfRange(pattern, 1, pattern.length));
				}else{//此位不匹配
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


//以下为刚开始写的错误代码，没有考虑到*的三种情况：匹配0匹配1匹配n，需要用递归解决。
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
//			if ( j+1<pattern.length && pattern[j+1]=='*'){//后跟*的情况
//				if (str[i]==pattern[j] || pattern[j]=='.' ){//带*的regS位在s中找到match的了，匹配
//					j--;//regS回退一位，为了抵消后面的j++，留在现在这个位置
//				}else{//带*的regS位没找到匹配
//					i--;//s回退一位，为了抵消后面的i++，留在现在这个位置
//					j++;//多+1，跳过*，过渡到下一位
//				}
//			}else if(str[i]!=pattern[j] && pattern[j]!='.'){//正常字符的情况,不匹配
//				matched = false;
//				break;
//			}else{//匹配，不作处理
//				;
//			}
//			
//			i++;
//			j++;
//		}
//		if ( !(i==str.length && j==pattern.length) ){//俩串长度不一
//			if (j+2==pattern.length && pattern[j+1]=='*'){//以*结尾的情况
//				;//还是匹配的，nothing to do
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

