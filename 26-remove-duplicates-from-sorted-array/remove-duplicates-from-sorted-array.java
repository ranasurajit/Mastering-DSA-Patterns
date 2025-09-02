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
        int q = 1;
        while (q < n) { // TC: O(N)
            while (q < n && nums[p] == nums[q]) {
                q++;
            }
            // at this points nums[p] != nums[q]
            if (p < q && q < n) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1; // size of the unique array
    }
}
