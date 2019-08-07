package round1and2and3;

import java.util.Arrays;
import java.util.Comparator;

public class Test45 {

    public String PrintMinNumber(int [] numbers) {
    	if (numbers==null||numbers.length==0)
    		return "";
    	
    	Integer[] data = ints2Integers(numbers);
    	Arrays.sort(data, new Comparator<Integer>(){
    		@Override
    		public int compare(Integer a, Integer b){
    			String ab = String.valueOf(a)+String.valueOf(b);
    			String ba = String.valueOf(b)+String.valueOf(a);
    			return ab.compareTo(ba);
    		}
    	});
    	
    	StringBuilder sb = new StringBuilder();
    	for (Integer i : data){
    		sb.append(String.valueOf(i));
    	}
    	
    	return sb.toString();
    }
	
    public Integer[] ints2Integers(int[] array){
    	if (array==null||array.length==0)
    		return new Integer[0];
    	
    	Integer[] result = new Integer[array.length];
    	for (int i=0;i<array.length;i++)
    		result[i] = array[i];
    	
    	return result;
    }
    
	public static void main(String[] args) {
		
		
	}

}
