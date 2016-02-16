package lintcode.ladder9.level5;

public class QMaximumSquare {
	
	
	public static void main(String[] args) {
		
		int[][] a = new int[][] {{0,1,1,1,1,1,1,1,1,1},
								 {1,0,1,1,1,1,1,1,1,1},
								 {1,1,0,1,1,1,1,1,1,1},
								 {1,1,1,0,1,1,1,1,1,1},
								 {1,1,1,1,0,1,1,1,1,1},
								 {1,1,1,1,1,0,1,1,1,1},
								 {1,1,1,1,1,1,0,1,1,1},
								 {1,1,1,1,1,1,1,0,1,1},
								 {1,1,1,1,1,1,1,1,0,1},
								 {1,1,1,1,1,1,1,1,1,0}								 
		};
		
		int res = maxSquare(a);
	}
	
	
	/**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public static int maxSquare(int[][] matrix) {
        // write your code here
        //rolling array
        
        if(matrix==null||matrix.length==0) return 0;
        
        int[][] dp = new int[2][matrix[0].length]; //here it stores the length of side not area 
        
        int max = 0; 
        
        for(int i=0; i<matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
            max = Math.max(max,dp[0][i]);
        }
        
        for(int m=1; m<matrix.length; m++) {
            for(int n=0; n<matrix[0].length; n++) {
                
                if(n==0) dp[m%2][n] = matrix[m][n];
                else if(matrix[m][n]==1) {
                    dp[m%2][n] = 1+Math.min(Math.min(dp[(m-1)%2][n],dp[m%2][n-1]),dp[(m-1)%2][n-1]);
                } else {
                	dp[m%2][n] = 0; //cannot lose this line, o gosh!
                }
                
                max = Math.max(max, dp[m%2][n]);
            }
        }
        
        return max*max;
        
    }

}
