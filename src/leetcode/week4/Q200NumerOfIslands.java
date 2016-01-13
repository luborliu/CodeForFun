package leetcode.week4;

public class Q200NumerOfIslands {
	
	//the hot discussion includes 2 things for optimization
	//1st do modification on grid array s.t every time we have less comparison, no need to go to isVisited array to see
	//2nd instead of using loops to go through all 8 neighbors, it only go through 4 neighbors using two static array which is good idea
	
	
	boolean[][] isVisited = null;
    
    public int numIslands(char[][] grid) {
        
        //aha, only need a 2-d array to store if the point is visited 
        // if grid[x][y]'s 4 neighbors are all 0 or 1(visited) then islandNumber++
        // no this is not right, e.g.
        // 1 1
        // 1 0
        // it will give us 2 but the result should be 1
        // so we still need to use dfs
        
        
        if(grid.length==0) return 0;
        
        isVisited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                //if(isVisited[i][j]) continue;
                if(grid[i][j]=='1'&&!isVisited[i][j]) {
                    count++;
                    
                    //bfs or dfs
                    explore(grid,i,j);
                    //isVisited[i][j] = true;
                }
            }
        }
        return count;
    }
    
    //dfs, basically same idea as dbscan the island is just one simple cluster
    private void explore(char[][] grid, int x, int y) {
        isVisited[x][y] = true;
        
        //the following take diagonal into account
        // for(int i=x-1; i<=x+1; i++) {
        //     for(int j=y-1; j<=y+1; j++) {
        //         if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j]=='1'&&!isVisited[i][j]) {
        //             explore(grid,i,j);
        //         }
        //     }
        // }
        for(int i=x-1; i<=x+1; i++) {
            for(int j=y-1; j<=y+1; j++) {
                if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j]=='1'&&!isVisited[i][j]&&(i==x||j==y)) {//only one coordinator is eaqual to x or y to gurantee that it is not diagonal
                    explore(grid,i,j);
                }
            }
        }
        
        
    }

}
