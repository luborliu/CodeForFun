package leetcode.week2;

public class Q274HIndex {
	
	public int hIndex(int[] citations) {
        
        //1st idea is to sort array first than loop from back to start
        //2nd idea is from discussion: budingbushizhongguoren
        // that is:
        // use array(length of citations+1) to store the # of appearance of the elements in citations array
        // if the element is bigger than the length of citations, just update arr[length]++ (here is the brilliant part)
        if(citations==null||citations.length==0) return 0;
        int len = citations.length;
        int[] count = new int[len+1];
        
        for(int i:citations) {
            if(i>=len) count[len]++;
            else count[i]++;
        }

        int countTmp = 0;
        for(int j=len; j>=0; j--) {
            countTmp += count[j];
            if(countTmp>=j) return j;
        }
        
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
