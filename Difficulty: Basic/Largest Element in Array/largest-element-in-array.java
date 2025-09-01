class Solution {
    /**
     * Approach : Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public static int largest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int item : arr) { // TC: O(N)
            max = Math.max(max, item);
        }
        return max;
    }
}
