// https://leetcode.com/problems/minimum-impossible-or/

// Solution: Check Powers of 2 — O(n) time, O(n) space
class Solution {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int x : nums) {
            numsSet.add(x);
        }
        int power = 1;
        while (numsSet.contains(power)) {
            power <<= 1;
        }
        return power;
    }
}
