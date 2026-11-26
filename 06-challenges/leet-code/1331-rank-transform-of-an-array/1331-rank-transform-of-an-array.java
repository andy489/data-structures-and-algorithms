// https://leetcode.com/problems/rank-transform-of-an-array/

// Solution: Sort + Map — O(n log n) time, O(n) space
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 1;
        for (int v : sorted) {
            if (!ranks.containsKey(v)) ranks.put(v, rank++);
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) ans[i] = ranks.get(arr[i]);
        return ans;
    }
}
