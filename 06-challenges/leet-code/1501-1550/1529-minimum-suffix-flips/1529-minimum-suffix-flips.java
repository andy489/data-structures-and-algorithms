// https://leetcode.com/problems/minimum-suffix-flips/

// Solution: Greedy Transition Count — O(n) time, O(1) space
class Solution {
    public int minFlips(String target) {
        int flips = 0;
        char current = '0';
        for (char c : target.toCharArray()) {
            if (c != current) {
                flips++;
                current = c;
            }
        }
        return flips;
    }
}
