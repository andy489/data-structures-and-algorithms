// https://leetcode.com/problems/minimum-operations-to-transform-array-into-alternating-prime/
class Solution {
    private static final int LIMIT = 200010;
    private static final boolean[] isComposite = new boolean[LIMIT];
    private static final int[] nextPrime = new int[LIMIT];
    private static final int[] nextComposite = new int[LIMIT];

    static {
        // Sieve of Eratosthenes
        isComposite[0] = true;
        isComposite[1] = true;
        for (int i = 2; i < LIMIT; i++) {
            if (!isComposite[i]) {
                for (long j = (long)i * i; j < LIMIT; j += i) {
                    isComposite[(int)j] = true;
                }
            }
        }

        // Build nextPrime array
        nextPrime[LIMIT - 1] = -1;
        for (int i = LIMIT - 2; i >= 0; i--) {
            if (!isComposite[i]) {
                nextPrime[i] = i;
            } else {
                nextPrime[i] = nextPrime[i + 1];
            }
        }

        // Build nextComposite array (non-prime includes 0,1 and composites)
        nextComposite[LIMIT - 1] = -1;
        for (int i = LIMIT - 2; i >= 0; i--) {
            if (isComposite[i]) {
                nextComposite[i] = i;
            } else {
                nextComposite[i] = nextComposite[i + 1];
            }
        }
    }

    public long minimumOperations(int[] nums) {
        long ops = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                // Need prime
                ops += nextPrime[nums[i]] - nums[i];
            } else {
                // Need non-prime (composite or 0 or 1)
                ops += nextComposite[nums[i]] - nums[i];
            }
        }
        return ops;
    }
}
