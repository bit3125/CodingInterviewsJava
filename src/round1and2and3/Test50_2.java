package round1and2and3;

public class Test50_2 {

	private int size = 0;
	private int[] firstIdxs = new int[256];
	
    //Insert one char from stringstream
    public void Insert(char ch){
    	if (size==0)//init
    		for (int i=0;i<256;i++)
    			firstIdxs[i] = -1;
    	
        if (firstIdxs[ch]==-1) //没出现过
        	firstIdxs[ch] = size;
        else //出现过，丢弃之
        	firstIdxs[ch] = -2;
    	size++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
    	char firstChar = '#';
    	int firstIdx = Integer.MAX_VALUE;
    	for (int i=0;i<256;i++){
    		if (firstIdxs[i]>=0 && firstIdxs[i]<firstIdx){
    			firstChar = (char) i;
    			firstIdx = firstIdxs[i];
    		}
    	}
    	return firstChar;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
