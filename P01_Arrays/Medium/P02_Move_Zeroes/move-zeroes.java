class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeroIdx = 0; // pointer at zero element
        int idx = 0; // pointer at non-zero element
        while (idx < n) { // TC: O(N)
            if (nums[idx] == 0) {
                idx++;
            } else {
                // swap nums[idx] with nums[zeroIdx]
                int temp = nums[zeroIdx];
                nums[zeroIdx] = nums[idx];
                nums[idx] = temp;
                zeroIdx++;
                idx++;
            }
        }
    }
}
