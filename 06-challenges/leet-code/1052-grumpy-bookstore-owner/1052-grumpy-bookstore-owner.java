// https://leetcode.com/problems/grumpy-bookstore-owner/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int base = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                base += customers[i];
            }
        }
        int extra = 0;
        for (int i = 0; i < minutes; i++) {
            extra += customers[i] * grumpy[i];
        }
        int maxExtra = extra;
        for (int i = minutes; i < customers.length; i++) {
            extra += customers[i] * grumpy[i];
            extra -= customers[i - minutes] * grumpy[i - minutes];
            maxExtra = Math.max(maxExtra, extra);
        }
        return base + maxExtra;
    }
}
