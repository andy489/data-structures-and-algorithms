// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/

// Solution: HashSet — O(n) time, O(n) space
class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (!seen.add(x)) { return x; }
        }
        return -1;
    }
}
