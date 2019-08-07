package round1and2and3;

public class Test50_1 {

    public int FirstNotRepeatingChar(String str) {
    	if (str==null || str.length()==0)//robust
    		return -1;
    	
    	int[] cnts = new int[52];
    	for (int i=0;i<cnts.length;i++){
    		cnts[i] = 0;
    	}
    	
    	for (int i=0;i<str.length();i++){
    		cnts[char2Idx(str.charAt(i))]++;
    	}
    	
    	for (int i=0;i<str.length();i++){
    		if (cnts[char2Idx(str.charAt(i))]==1)
    			return i;
    	}
        return -1;
    }
    
    public int char2Idx(char c){
    	if (c<='Z')
    		return (int)(c-'A');
    	else //if (c>='a')
    		return (int)(c-'a'+26);
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println((int)'a');
		System.out.println((int)'A');
		
		
		String str = "abaccdeff";
		Test50_1 test = new Test50_1();
		System.out.println(test.FirstNotRepeatingChar(str));;
	}

}
