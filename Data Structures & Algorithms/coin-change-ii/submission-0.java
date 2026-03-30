class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return change(amount, coins, dp, coins.length-1);
    }

    public int change(int amount, int[] coins, int dp[][], int i) {
        if(amount==0)
            return 1;
        if(amount<0 || i<0)
            return 0;
        
        if(dp[i][amount-1]!=-1)
            return dp[i][amount-1];
        int include = change(amount-coins[i], coins, dp, i);
        dp[i][amount-1] = include;
        int exclude = change(amount, coins, dp, i-1);
        dp[i][amount-1] += exclude;
        System.out.println(i + " " + amount + " " + dp[i][amount-1]);
        return dp[i][amount-1];
    }
}
