class Solution {
    /**
     * Approach : Using Array Pre-Processing Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxPrice = new int[n]; // SC: O(N)
        maxPrice[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            maxPrice[i] = Math.max(maxPrice[i + 1], prices[i]);
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            maxValue = Math.max(maxValue, maxPrice[i] - prices[i]); 
        }
        return maxValue;
    }
}
