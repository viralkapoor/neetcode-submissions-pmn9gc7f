class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable = 0, maxReachableFromHere = 0;

        for(int i=0; i<nums.length && i<=maxReachable; i++) {
            maxReachableFromHere = i+nums[i];
            maxReachable = Math.max(maxReachableFromHere, maxReachable);
            System.out.println(maxReachableFromHere + " " + maxReachable);
        }

        return maxReachable>=nums.length-1 ? true : false;
    }
}
