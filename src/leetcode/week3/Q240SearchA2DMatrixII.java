package leetcode.week3;

public class Q240SearchA2DMatrixII {
	
	
	//this can be handled in O(m+n) time, check that solution during the 2nd time
	//basically it goes from top right which is easy
	
	//the following solution is not O(log(m*n)) because it did not divide m*n matrix into 2 parts
	//rather, it divided it into four parts and each time it will use the 3 of the four parts to the next iteration
	//discussion:https://leetcode.com/discuss/51108/is-theres-a-o-log-m-log-n-solution-i-know-o-n-m-and-o-m-log-n
	
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) return false;
        return searchMatrixHelper(matrix,target,0,matrix.length-1,0,matrix[0].length-1);
    }
    
    private boolean searchMatrixHelper(int[][] matrix, int target, int r0, int r1, int c0, int c1) {
        if(r0>r1||c0>c1) return false;
        if(matrix[r0][c0]>target||matrix[r1][c1]<target) return false;
        
        int midR = (r0+r1)/2;
        int midC = (c0+c1)/2;
        
        if(matrix[midR][midC]==target) return true;
        else if(matrix[midR][midC]>target) { 
            return searchMatrixHelper(matrix,target,r0,midR-1,c0,c1)||searchMatrixHelper(matrix,target,midR,r1,c0,midC-1);
        } else {
            return searchMatrixHelper(matrix,target,midR+1,r1,c0,midC)||searchMatrixHelper(matrix,target,r0,r1,midC+1,c1);
        }
        
        
    }

}
