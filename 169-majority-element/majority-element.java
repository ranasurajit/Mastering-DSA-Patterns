class Solution {
    /**
     * Approach : Using Moore's Voting Algorithm Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(1)
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int element = Integer.MIN_VALUE;
        int i = 0;
        int count = 0;
        while (i < n) { // TC: O(N)
            if (element != nums[i]) {
                if (count == 0) {
                    element = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            } else {
                count++;
            }
            i++;
        }
        // the currently set element value can be majority element
        count = 0;
        for (i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] == element) {
                count++;
            }
        }
        if (count > n / 2) {
            return element;
        }
        return -1;
    }
}
