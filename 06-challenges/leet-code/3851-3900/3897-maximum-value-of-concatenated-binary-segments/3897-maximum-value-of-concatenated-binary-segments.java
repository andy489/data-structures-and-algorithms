// https://leetcode.com/problems/maximum-value-of-concatenated-binary-segments/
class Solution {
    private static final long MOD = 1_000_000_007L;

    private long pow2(long exp) {
        long result = 1L;
        long base = 2L;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }

    public int maximumValue(int[] nums1, int[] nums0) {
        int n = nums1.length;
        // Each segment: (ones, zeros) -> value = (2^ones - 1) * 2^zeros, length = ones + zeros
        // Sort: segment A before B if A*2^len(B) + B > B*2^len(A) + A
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> {
            int onesA = nums1[a], zerosA = nums0[a];
            int onesB = nums1[b], zerosB = nums0[b];
            int lenA = onesA + zerosA, lenB = onesB + zerosB;
            // Compare: valA * 2^lenB + valB vs valB * 2^lenA + valA
            // Use long arithmetic for small values comparison
            long valA = (onesA > 0) ? ((1L << onesA) - 1) * (1L << zerosA) : 0;
            long valB = (onesB > 0) ? ((1L << onesB) - 1) * (1L << zerosB) : 0;
            // For large values, compare via double (approximate but good enough for sorting)
            double scoreA = valA * Math.pow(2, lenB) + valB;
            double scoreB = valB * Math.pow(2, lenA) + valA;
            return Double.compare(scoreB, scoreA);
        });

        long result = 0;
        for (int idx : indices) {
            int ones = nums1[idx], zeros = nums0[idx];
            int len = ones + zeros;
            long pow = pow2(len);
            // Segment value = (2^ones - 1) * 2^zeros
            long segVal = (pow2(ones) - 1 + MOD) % MOD * pow2(zeros) % MOD;
            result = (result * pow % MOD + segVal) % MOD;
        }
        return (int)result;
    }
}
