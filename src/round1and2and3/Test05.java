package round1and2and3;

public class Test05 {

    public String replaceSpace(StringBuffer str) {
    	if (str==null) //robust
    		return null;
    	
    	String resultStr;
    	int idxNew, idxOld, spaceCounter=0;
    	
    	for (int i=0;i<str.length();i++){
    		if (str.charAt(i)==' ')
    			spaceCounter++;
    	}
    	
    	idxOld = str.length()-1;
    	idxNew = str.length()-1+2*spaceCounter;
    	str.setLength(idxNew+1);
    	while(idxNew>=0){
    		if (str.charAt(idxOld)==' '){
    			for (int j=0;j<3;j++){
    				str.setCharAt(idxNew-j,"02%".charAt(j));
    			}
    			idxNew-=2;
    		}else
    			str.setCharAt(idxNew, str.charAt(idxOld));
    		idxNew--;
    		idxOld--;
    	}
    	
    	return new String(str);
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test05 test = new Test05();
		StringBuffer str = new StringBuffer("we are happy");
		System.out.println(test.replaceSpace(str));
		
	}

}
