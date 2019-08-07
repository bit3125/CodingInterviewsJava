package round1and2and3;
import java.util.ArrayList;

public class Test29 {
	/* 以下方法本质与模拟行走一样，但是简化了许多
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
			y++;//***bug:由于是先add再变坐标，故最后一次回退后要做一次下一个方向的前进
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
			x++;//***bug:最后一条边走完后也要做一次下一个方向的前进
		}
		return result;
	}
	
	
//	/* 以下方法为模拟行走的方法，写的太过于复杂，可以简化
//	 * */
//	public ArrayList<Integer> printMatrix(int [][] matrix) {
//		
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		if (matrix.length==0){//robust
//			return result;
//		}//否则至少有一个元素
//		
//		Direction[] ds = {Direction.RIGHT};
//		int[] positions = {0,0};
//		int[] ranges = {0, matrix[0].length, 0, matrix.length};//x0, x1, y0, y1,  左闭右开
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
//		positionsNew = step(ds[0], positions);//尝试走一步，得到新位置
//		if (outOfRange(positionsNew, ranges)){/*检查是否越界，若越界变相再递归执行一次
//		只再执行一次的限定由上层完成
//		*/
//			ds[0] = turn(ds[0]);
//			positionsNew = moveOn(ds, positions, ranges);
//		}else{//否则每越界，不做什么
//			
//		}
//		return positionsNew;//返回新位置
//		
//		
//	}
//	
//	public Direction turn(Direction d){
//		/* 只负责根据输入的方向返回转向后的方向
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
//		/* 根据传入的判断位置是否越界，
//		 * 若越界还要修改新的边界
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
		// TODO 自动生成的方法存根
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