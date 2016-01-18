package lintcode.ladder9.level2;

import java.util.HashSet;

public class Q477SurrondedRegions {
	
	
	/**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        //bfs + unionfind
        
        if(board==null||board.length==0) return;
        
        int rNum = board.length;
        int cNum = board[0].length;
        
        int[][] indices = new int[2][4];
        indices[0] = new int[]{1,-1,0,0};
        indices[1] = new int[]{0,0,1,-1};
        
        //UnionFind uf = new UnionFind();
        HashSet<Integer> set = new HashSet<Integer>();
        
         //bfs
        for(int i=0; i<cNum; i++) {
            //first row and last row                       
                //[c,i] => c*cNum+i                
            if(board[0][i]=='O') bfs(board, 0, i, indices, set);
            if(board[rNum-1][i]=='O') bfs(board, rNum-1, i, indices, set);  
        }
        
        for(int j=1; j<rNum-1; j++) {
            //first and last column
          
            if(board[j][0]=='O') bfs(board,j,0, indices, set);
            if(board[j][cNum-1]=='O') bfs(board,j,cNum-1, indices, set);                
        }
        
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = 'X';
            }
        }
               
        for(int i:set) {
            board[i/cNum][i%cNum] = 'O';
        }
        
    }
    
    public void bfs(char[][] board, int x, int y, int[][] indices, HashSet<Integer> set) {
        
        
        if(!set.contains(x*board[0].length+y)) set.add(x*board[0].length+y);
        else return;
        
        for(int i=0; i<4; i++) {
            int rIndex = indices[0][i]+x;
            int cIndex = indices[1][i]+y;
            
            if(rIndex>=0&&rIndex<board.length&&cIndex>=0&&cIndex<board[0].length&&board[rIndex][cIndex]=='O') {
                
                bfs(board,rIndex,cIndex,indices,set);
                //uf.union(rIndex*board[0].length+cIndex,x*board[0].length+y);
                
            }
            
        }
    }

}
