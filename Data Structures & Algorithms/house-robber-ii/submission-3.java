class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int n = nums.length;
        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }

    public int rob(int[] nums, int s, int e) {
        if(e-s==0)
            return nums[s];
        int dp[] = new int[nums.length];
        dp[s] = nums[s];
        dp[s+1] = Math.max(nums[s], nums[s+1]);

        for(int i=s+2; i<=e; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[e];
    }
}
