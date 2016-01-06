package leetcode.week4;

public class Q278BadVersion {
	
	public int firstBadVersion(int n) {
        //binary search, O(logn) calls to the function      
        // corner case: Integer over flow
        int left = 1;
        int right = n;
        int res = 0;
        while(left<=right) {
            int mid = (int)((double)left/2+(double)right/2); //use (double)left/2+(double)right/2 then convert it to int can prevent from sum bigger than Integer.MAX_VALUE; no idea why this is faster with 18ms while the latter is with 19ms
            //or we can use left+(right-left)/2, this is better without type conversion
            //int mid = left+(right-left)/2;
            if(isBadVersion(mid)) {
                res = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return res;
    }
	/**
	 * fake function for compiling
	 * @param version
	 * @return
	 */
	boolean isBadVersion(int version) {
		return true;
	}

}
