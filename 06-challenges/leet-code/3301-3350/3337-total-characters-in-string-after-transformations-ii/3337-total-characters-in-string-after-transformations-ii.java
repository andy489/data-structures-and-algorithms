// https://leetcode.com/problems/total-characters-in-string-after-transformations-ii/

class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int SIZE = 26;

    private long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < SIZE; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    private long[][] matPow(long[][] M, int p) {
        long[][] result = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            result[i][i] = 1; // identity
        }
        while (p > 0) {
            if ((p & 1) == 1) {
                result = multiply(result, M);
            }
            M = multiply(M, M);
            p >>= 1;
        }
        return result;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        // Build transformation matrix
        long[][] M = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            int cnt = nums.get(i);
            for (int j = 1; j <= cnt; j++) {
                M[(i + j) % SIZE][i] = (M[(i + j) % SIZE][i] + 1) % MOD;
            }
        }
        // Compute M^t
        long[][] Mt = matPow(M, t);
        // Build initial frequency vector
        long[] freq = new long[SIZE];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        // Apply Mt * freq
        long ans = 0;
        for (int i = 0; i < SIZE; i++) {
            long sum = 0;
            for (int j = 0; j < SIZE; j++) {
                sum = (sum + Mt[i][j] * freq[j]) % MOD;
            }
            ans = (ans + sum) % MOD;
        }
        return (int) ans;
    }
}
