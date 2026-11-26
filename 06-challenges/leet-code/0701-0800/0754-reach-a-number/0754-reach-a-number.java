// https://leetcode.com/problems/reach-a-number/

// Solution: Math / Greedy — O(√target) time, O(1) space
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, k = 0;
        while (sum < target || (sum - target) % 2 != 0) {
            k++;
            sum += k;
        }
        return k;
    }
}
