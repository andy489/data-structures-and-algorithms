// https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/

class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] sizes = new long[n + 1];
        sizes[0] = 1;
        for (int i = 0; i < n; i++) {
            sizes[i + 1] = Math.min(sizes[i] * 2, (long) 2e15);
        }
        int shift = 0;
        for (int i = n - 1; i >= 0; i--) {
            long half = sizes[i];
            if (k > half) {
                k -= half;
                if (operations[i] == 1) {
                    shift++;
                }
            }
        }
        return (char) ('a' + shift % 26);
    }
}
