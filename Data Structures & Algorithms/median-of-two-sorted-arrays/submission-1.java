class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;

        if(total==0)
            return -1;
        
        if(total%2!=0)
            return kthElement(nums1, 0, nums2, 0, total/2+1);
        else {
            int left = kthElement(nums1, 0, nums2, 0, total/2);
            int right = kthElement(nums1, 0, nums2, 0, total/2+1);

            return (left+right)/2.0;
        }
    }

    public int kthElement(int[] nums1, int start1, int []nums2, int start2, int k) {
        int remaining = (nums1.length-start1) + (nums2.length-start2);

        if(k<1 && k>remaining)
            return -1;
        
        if(start1 >= nums1.length)
            return nums2[start2+k-1];

        if(start2 >= nums2.length)
            return nums1[start1+k-1];
        
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        int i = Math.min(nums1.length-start1, k/2);
        int j = Math.min(nums2.length-start2, k/2);

        int one = nums1[start1+i-1];
        int two = nums2[start2+j-1];

        if(one<=two) {
            return kthElement(nums1, start1+i, nums2, start2, k-i);
        } else {
            return kthElement(nums1, start1, nums2, start2+j, k-j);
        }
    }
}
