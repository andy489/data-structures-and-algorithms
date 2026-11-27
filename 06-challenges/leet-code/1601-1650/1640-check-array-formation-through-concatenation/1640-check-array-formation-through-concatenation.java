// https://leetcode.com/problems/check-array-formation-through-concatenation/

// Solution: HashMap of First Elements — O(n) time, O(n) space
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> byFirst = new HashMap<>();
        for (int[] p : pieces) {
            byFirst.put(p[0], p);
        }
        int i = 0;
        while (i < arr.length) {
            int[] piece = byFirst.get(arr[i]);
            if (piece == null) {
                return false;
            }
            for (int v : piece) {
                if (arr[i++] != v) {
                    return false;
                }
            }
        }
        return true;
    }
}
