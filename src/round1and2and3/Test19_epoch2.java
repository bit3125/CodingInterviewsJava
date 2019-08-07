/**
 * 明显epoch2代码更好更清晰了
 * 且在两个方面使性能提高：
 * 1.使用循环代替了大量的递归
 * 2.使用startOfIdx作为入参，省去了大量的copy array操作
 * 
 * 边界测试：
 * input = 包含有null 可通过
 * input = ("", "") 可通过
 * input = ("", "a*") ， 既是边界情况，又是递归出口 
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
		/* 不用另外设置递归出口
		 * 当送入的两段最后的子串下标越界时，会直接跳过while循环，执行最后一个return
		 * */
		while(startOfStr<str.length && startOfPattern<pattern.length ){
			if (startOfPattern+1<pattern.length && pattern[startOfPattern+1]=='*' ){//*通配符的情况
				if (!isEqual(str[startOfStr], pattern[startOfPattern])){//判断当前位是否匹配
					startOfPattern += 2;//直接不使用*通配符并抛弃*通配符,不进入递归，节约开销
				}else{ //isEqual
					//三种状态，取或后return
					return ( matchCore(str, pattern, startOfStr, startOfPattern+2 )//不使用*匹配并抛弃
							||matchCore(str, pattern, startOfStr+1, startOfPattern+2)//当前位使用一次*匹配并抛弃
							||matchCore(str, pattern, startOfStr+1, startOfPattern) );//当前位使用一次*匹配并保存匹配符继续使用
				}
			}else {// pattern[startOfPattern]无需进行*通配符匹配，可直接按当前位匹配(即 =='.' || ==letter)
				if (!isEqual(str[startOfStr], pattern[startOfPattern]))
					return false;
				//else
				startOfStr++;
				startOfPattern++;
			}
		}
		
		/* 跳出while有三种情况：
		 * 1.startOfStr==str.length && startOfPattern<pattern.length 分为两种情况
		 * 	1.1 pattern只剩下一个*通配 ， 如"a*"， 则匹配
		 * 	1.2   否则不匹配
		 * 2.startOfStr<str.length && startOfPattern==pattern.length => 不匹配
		 * 3.startOfStr==str.length && startOfPattern==pattern.length => 匹配
		 * */
		if (startOfPattern==pattern.length)
			return startOfStr==str.length;
		else //startOfPattern<pattern.length
			return (2==pattern.length-startOfPattern && '*'==pattern[startOfPattern+1]);
			//***bug:上面的return是有bug的，底下的case没法通过。这里还没fix，看round4吧。
		
	}
	
	public static boolean isEqual(char a, char b){
		//判断当前位是否匹配
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
