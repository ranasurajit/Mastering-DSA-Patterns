class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) { // TC: O(N)
            if (nums[mid] == 0) {
                swap(nums, low, mid); // TC: O(1)
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high); // TC: O(1)
                high--;
            }
        }
    }

    /**
     * Using Simulation Approach
     *
     * TC: O(1)
     * SC: O(1)
     */
    private void swap(int[] nums, int p, int q) {
        int temp = nums[q];
        nums[q] = nums[p];
        nums[p] = temp;
    }
}
