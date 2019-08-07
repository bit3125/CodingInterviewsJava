package round1and2and3;

//牛客里没有

public class Test44 {

	public int digitAtIndex(int index){
		if (index<0) //robust
			return -1;
		//以下用19的'9'举例(index=29)
		//一位数共有10位，二位数90位，三位数900位，以此类推
		int digits = 1;
		int digitsTotalCur = 10;
		int base, curNumber, offset;
		String str;

		while(index>=digitsTotalCur){
			index -= digitsTotalCur;
			digits++;
			digitsTotalCur = digits==2?90:digits*10;
		}
		
		base = digits==1?0:(int) (Math.pow(10, digits-1)); //两位数的起点数字, 10
		curNumber = base + index/digits; //从起点数字10计算出当前index处于的实际数字，29
		str = String.valueOf(curNumber);//转化29为'29'
		offset = index % digits;//计算index在'29'字符串中的偏移量

		return str.charAt(offset)-'0';
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test44 test = new Test44();
		int index = 29;
		System.out.println(test.digitAtIndex(index));
		
	}

}
