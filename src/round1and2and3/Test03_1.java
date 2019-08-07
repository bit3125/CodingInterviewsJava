package round1and2and3;

public class Test03_1 {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	if ( numbers==null ||duplication==null 
    			|| numbers.length==0 || length<=0 || numbers.length!=length){//robust
    		return false;
    	}
    	
    	int idx = 0;
    	while(idx<length){
    		if (numbers[idx]==idx){
    			idx++;
    			continue;
    		}//else
    		if (numbers[numbers[idx]]==numbers[idx]){
    			duplication[0]=numbers[idx];
    			return true;
    		}
    		else{//numbers[numbers[idx]]!=numbers[idx]
    			swap(numbers, idx, numbers[idx]);
    		}
    	}
    	return false;
    }
    
    public void swap(int[] data, int idx1, int idx2){
    	int tmp = data[idx1];
    	data[idx1] = data[idx2];
    	data[idx2] = tmp;
    }
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test03_1 test = new Test03_1();
//		int[] data = {3,3,2,1,0,2,5,3};
		int[] data = {};
		int[] duplicate = new int[1];
		System.out.println(data.length);
		test.duplicate(data, data.length, duplicate);
		
		System.out.println(duplicate[0]);
	}

}
