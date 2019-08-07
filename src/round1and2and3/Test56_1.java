package round1and2and3;

public class Test56_1 {

	//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
	//��num1[0],num2[0]����Ϊ���ؽ��
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array==null || array.length==0) //robust
        	return;
        if (array.length==2){ //boundary condition
        	num1[0] = array[0];
        	num2[0] = array[1];
        }//else array.length>2
    	
        // cal total xor
    	int xor = 0; //0^n=n
        for (int i=0;i<array.length;i++)
        	xor = xor^array[i];
        
        //find the 1st 1 in xor
        int base = 1;
        while((xor&base)==0)
        	base = base<<1;
        
//        //û��Ҫȥswap
//        //split numbers into 2 groups
//        int front = 0, rear = array.length-1;
//        while(front<rear){
//        	while((array[front]&base)==base && front<rear) //***bug:array[front]&base)==1
//        		front++;
//        	while((array[rear]&base)==0 && front<rear) //***bug:array[front]&base
//        		rear--;
//        	
//        	if (!(front<rear))
//        		break;
//        	int temp = array[front];
//        	array[front] = array[rear];
//        	array[rear] = temp;
//        }//����˳�ʱ����  front==rear
//        if ((front&1)==1)//front������group�Ľ��紦��������ǰ�ߵ�βҲ�����Ǻ��ߵ�ͷ��ͳһ���ó�ǰ�ߵ�β��
//        	front -= 1;
//
//        //find the 2 numbers
//        num1[0] = 0;
//        for (int i=0;i<=front;i++)//<=
//        	num1[0] = num1[0]^array[i]; 
//        num2[0] = 0;
//        for (int i=front+1;i<array.length;i++)
//        	num2[0] = num2[0]^array[i];
        
        //find the 2 numbers
        for (int i=0;i<array.length;i++){
        	if ((array[i]&base)==base)
        		num1[0] = num1[0]^array[i];
        	else
        		num2[0] = num2[0]^array[i];
        }
        
    } 
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] array = {2,4,3,6,3,2,5,5};
		int[] num1=new int[1], num2=new int[1];
		
		Test56_1 test = new Test56_1();
		test.FindNumsAppearOnce(array, num1, num2);
		
		System.out.println(num1[0]);
		System.out.println(num2[0]);
	}

}
