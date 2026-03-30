class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0;
        for(int n: nums)
            sum+=n;
            
        if ((target + sum) % 2 != 0 || target + sum < 0 || Math.abs(target) > sum) {
            return 0;
        }
        int subsetSum = (target+sum)/2;
        int dp[][] = new int[nums.length][subsetSum+1];
        for(int row[]: dp) 
            Arrays.fill(row,-1);
        return findSubsetSum(nums, subsetSum, dp, nums.length-1);
    }

    public int findSubsetSum(int []nums, int subsetSum, int dp[][], int i) {
        if(subsetSum==0 && i==-1)
            return 1;
        if(subsetSum<0 || i<0)
            return 0;
        
        if(dp[i][subsetSum]!=-1)
            return dp[i][subsetSum];

        int include = findSubsetSum(nums, subsetSum-nums[i], dp, i-1);
        int exclude = findSubsetSum(nums, subsetSum, dp, i-1);
        dp[i][subsetSum] = include + exclude;

        return dp[i][subsetSum];
    }
}
