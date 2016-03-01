package lintcode.ladder9.level5;

public class Q398LongestIncreasingContinuousSubsequenceII {
	
	/**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        //memorization search 记忆化搜索
        //dp[i][j] 代表以A[i][j]结尾的最长subsequence的长度
        
        if(A==null||A.length==0||A[0].length==0) return 0;
        
        int[][] dp = new int[A.length][A[0].length];
        
        boolean[][] isVisited = new boolean[A.length][A[0].length];
        
        int max = 0;
        
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A[0].length; j++) {
                max = Math.max(max,search(A,dp,isVisited,i,j));
            }
        }
        return max;
        
    }
    
    private int search(int[][] A, int[][] dp, boolean[][] isVisited, int i, int j) {
        
        if(isVisited[i][j]) return dp[i][j];
        isVisited[i][j] = true;
        dp[i][j] = 1;
        int[][] indices = new int[][]{{1,-1,0,0},{0,0,1,-1}};
        
        for(int m=0; m<4; m++) {
            int xIndex=i+indices[0][m];
            int yIndex=j+indices[1][m];
            if(xIndex>=0&&xIndex<A.length&&yIndex>=0&&yIndex<A[0].length&&A[i][j]>A[xIndex][yIndex]) {
                dp[i][j] = Math.max(dp[i][j],1+search(A,dp,isVisited,xIndex,yIndex));
            }
            
        }
        return dp[i][j]; 
        
    }
}
