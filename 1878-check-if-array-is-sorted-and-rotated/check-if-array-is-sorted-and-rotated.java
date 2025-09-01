class Solution {
    /**
     * Approach : Using Simulation Approach
     *
     * Intuition:
     * - If an array is sorted and then rotated, the sequence will be non-decreasing everywhere,
     *   except possibly at one "break point" (a peak) where nums[i] > nums[i+1].
     * - For example:
     *      [3,4,5,1,2] → only one break at 5 > 1 → valid
     *      [2,1,3,4] → two breaks (2>1 and 4>2) → not valid
     * - Therefore, the array can have at most 1 such "peak" to be considered sorted & rotated.
     * 
     * Hint:
     * - Traverse the array and count how many times nums[i] > nums[(i+1) % n].
     * - If the count of such peaks is <= 1 → return true, otherwise false.
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean check(int[] nums) {
        int n = nums.length;
        /**
         * If the array 'nums' is sorted and rotated then there can be atmost
         * 1 peak between any index 'i' and 'i + 1 % n' (for rotated)
         */
        int peaks = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] > nums[(i + 1) % n]) {
                peaks++;
            }
        }
        return peaks <= 1;
    }
}
