// User function Template for Java

class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        Map<Long, Integer> hs = new HashMap<Long, Integer>(); // SC: O(N)
        int maxLength = 0;
        long sum = 0L;
        int i = 0;
        /**
         * adding sum = 0 at index = -1 so that it adds upto length 
         * starting at index = 0 of array 'arr'
         */
        hs.put(0L, -1); 
        while (i < n) { // TC: O(N)
            sum += (long) arr[i];
            long diff = sum - (long) k;
            if (hs.containsKey(diff)) {
                int currentLength = i - hs.get(diff);
                maxLength = Math.max(maxLength, currentLength);
            }
            /**
             * add sum to HashMap and don't update it if sum is present
             * already as it will decrease the length of subarray 
             * (i - hs.get(diff))
             */
            if (!hs.containsKey(sum)) {
                hs.put(sum, i);
            }
            i++;
        }
        return maxLength;
    }
}
