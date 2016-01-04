package leetcode.test;

public class TestStringBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		//sb.append(1);
		sb.insert(0,2);
		sb.insert(0,3);
		System.out.println(sb.toString());
		
		sb.length();
		
		StringBuilder sb2 = new StringBuilder(sb);

	}

}
