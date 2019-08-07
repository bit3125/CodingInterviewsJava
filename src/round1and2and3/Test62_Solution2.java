package round1and2and3;

public class Test62_Solution2 {

	public int LastRemaining_Solution(int n, int m) {
		if (n <= 0 || m <= 0)
			return -1;
		
		int f1 = 0, f2 = 0, tmp;
		
		for(int i=2;i<=n;i++){
			f2 = (f1+m)%i;
			f1 = f2;
		}
		
		return f1;
	}

	public static void main(String[] args) {
		Test62_Solution2 t = new Test62_Solution2();
		int n = 5;
		int m = 3;

		System.out.println(t.LastRemaining_Solution(n, m));
	}

}
