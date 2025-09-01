class Solution {
    /**
     * Approach : Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int search(int arr[], int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
