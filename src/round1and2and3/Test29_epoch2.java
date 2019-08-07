package round1and2and3;

import java.util.ArrayList;
import java.util.List;



public class Test29_epoch2 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
    	ArrayList<Integer> results = new ArrayList<>();
    	if (matrix==null || matrix.length==0 || matrix[0].length==0)
    		return results;
    	
    	int leftRange = 0;
    	int rightRange = matrix[0].length-1;
    	int upRange = 0;
    	int downRange = matrix.length-1;
    	int N = matrix.length * matrix[0].length;
    	
    	int i=0, j=-1;//***bug:要对称，故此处j初值为-1
    	while(results.size()<N){
    		j++;
    		while(j<=rightRange){
    			results.add(matrix[i][j]);
    			j++;
    		}
    		j--;
    		upRange++;
    		if(results.size()>=N)
    			break;
    		
    		i++;
    		while(i<=downRange){
    			results.add(matrix[i][j]);
    			i++;
    		}
    		i--;
    		rightRange--;
    		if(results.size()>=N)
    			break;
    		
    		j--;
    		while(leftRange<=j){
    			results.add(matrix[i][j]);
    			j--;
    		}
    		j++;
    		downRange--;
    		if(results.size()>=N)
    			break;
    		
    		i--;
    		while(upRange<=i){
    			results.add(matrix[i][j]);
    			i--;
    		}
    		i++;
    		leftRange++;
    		if(results.size()>=N)
    			break;
    	}
    	
    	return results; 
    }
	
	public static void main(String[] args) {
		Test29_epoch2 t = new Test29_epoch2();
//		int[][] matrix = {{1,2},{3,4}};
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		
		List<Integer> results = t.printMatrix(matrix);
		for (Integer i : results){
			System.out.println(i);
		}
	}

}
