package leetcode.week2;

public class Q304NumMatrix {
	
	//this one needs patience to its detailed corner cases
	// -one method to make it more readable and clean is to use more space for the sumArr
	// -that is to avoid sumArr[-1][?] or sum[?][-1] issue (index out of bound)

	// idea is similar to 1d range sum
    // use 2d array to store the sum of the left up area
    // to calculate we can use the following formula
    // sum(r1,c1,r2,c2) = sum[r2,c2]-sum[r1-1,c2]-sum[r2,c1-1]+sum[r1-1,c1-1]
    
    // point 2: use dp to innitialize sumArr
    // sumArr[i,j] = sumArr[i-1,j]+sumArr[i,j-1]-sumArr[i-1,j-1]+num[i,j];
    
    int[][] sumArr = null;

    public Q304NumMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        
        sumArr = new int[rowLen][colLen];
        sumArr[0][0] = matrix[0][0];
        
        for(int i=1; i<colLen; i++) {
            sumArr[0][i] = sumArr[0][i-1]+matrix[0][i];
        }
        for(int j=1; j<rowLen; j++) {
            sumArr[j][0] = sumArr[j-1][0]+matrix[j][0];
        }
        for(int i=1; i<rowLen; i++) {
            for(int j=1; j<colLen; j++) {
                sumArr[i][j] = sumArr[i-1][j]+sumArr[i][j-1]-sumArr[i-1][j-1]+matrix[i][j];
            }
        }
        
        
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1==0&&col1==0) return this.sumArr[row2][col2];
        if(row1==0) return this.sumArr[row2][col2]-this.sumArr[row2][col1-1];   //pay attention to [row2] rather than row1
        if(col1==0) return this.sumArr[row2][col2]-this.sumArr[row1-1][col2];   //pay attention to [col2] rather than col1
        return this.sumArr[row2][col2]-this.sumArr[row1-1][col2]-this.sumArr[row2][col1-1]+this.sumArr[row1-1][col1-1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);

