class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC: O(3 x (N / 2)) ~ O(N)
     * SC: O(1)
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0 || n == 1) {
            return;
        }
        reverse(nums, 0, n - 1); // TC: O(N / 2)
        reverse(nums, 0, k - 1); // TC: O(N / 2)
        reverse(nums, k, n - 1); // TC: O(N / 2)
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(N / 2)
     * SC: O(1)
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
