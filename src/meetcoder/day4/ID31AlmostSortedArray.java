package meetcoder.day4;

public class ID31AlmostSortedArray {
	
		public static void main(String[] args) {
			
			int[] x = new int[]{1,2,3,4,5};
	        int[] a = {2,2,10,2};
//	        int[] a = {2,2,10,2,2};
//	        int[] a = {1,2,1,2,2};
//	        int[] a = {1,1,3,3,3};
//	        int[] a = {3,3,2,2};
//	        int[] a = {3,2,2};
//	        int[] a = {};
	        
	        System.out.println(isAlmostSorted(x));
	        System.out.println(isAlmostSorted(a));
		}

		public static boolean isAlmostSorted(int [] a) {
			
			//confusing description
			
			if(a==null||a.length<2) return true;
			//int l = 0;
			//int r = a.length-1;
			
			int curVal = a[0];
			int leftIndex = 0;
			for(int l=1; l<a.length; l++) {
				if(a[l]>curVal) {
					curVal = a[l];
					leftIndex = l;
				} else if(a[l]==curVal) {
					continue;
				} else {
					break;
				}
				
			}
			
			curVal = a[a.length-1];
			int rightIndex = a.length-1;
			for(int r=a.length-2; r>=0; r--) {
				if(a[r]<curVal) {
					curVal = a[r];
					rightIndex = r;
				} else if(a[r]==curVal) {
					continue;
				} else {
					break;
				}
				
			}
			if(leftIndex>=rightIndex) return true;
			
			swap(a, leftIndex, rightIndex);
			if(isSorted(a,leftIndex,rightIndex)) return true;
			
			sortSubArray(a, leftIndex+1,rightIndex-1);
			return isSorted(a,0,a.length-1);

		}
		
		public static void sortSubArray(int[] a, int i, int j) {
			if(i==j) return;
			while(i<j) {
				swap(a, i, j);
				i++;
				j--;
			}
		
		}
		
		//to see if the subarray is sorted
		public static boolean isSorted(int[] a, int i, int j) {
			int prev = a[i];
			for(int m=i+1; m<=j; m++) {
				if(a[m]<prev) return false;
				else prev=a[m];
			}
			return true;
		}
		
		public static void swap(int[] a, int i, int j) {
			if(i==j) return;
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
			return;
		}
	

}
