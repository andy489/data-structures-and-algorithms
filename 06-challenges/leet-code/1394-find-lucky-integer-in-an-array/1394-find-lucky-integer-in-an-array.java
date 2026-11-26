// https://leetcode.com/problems/find-lucky-integer-in-an-array/

// Solution: Frequency count — O(n) time, O(n) space
class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : arr) freq.merge(v, 1, Integer::sum);
        int ans = -1;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getKey().equals(e.getValue())) ans = Math.max(ans, e.getKey());
        }
        return ans;
    }
}
