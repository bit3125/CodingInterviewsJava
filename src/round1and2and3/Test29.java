package round1and2and3;
import java.util.ArrayList;

public class Test29 {
	/* ���·���������ģ������һ�������Ǽ������
	 * */
	
	public ArrayList<Integer> printMatrix(int[][] matrix){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix.length==0){// robust
			return result;
		}
		
		int[] xranges = {0, matrix[0].length};
		int[] yranges = {0, matrix.length};
		int x=0, y=0;
		int n = matrix.length*matrix[0].length;
		while(result.size()<n){
			while(x<xranges[1] && result.size()<n){
				result.add(new Integer(matrix[y][x]));
				x++;
			}
			x--;
			yranges[0]++;
			y++;//***bug:��������add�ٱ����꣬�����һ�λ��˺�Ҫ��һ����һ�������ǰ��
			while(y<yranges[1] && result.size()<n){
				result.add(new Integer(matrix[y][x]));
				y++;
			}
			y--;
			xranges[1]--;
			x--;
			while(x>=xranges[0] && result.size()<n){
				result.add(new Integer(matrix[y][x]));
				x--;
			}
			x++;
			yranges[1]--;
			y--;
			while(y>=yranges[0] && result.size()<n){
				result.add(new Integer(matrix[y][x]));
				y--;
			}
			y++;
			xranges[0]++;
			x++;//***bug:���һ���������ҲҪ��һ����һ�������ǰ��
		}
		return result;
	}
	
	
//	/* ���·���Ϊģ�����ߵķ�����д��̫���ڸ��ӣ����Լ�
//	 * */
//	public ArrayList<Integer> printMatrix(int [][] matrix) {
//		
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		if (matrix.length==0){//robust
//			return result;
//		}//����������һ��Ԫ��
//		
//		Direction[] ds = {Direction.RIGHT};
//		int[] positions = {0,0};
//		int[] ranges = {0, matrix[0].length, 0, matrix.length};//x0, x1, y0, y1,  ����ҿ�
//		int n = matrix.length*matrix[0].length;
//		
//		result.add(new Integer(matrix[positions[0]][positions[1]]));
//		while(result.size()<n){
//			positions = moveOn(ds, positions, ranges);
//			result.add(new Integer(matrix[positions[1]][positions[0]]));//***bug:
//		}
//		return result;
//    }
//	
//	public int[] moveOn(Direction[] ds, int[] positions, int[] ranges){
//		int[] positionsNew;
//		
//		positionsNew = step(ds[0], positions);//������һ�����õ���λ��
//		if (outOfRange(positionsNew, ranges)){/*����Ƿ�Խ�磬��Խ������ٵݹ�ִ��һ��
//		ֻ��ִ��һ�ε��޶����ϲ����
//		*/
//			ds[0] = turn(ds[0]);
//			positionsNew = moveOn(ds, positions, ranges);
//		}else{//����ÿԽ�磬����ʲô
//			
//		}
//		return positionsNew;//������λ��
//		
//		
//	}
//	
//	public Direction turn(Direction d){
//		/* ֻ�����������ķ��򷵻�ת���ķ���
//		 * */
//		if (d==Direction.UP)
//			return Direction.RIGHT;
//		else if (d==Direction.RIGHT)
//			return Direction.DOWN;
//		else if (d==Direction.DOWN)
//			return Direction.LEFT;
//		else //if (d==Direction.LEFT)
//			return Direction.UP;
//	}
//	
//	public int[] step(Direction d, int[] positions){
//		int[] positionsNew = Arrays.copyOfRange(positions, 0, positions.length);
//		
//		if (d==Direction.UP){
//			positionsNew[1]--;
//		}else if (d==Direction.DOWN){
//			positionsNew[1]++;
//		}else if (d==Direction.LEFT){
//			positionsNew[0]--;
//		}else if (d==Direction.RIGHT){
//			positionsNew[0]++;
//		}
//		
//		return positionsNew;
//	}
//	
//	public boolean outOfRange(int[] positions, int[] ranges){
//		/* ���ݴ�����ж�λ���Ƿ�Խ�磬
//		 * ��Խ�绹Ҫ�޸��µı߽�
//		 * */
//		int x = positions[0];
//		int y = positions[1];
//		int x0 = ranges[0], x1 = ranges[1], y0 = ranges[2], y1 = ranges[3];
//		if ( !(x0<=x && x<x1 && y0<=y && y<y1) ){
//			if (!(x0<=x))
//				ranges[3]--;
//			else if(!(x<x1))
//				ranges[2]++;
//			else if(!(y0<=y))
//				ranges[0]++;
//			else if(!(y<y1))
//				ranges[1]--;
//			return true;
//		}else{
//			return false;
//		}
//		
//	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[][] mat = {{1,2},{3,4}};
		
		Test29 test = new Test29();
		ArrayList<Integer> result;
		
		result = test.printMatrix(mat);
		for (int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}

}

enum Direction{
	UP,
	DOWN,
	LEFT,
	RIGHT
}