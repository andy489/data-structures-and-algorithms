// https://leetcode.com/problems/find-target-indices-after-sorting-array/

// Solution: Count Less and Equal — O(n) time, O(1) space
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less = 0, equal = 0;
        for (int x : nums) {
            if (x < target) { less++; }
            else if (x == target) { equal++; }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = less; i < less + equal; i++) { res.add(i); }
        return res;
    }
}
