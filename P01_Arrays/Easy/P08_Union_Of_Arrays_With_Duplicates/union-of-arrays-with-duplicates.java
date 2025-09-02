import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(M + N)
     * SC: O(M + N)
     */
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        Set<Integer> set = new HashSet<Integer>(); // SC: O(M + N)
        for (int ele : a) { // TC: O(M)
            set.add(ele);
        }
        for (int ele : b) { // TC: O(N)
            set.add(ele);
        }
        return new ArrayList<Integer>(set);
    }
}
