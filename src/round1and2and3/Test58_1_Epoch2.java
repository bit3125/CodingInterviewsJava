/**Epoch1使用的是自己最先思考的原始方法
 * Epoch2使用的是剑指offer上的算法
 * Epoch2的模块化更好，思路更清晰
 * 
 * */

package round1and2and3;

public class Test58_1_Epoch2 {

    public String ReverseSentence(String str) {
    	if (str==null || str.length()==0)
    		return "";
    	
    	char[] cs = str.toCharArray();
    	reverseChars(cs, 0, cs.length-1);
    	
    	int start = 0, end = 1;
    	while(end<=cs.length){
    		if (end==cs.length || cs[end]==' '){
    			reverseChars(cs, start, end-1);
    			start = end+1;
    			end += 2;
    		}else{
    			end++;
    		}
    	}
    	
    	return new String(cs);
    }
    
    public void reverseChars(char[] cs, int front, int rear){
    	
    	char tmp;
    	while(front<rear){
    		tmp = cs[front];
    		cs[front++] = cs[rear];
    		cs[rear--] = tmp;
    	}
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test58_1_Epoch2 t = new Test58_1_Epoch2();
		String str = "I am a student.";
		System.out.println(t.ReverseSentence(str));
	}

}
