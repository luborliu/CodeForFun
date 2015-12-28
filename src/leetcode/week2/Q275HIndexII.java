package leetcode.week2;

public class Q275HIndexII {

	public static void main(String[] args) {

	}
	
	public static int hIndex(int[] citations) {
        
        //binary search
        if(citations==null||citations.length==0) return 0;
        
        int left = 0;
        int right = citations.length-1;
        //int mid = (left+right)/2;
        int curH = 0;
        int len = citations.length;
        
        
        while(left<=right) {
            int mid = (left+right)/2;
            if(citations[mid]==len-mid) return len-mid;
            if(citations[mid]<len-mid) {
                left = mid+1;
                curH = Math.max(curH, citations[mid]);
            } else {
                right = mid-1;
                curH = Math.max(curH, len-mid);
            }
            
        }
        return curH;
    }

}
