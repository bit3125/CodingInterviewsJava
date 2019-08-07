package round1and2and3;

public class Test46_Epoch2 {

	public int getTranslationCount(int n){
		if (n<=0)
			return Integer.MIN_VALUE;
		String str = String.valueOf(n);
		if (str.length()==1)
			return 1;
		
		int[] f = new int[str.length()];
		f[f.length-1] = 1;
		f[f.length-2] = 1 + g(str, f.length-2);
		
		for (int i=f.length-3;i>=0;i--){
			f[i] = f[i+1] + f[i+2]*g(str, i);
		}
		
		return f[0];
	}
	
	public int g(String str, int i){
		return Integer.valueOf(str.substring(i, i+2))<=26?1:0;
	}
	
	public static void main(String[] args) {
		Test46_Epoch2 test = new Test46_Epoch2();
		int n = 12258;
		int cnt = test.getTranslationCount(n);
		System.out.println(cnt);
		
	}

}
