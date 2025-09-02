class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int unique = 0;
        for (int item : nums) { // TC: O(N)
            unique ^= item;
        }
        return unique;
    }
}
