package round1and2and3;

//牛客没有
public class Test46 {

	/**递归，类似全排列，返回所有的可能值
	 * */
	
//	private Set<String> set = new HashSet<String>();
//	public ArrayList<String> getTranslationCount(int n){
//		ArrayList<String> al;
//		if (n<0){
//			al = new ArrayList<String>(set);
//			return al;
//		}
//		
//		char[] template = String.valueOf(n).toCharArray();
//		char[] target = new char[template.length];
//		
//		getCore(template, target, 0, 0);
//		al = new ArrayList<String>(set);
//		return al;
//	}
//	
//	public void getCore(char[] template, char[] target, int idxTem, int idxTar ){
//		if (idxTem>=template.length){
//			set.add(new String(target, 0, idxTar));
//			return;
//		}
//			
//		
//		if (template.length-idxTem>=2){//取两位
//			int num = Integer.parseInt(new String(template, idxTem, 2));
//			if (num<=25){
//				target[idxTar] = (char)('a'+num);
//				getCore(template, target, idxTem+2, idxTar+1);
//			}//回溯：idx为参数传递，无需回溯
//		}
//		
//		//取一位
//		int num = Integer.parseInt(new String(template, idxTem, 1));
//		target[idxTar] = (char)('a'+num);
//		getCore(template, target, idxTem+1, idxTar+1);
//		//回溯：idx为参数传递，无需回溯
//	}
//	
//	public static void main(String[] args) {
//		// TODO 自动生成的方法存根
//		Test46 test = new Test46();
////		int n = 123456;
//		int n = 12258;
//		ArrayList<String> al = test.getTranslationCount(n);
//		
//		for (int i=0;i<al.size();i++){
//			System.out.println(al.get(i));
//		}
//	}
	
	/**只计算数目
	 * */
	int getTranslationCount(int n){
		if (n<=0)
			return -1;
		
		String template = String.valueOf(n);
		int[] f = new int[template.length()];
		int num;
		f[template.length()-1] = 1;
		
		if (template.length()>=2){
			num = Integer.parseInt(template.substring(template.length()-2, template.length()));
			f[template.length()-2] = 1+g(num);
		}
		
		for (int i=template.length()-3;i>=0;i--){
			num = Integer.parseInt(template.substring(i, i+2));
			f[i] = f[i+1]+g(num)*f[i+2];
		}
		
		return f[0];
	}
	
	public int g(int num){
		return num<=25?1:0;
	}
	
	public static void main(String[] args) {
		Test46 test = new Test46();
		int n = 12258;
		int cnt = test.getTranslationCount(n);
		System.out.println(cnt);
	}
	
}
