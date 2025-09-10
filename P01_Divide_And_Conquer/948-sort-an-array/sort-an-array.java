class Solution {
    /**
     * Approach : Using Merge Sort Approach
     *
     * TC: O(N x log(N))
     * SC: O(N) + O(log(N))
     *  - O(N) - auxiliary space
     *  - O(log(N)) - recursion stack
     */
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        return nums;
    }

    /**
     * Using Merge Sort Approach
     *
     * TC: O(N x log(N))
     * SC: O(N) + O(log(N))
     *  - O(N) - auxiliary space
     *  - O(log(N)) - recursion stack
     */
    private void mergeSort(int[] nums, int low, int high) {
        // Base Case
        if (low >= high) {
            // invalid range / case or array with 1 element is sorted by default
            return;
        }
        int mid = low + (high - low) / 2;
        // 1st half
        mergeSort(nums, low, mid);
        // 2nd half
        mergeSort(nums, mid + 1, high);
        /**
         * the above two line guarantees (Recursion Leap of Faith) 
         * that 1st hald and 2nd half portions of array 'nums' 
         * are sorted. now we need to merge the sorted arrays
         */
        mergeSortedArrays(nums, low, mid, high); // TC: O(N), SC: O(N)
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(R) ~ O(N)
     * SC: O(R) ~ O(N)
     *
     * where R = High - Low + 1
     */
    private void mergeSortedArrays(int[] nums, int low, int mid, int high) {
        int[] sorted = new int[high - low + 1]; // SC: O(R)
        int p = low; // pointer at the start of left sorted array
        int q = mid + 1; // pointer at the start of right sorted array
        int r = 0; // pointer at the start of merged sorted array
        while (p <= mid && q <= high) {
            if (nums[p] <= nums[q]) {
                sorted[r] = nums[p];
                p++;
            } else {
                sorted[r] = nums[q];
                q++;
            }
            r++;
        }
        while (p <= mid) {
            sorted[r] = nums[p];
            p++;
            r++;
        }
        while (q <= high) {
            sorted[r] = nums[q];
            q++;
            r++;
        }
        for (p = low; p <= high; p++) { // TC: O(R)
            nums[p] = sorted[p - low];
        }
    }
}
