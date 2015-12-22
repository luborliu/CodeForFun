package leetcode.week1;

public class Q309BestTimeToBuyAndSellWithCoolDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int[] prices) {
        //DP:
        //better method using two transition functions
        //this is genius but hard for me to think of
        //buy[i] =max(sell[i-2]-prices[i],buy[i-1])
        //sell[i]=max(buy[i-1]+prices[i],sell[i-1])
        
        //O(1) space, O(n) time
        int prev_sell=0;
        int sell=0;
        int buy= Integer.MIN_VALUE;
        int prev_buy;
        
        for(int i:prices) {
            prev_buy=buy;
            buy = Math.max(prev_sell-i,prev_buy);
            prev_sell=sell;
            sell = Math.max(prev_buy+i,prev_sell);
        }
        return sell;
    }

}
