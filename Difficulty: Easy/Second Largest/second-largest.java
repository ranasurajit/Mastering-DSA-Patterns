class Solution {
    /**
     * Approach : Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int getSecondLargest(int[] arr) {
        int n = arr.length;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && first != arr[i]) {
                second = arr[i];
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }
}
