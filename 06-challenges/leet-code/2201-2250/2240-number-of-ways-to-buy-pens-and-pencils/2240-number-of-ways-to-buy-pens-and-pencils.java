// https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/

class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ways = 0;
        for (int pens = 0; pens * cost1 <= total; pens++) {
            int remaining = total - pens * cost1;
            ways += remaining / cost2 + 1;
        }
        return ways;
    }
}
