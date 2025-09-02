class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            missing ^= nums[i];
            missing ^= i;
        }
        return missing ^ n;
    }
}
