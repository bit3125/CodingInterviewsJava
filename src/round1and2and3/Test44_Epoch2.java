/** 好像写的比第一次乱，
 * 看Epoch1的思路！
 * 
 * */

package round1and2and3;

public class Test44_Epoch2 {

	public int digitAtIndex(int index){
		if(index<0)
			return -1;
		if (index<=10)//一位数的情况
			return index-1;
		
		index -= 10;
		int targetNum, targetDigit;//目标数，目标数位
		int digitNum = 2;//位数
		int base = 90;
		//确定targetNum是几位数
		while(index>base){
			index -= base;
			digitNum++;
			base *=10;
		}

		//计算目标数
		targetNum = base/9-1+ (int)Math.ceil(index*1.0/digitNum);
		//计算目标数位
		index %= digitNum;
		index = index==0?digitNum:index; //***bug:
		base = (int) Math.pow(10, digitNum-index);
		targetDigit = targetNum/(base)%10;
		
		return targetDigit;
	}
	
	public static void main(String[] args) {
		Test44_Epoch2 t = new Test44_Epoch2();
		int index = 1;
		System.out.println(t.digitAtIndex(index));
	}

}
