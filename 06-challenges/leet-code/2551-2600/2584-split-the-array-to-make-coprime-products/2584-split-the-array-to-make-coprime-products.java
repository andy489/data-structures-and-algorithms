// https://leetcode.com/problems/split-the-array-to-make-coprime-products/

class Solution {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> firstSeen = new HashMap<>();
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int p = 2; (long) p * p <= x; p++) {
                if (x % p == 0) {
                    firstSeen.putIfAbsent(p, i);
                    lastSeen.put(p, i);
                    while (x % p == 0) {
                        x /= p;
                    }
                }
            }
            if (x > 1) {
                firstSeen.putIfAbsent(x, i);
                lastSeen.put(x, i);
            }
        }

        int maxRight = 0;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i];
            for (int p = 2; (long) p * p <= x; p++) {
                if (x % p == 0) {
                    maxRight = Math.max(maxRight, lastSeen.get(p));
                    while (x % p == 0) {
                        x /= p;
                    }
                }
            }
            if (x > 1) {
                maxRight = Math.max(maxRight, lastSeen.get(x));
            }
            if (maxRight == i) {
                return i;
            }
        }
        return -1;
    }
}
