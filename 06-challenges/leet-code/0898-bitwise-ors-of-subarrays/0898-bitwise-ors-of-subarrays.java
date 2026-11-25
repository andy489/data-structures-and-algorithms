// https://leetcode.com/problems/bitwise-ors-of-subarrays/

// Solution: DP with Set — O(n log(max)) time, O(n log(max)) space
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        for (int x : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(x);
            for (int y : prev) {
                curr.add(x | y);
            }
            res.addAll(curr);
            prev = curr;
        }
        return res.size();
    }
}
