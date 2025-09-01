class Solution {
    /**
     * Approach : Using Two Pointers Approach
     * 
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     */
    public void reverseArray(int arr[]) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start < end) { // TC: O(N / 2)
            // swap arr[start] with arr[end]
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
}
