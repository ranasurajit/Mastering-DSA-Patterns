class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int p = 0; // pointer that will always point to unique elements
        int q = 1; // pointer that will loop till nums[p] = nums[q]
        while (q < n) { // TC: O(N)
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
                q++;
            } else {
                q++;
            }
        }
        return p + 1; // size of the unique array
    }
}
