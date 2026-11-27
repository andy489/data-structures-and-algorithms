// https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/
class Solution {
    public long numberOfWeeks(int[] milestones) {
        long max = 0, rest = 0;
        for (int m : milestones) {
            max = Math.max(max, m);
            rest += m;
        }
        rest -= max;
        if (max <= rest + 1) {
            return max + rest;
        } else {
            return 2 * rest + 1;
        }
    }
}
