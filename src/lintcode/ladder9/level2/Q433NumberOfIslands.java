package lintcode.ladder9.level2;

public class Q433NumberOfIslands {
	
	public int numIslands(boolean[][] grid) {
        // Write your code here
        int[][] index = new int[2][4]; 
        index[0] = new int[]{-1,1,0,0};
        index[1] = new int[]{0,0,1,-1};
        
        if(grid==null||grid.length==0) return 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]&&!isVisited[i][j]) {
                    bfs(grid,i,j,isVisited, index);
                    count++;
                }
            }
        }
        return count;
        
    }
    
    private void bfs(boolean[][] grid, int x, int y, boolean[][] isVisited, int[][] index) {
        
        isVisited[x][y] = true;
        for(int i=0; i<4; i++) {
            int rIndex = x+index[0][i];
            int cIndex = y+index[1][i];
            if(rIndex>=0&&cIndex>=0&&rIndex<grid.length&&cIndex<grid[0].length&&grid[rIndex][cIndex]&&!isVisited[rIndex][cIndex]) {
                bfs(grid,rIndex,cIndex,isVisited,index);
            }
        }
        
        
    }

}
