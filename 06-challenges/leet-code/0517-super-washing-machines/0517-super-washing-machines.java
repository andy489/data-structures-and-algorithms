// https://leetcode.com/problems/super-washing-machines/

class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int m : machines) {
            total += m;
        }
        int n = machines.length;
        if (total % n != 0) {
            return -1;
        }
        int avg = total / n;
        int ans = 0, prefixSum = 0;
        for (int m : machines) {
            int balance = m - avg;
            prefixSum += balance;
            ans = Math.max(ans, Math.max(Math.abs(prefixSum), balance));
        }
        return ans;
    }
}
