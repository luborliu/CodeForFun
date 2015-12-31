package leetcode.week3;

import java.util.ArrayList;
import java.util.List;

public class Q241DifferentWaysToAddParentheses {
	
	List<Integer>[][] memo; 
    
    public List<Integer> diffWaysToCompute(String input) {
        //a memorization method: use array to store all possible outputs from i to j
        //the following conversion from String to two arrayLists needs to be optimized, it looks not concise
        
        
        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Character> operators = new ArrayList<Character>();
        
        int pL = 0; 
        int pF = 1;
        while(pF<=input.length()) {
            if(pF==input.length()) {
                nums.add(Integer.parseInt(input.substring(pL,pF)));
                break;
            }
            if(input.charAt(pF)=='+'||input.charAt(pF)=='-'||input.charAt(pF)=='*') {
                operators.add(input.charAt(pF));
                nums.add(Integer.parseInt(input.substring(pL,pF)));
                pL=pF+1;
                pF++;
            }
            pF++;    
        }
        int len = nums.size();
        memo = new List[len][len];
        return diffWaysHelper(nums,operators,0,len-1);   
    }
    
    private List<Integer> diffWaysHelper(ArrayList<Integer> input, ArrayList<Character> operators, int l, int r) {
        List<Integer> res = new ArrayList<Integer>();
        if(l==r) {
            res.add(input.get(l));
            memo[l][l]=res;
            return res;
        }
        for(int i=l; i<r; i++) {
            if(memo[l][i]==null) memo[l][i] = diffWaysHelper(input,operators,l,i);
            if(memo[i+1][r]==null)  memo[i+1][r] = diffWaysHelper(input,operators,i+1,r);
            char op=operators.get(i);
            for(int num_l:memo[l][i]) {
                for(int num_r:memo[i+1][r]) {
                    if(op=='+') res.add(num_l+num_r);
                    else if(op=='-') res.add(num_l-num_r);
                    else res.add(num_l*num_r);
                }
            }
             
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
