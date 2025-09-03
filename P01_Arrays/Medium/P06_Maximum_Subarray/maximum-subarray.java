class Solution {
    /**
     * Approach : Using Kadane's Algorithm Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int i = 0;
        while (i < n) { // TC: O(N)
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
            i++;
        }
        return maxSum;
    }
}
