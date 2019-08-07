package round1and2and3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test38_2 {

	public List<String> combination (String str){
		List<String> result = new ArrayList<>();
		if (str==null || str.length()==0)
			return result;
		
		boolean[] selected = new boolean[str.length()];
		Arrays.fill(selected, false);
		combinationCore(str, 0, selected, result);
		
		return result;
	}
	
	public void combinationCore (String str, int idx, boolean[] selected, List<String> result){
		if (idx==str.length()){
			StringBuilder sb = new StringBuilder();
			for (int i=0;i<str.length();i++){
				if (selected[i])
					sb.append(str.charAt(i));
			}
			result.add(sb.toString());
			
			return;//***bug
		}
		
		selected[idx] = true;
		combinationCore(str, idx+1, selected, result);
		selected[idx] = false;//»ØËÝ
		combinationCore(str, idx+1, selected, result);
	}
	
	public static void main(String[] args) {
		String str = "asd";
		Test38_2 t = new Test38_2();
		
		List<String> result = t.combination(str);
		for (String re : result){
			System.out.println(re);
		}
		
	}

}
