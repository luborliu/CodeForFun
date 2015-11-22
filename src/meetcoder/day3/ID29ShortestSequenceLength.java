package meetcoder.day3;

public class ID29ShortestSequenceLength {

	public static void main(String[] args) {

	}
	
	public int getShortestSequenceLength(int [] a) {
		
		//two indices to store left and right of the current sequence
		//a pointer walks through the array
		//a boolean flag to store if there is already a sequence
		
		if(a==null||a.length<2) return 0;
		int l = 0;
		int r = 0;
		int max = a[0];
		int min = a[0];

		int p = 1;
		boolean flag = false;
		
		while(p<a.length) {
			if(a[p]>=max) {
				max = a[p];
				if(!flag) {
					r = p;
					l = p;
				}
			} else {
				flag = true;
				r = p;
				while(l>0&&a[l-1]>a[p]) {
					l--;
				}
				if(min>a[p]) min = a[p];
				//if(min>a[l]) min = a[l];
			}
				
			p++;
		}
		int res = r-l+1;
		if(res==1) return 0;
		
		return res;
     }

}
