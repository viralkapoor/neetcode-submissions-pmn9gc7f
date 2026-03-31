class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, maxEndingHere = 0;

        for(int n: nums) {
            maxEndingHere += n;
            maxSum = Math.max(maxSum, maxEndingHere);
            if(maxEndingHere<0)
                maxEndingHere=0;
        }

        return maxSum;
    }
}
