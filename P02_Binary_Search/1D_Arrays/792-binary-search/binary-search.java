class Solution {
    /**
     * Approach II : Using Recursive Binary Search (Divide and Conquer) Approach
     *
     * TC: O(log(N))
     * SC: O(log(N))
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        return searchRecursion(nums, target, 0, n - 1); // TC: O(log(N)), SC: O(log(N))
    }

    /**
     * Using Recursive Binary Search (Divide and Conquer) Approach
     *
     * TC: O(log(N))
     * SC: O(log(N)) - recursion stack
     */
    private int searchRecursion(int[] nums, int target, int low, int high) {
        // Base Case
        if (low > high) {
            return -1;
        }
        if (low == high) {
            if (nums[low] == target) {
                return low;
            } else {
                return -1;
            }
        }
        // Recursion Calls
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            // search in it 2nd half
            return searchRecursion(nums, target, mid + 1, high);
        } else {
            // search in it 1st half
            return searchRecursion(nums, target, low, mid - 1);
        }
    }

    /**
     * Approach I : Using Iterative Binary Search Approach
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    public int searchIterative(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
