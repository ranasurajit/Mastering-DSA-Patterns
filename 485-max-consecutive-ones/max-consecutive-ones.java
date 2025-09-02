class Solution {
    /**
     * Approach : Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxOnes = 0;
        int currentOnes = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] == 1) {
                currentOnes++;
                maxOnes = Math.max(maxOnes, currentOnes);
            } else {
                currentOnes = 0;
            }
        }
        return maxOnes;
    }
}
