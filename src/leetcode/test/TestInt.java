package leetcode.test;

public class TestInt {
	public static void main(String[] args) {
		
		int i = 1;
		String s = String.valueOf(i);
		
		long l = (long)(-1)-Integer.MIN_VALUE;
		long x = l/Integer.MAX_VALUE;
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(l);
	}

}
