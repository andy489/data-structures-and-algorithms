// https://leetcode.com/problems/binary-prefix-divisible-by-5/

// Solution: Running Modulo — O(n) time, O(1) space
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int cur = 0;
        for (int b : nums) {
            cur = (cur * 2 + b) % 5;
            result.add(cur == 0);
        }
        return result;
    }
}
