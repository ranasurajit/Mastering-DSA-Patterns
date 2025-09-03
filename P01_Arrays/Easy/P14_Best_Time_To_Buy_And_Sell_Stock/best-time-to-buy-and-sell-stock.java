class Solution {
    /**
     * Approach II : Using Simulation Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(1)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxValue = Integer.MIN_VALUE;
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            minPrice = Math.min(minPrice, prices[i]);
            maxValue = Math.max(maxValue, prices[i] - minPrice); 
        }
        return maxValue == Integer.MIN_VALUE ? 0 : maxValue;
    }

    /**
     * Approach I : Using Array Pre-Processing Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     */
    public int maxProfitArrayPreProcessing(int[] prices) {
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
