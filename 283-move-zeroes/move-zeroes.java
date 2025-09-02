class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int p = 0; // pointer at zero element
        int q = 1; // pointer at non-zero element
        while (p < n && q < n) { // TC: O(N)
            while (p < n && nums[p] != 0) {
                p++;
            }
            while (q < n && nums[q] == 0) {
                q++;
            }
            if (p < q && q < n) {
                // swap
                int temp = nums[q];
                nums[q] = nums[p];
                nums[p] = temp;
                p++;
            }
            q++;
        }
    }
}
