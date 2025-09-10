// User function Template for Java
// User function Template for Java

/*
class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

Java users need to return result in Pair class
For Example -> return new Pair(minimum,maximum)
*/

class Solution {
    /**
     * Approach II : Using Divide and Conquer Approach
     * 
     * TC: O(N)
     * SC: O(log(N))
     * 
     * Recurrence Relation is T(n) = T(n / 2) + T(n / 2) + 2
     */
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        int n = arr.length;
        return solveRecursion(arr, 0, n - 1);
    }
    
    /**
     * Using Divide and Conquer Approach
     * 
     * TC: O(N)
     * SC: O(log(N))
     * 
     * Recurrence Relation is T(n) = T(n / 2) + T(n / 2) + 2
     */
    private Pair<Integer, Integer> solveRecursion(int[] arr, int low, int high) {
        // Base Case
        if (low > high) {
            // not a valid range
            return new Pair<Integer, Integer>(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        if (low == high) {
            return new Pair<Integer, Integer>(arr[low], arr[low]);
        }
        // Recursion Calls
        int mid = low + (high - low) / 2;
        Pair<Integer, Integer> left = solveRecursion(arr, low, mid);
        Pair<Integer, Integer> right = solveRecursion(arr, mid + 1, high);
        int min = Math.min(left.getKey(), right.getKey());
        int max = Math.max(left.getValue(), right.getValue());
        return new Pair(min, max);
    }
    
    /**
     * Approach I : Using Linear Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public Pair<Integer, Integer> getMinMaxLinear(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int it : arr) { // TC: O(N)
            min = Math.min(min, it);
            max = Math.max(max, it);
        }
        return new Pair(min, max);
    }
}
