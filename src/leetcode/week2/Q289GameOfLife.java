package leetcode.week2;

public class Q289GameOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] x = new int[][]{{1,1}};
		gameOfLife(x);
	}
	
	
	public static void gameOfLife(int[][] board) {
        
        //binary encoding idea: this is brilliant
        // code     future  current
        // 00       dead    dead
        // 01       dead    live
        // 10       live    dead
        // 11       live    live
        
        //to get current status use &1
        //to get future status use >>1
        
        if(board.length==0||board[0].length==0) return ;
        changeStatus(board);
    }
    
    private static void changeStatus(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int liveNei = liveNeighbors(board,i,j);
                if(board[i][j]==1) {
                    if(liveNei<2||liveNei>3) board[i][j] = 1;
                    else board[i][j] = 3;
                } else {
                    if(liveNei==3) board[i][j] = 2;
                    else board[i][j] = 0; //or do nothing coz it is already 0. to make it readable, I add this line
                }
                
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = board[i][j]>>1;
            }
        }
    }
    //the following function is also a good idea to make the code clean
    //keep in mind!
    private static int liveNeighbors(int[][] board, int i, int j) {
        int liveNum = 0;
        for(int m=Math.max(i-1,0); m<Math.min(i+2,board.length); m++) {
            for(int n=Math.max(j-1,0); n<Math.min(j+2,board[0].length); n++) {
            	if((board[m][n]&1)==1&&!(m==i&&n==j)) liveNum++; //dont't forget !(m==i&&n==j)
            }
        }
        return liveNum;
    }

}
