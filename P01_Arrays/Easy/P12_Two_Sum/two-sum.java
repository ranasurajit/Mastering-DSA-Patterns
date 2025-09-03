class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hs = new HashMap<Integer, Integer>(); // SC: O(N)
        int i = 0;
        while (i < n) { // TC: O(N)
            int diff = target - nums[i];
            if (hs.containsKey(diff)) {
                return new int[] { hs.get(diff), i };
            } else {
                hs.put(nums[i], i);
            }
            i++;
        }
        return new int[] { -1, -1 };
    }
}
