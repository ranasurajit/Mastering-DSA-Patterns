class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // store <sum, count(sub-arrays)> in HashMap
        Map<Integer, Integer> hs = new HashMap<Integer, Integer>(); // SC: O(N)
        /**
         * adding sum = 0 with count = 1 to HashMap so that it adds 
         * up the count of sub-arrays starting at index = 0 of array 'arr'
         */
        hs.put(0, 1);
        int sum = 0;
        int i = 0;
        int count = 0;
        while (i < n) { // TC: O(N)
            sum += nums[i];
            int diff = sum - k;
            if (hs.containsKey(diff)) {
                count += hs.get(diff);
            }
            hs.put(sum, hs.getOrDefault(sum, 0) + 1);
            i++;
        }
        return count;
    }
}
