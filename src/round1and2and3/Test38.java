package round1and2and3;
import java.util.ArrayList;
import java.util.Arrays;

public class Test38 {
	/**����㷨
	 * �㷨˼·�����ڶ����㷨
	 * 
	 * ���㷨��Ҫ�ĸĽ��ǵݹ�ջ�е����к�������StringBuffer������ڴ棬���÷����������ڴ�
	 * 
	 * */
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> permuList = new ArrayList<String>();
		
		//robust
		if (str==null)
			return null;
		else if(str.equals(""))
			return permuList;
		
		StringBuffer sb;
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		str = new String(chars);
		sb = new StringBuffer(str);
		permutationCore(permuList, sb, 0);

		permuList.sort(null);//***bug: ������������û���ֵ����������
		/*���ڴ˴���˵�������ڴ��㷨��ȡ����swap�ķ�������ʹ�������������permutationCore��
		 * ÿ��swap��ض��ᵼ�º�����Ӵ���������ǰ���С��ĸ�嵽����Ĵ���ĸ��λ����ȥ�ˣ�
		 * �ʳ����Ľ�����ǻ�������ģ��ʵ�������
		 * 
		 * ����������Ǹ��㷨����ȡ���ǳ�ȡ�ķ�������������һ�εݹ���Ӵ���Ȼ������ģ�
		 * ���������Ҳ������ģ���������
		 * */
		return permuList;
    }
	
	public void permutationCore(ArrayList<String> permuList, 
		StringBuffer sb, int start){
		
		if (start>=sb.length()-1){ //�ݹ����
//			permuList.add(new String(sb));
//			return ;
			
			//***bug:��ʹ������forѭ����ʼ�����ȥ����䣬��ȫ��ʹ��ͬһ��sb���㷨�»����޷���֤һ�����ظ�
			//�ʲ�����䲻��ɾȥ
			String newstr = new String(sb);
			boolean repeated = false;
			for (int i=0;i<permuList.size();i++){
				if (permuList.get(i).equals(newstr)){
					//***bug:��ͬ�ַ�����String��StringBuffer���󣬵���equal(),���ص���false
					repeated=true;
					break;
				}
			}
			if (!repeated){
				permuList.add(newstr);
			}
			return ;
		}
		
		//body
		for (int i=start;i<sb.length();i++){//***bug:(int i=0;i<sb.length()-start;i++)
			if (i-1>=start) //***bug: if (i-1>=0)
				if (sb.charAt(i)==sb.charAt(i-1))
					continue;//***bug: return;
			
			swap(sb, start, i);
			permutationCore(permuList, sb, start+1);
			swap(sb, start, i);//����
		}
	}
	
	public void swap(StringBuffer sb, int idx1, int idx2){
		if (!(0<=idx1 && idx1<sb.length() && 0<=idx2 && idx2<sb.length()))
			return;
		
		char tmp = sb.charAt(idx1);
		sb.setCharAt(idx1, sb.charAt(idx2));
		sb.setCharAt(idx2, tmp);
		
	}
	
//	/**�㷨˼·������ɷֽ�ΪС���⣺Ҫ�õ�һ��str��һ�����У�������ѡһ��char��Ϊ���еĵ�һλ��
//	 * Ȼ��õ�ʣ��chars��ȫ��������ƴ�����������Ǹ�char��Ϊ��һλ����������
//	 * ���Ǻ���һ��forѭ�����оٳ�str��ÿһ��char��Ϊ��һλ��������ϲ���������õ������str��ȫ����
//	 * */
//    public ArrayList<String> Permutation(String str) {
//    	ArrayList<String> permuList = new ArrayList<String>();
//        //robust
//    	if (str==null)
//        	return null;
//        else if (str.equals(""))
//        	return permuList;
//        
//        // str sort
//        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
//        str = new String(chars);
//        
//        //permutation
//        permuList = permutationCore(str);
//    	return permuList;
//    }
//    
//    public ArrayList<String> permutationCore(String str){
//    	/**�õ���str��ȫ����
//    	 * */
//    	ArrayList<String> permuList = new ArrayList<String>();
//    	ArrayList<String> subPermuList;// = new ArrayList<String>();
//    	String substr, newPermu;
//    	boolean repeated;
//    	
//    	if (str.length()==1){ //�ݹ����
//    		permuList.add(str);
//    		return permuList;
//    	}
//    	
//    	for (int i=0;i<str.length();i++){
//    		if (i-1>=0)// �ظ��ַ������ڶ���
//    			if (str.charAt(i)==str.charAt(i-1))
//    				continue;
//    		
//    		substr = str.substring(0, i)+str.substring(i+1, str.length());
//        	subPermuList = permutationCore(substr);//�õ��Ӵ���ȫ����List
//        	//***bug:permuList = permutationCore(substr);����ÿ��ѭ���������һ�˵Ľ�����ǵ�
//        	
//        	for (int j=0;j<subPermuList.size();j++){//concat
//        		newPermu = str.charAt(i)+subPermuList.get(j);//�õ�һ��������
//    			permuList.add(newPermu);        				
//        	}//������ڴ��������ظ��жϣ��������newPermu���������ظ��ģ�����Ҫ�������Ӷ�Ϊn^2�ı������ء�
//        	//����Ľ�ʡ�˲���ʱ����ռ俪��
//        	
////        	for (int j=0;j<subPermuList.size();j++){//concat
////        		newPermu = str.charAt(i)+subPermuList.get(j);//�õ�һ��������
////        		//�����ظ��򲢼���permuList
////        		repeated = false; 
////        		for (int k=0;k<permuList.size();k++){//�Ե�ǰλ�ϵõ���ȫ���б���
////        			if (permuList.get(k).equals(newPermu)){
////        				repeated = true;
////        				break;
////        			}
////        		}
////        		if (!repeated)
////        			permuList.add(newPermu);        				
////        	}
//        	
//        }
//    	
//    	return permuList;
//    }
//    
    public void printList(ArrayList<String> al){
    	for (int i=0;i<al.size();i++){
    		System.out.println(al.get(i));
    	}
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		String str = "abadfa";
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		System.out.println(chars);
		
		str = "a";
		System.out.println(str.substring(0, 0));
		System.out.println(str.substring(1, str.length()));
		
		System.out.println();
		Test38 test = new Test38();
		test.printList(test.Permutation("aac"));
	}
	

}
