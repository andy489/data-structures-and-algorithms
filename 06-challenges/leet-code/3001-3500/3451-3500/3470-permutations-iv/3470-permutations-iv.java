// https://leetcode.com/problems/permutations-iv/

// Solution: Factorial Number System — O(n^2) time, O(n) space
class Solution {
    public long[] permute(int n, long k) {
        // Count alternating permutations
        // count[oddLeft][evenLeft][lastParity]: lastParity 0=odd,1=even,2=none(start)
        // oddLeft = number of odd numbers remaining, evenLeft = number of even numbers remaining
        int oddTotal = (n + 1) / 2;
        int evenTotal = n / 2;
        // Use BigInteger to avoid overflow, then compare with k
        // dp[o][e][p]: count where o=odds left, e=evens left, p=0 means last was odd, 1 means last was even
        // At each step, if lastParity==0 (last was odd), next must be even -> pick from e evens: e ways
        // if lastParity==1 (last was even), next must be odd -> pick from o odds: o ways
        // Total = count(oddLeft, evenLeft, lastParity)
        // count(o, e, 0) = e * count(o, e-1, 1)   [place an even next]
        // count(o, e, 1) = o * count(o-1, e, 0)   [place an odd next]
        // For the first position: can start with odd (oddTotal choices) or even (evenTotal choices)
        // if n==1: only [1], alternating by default

        // Precompute counts as BigInteger capped at k+1
        java.math.BigInteger K = java.math.BigInteger.valueOf(k);
        java.math.BigInteger[][] cntOdd = new java.math.BigInteger[oddTotal + 1][evenTotal + 1]; // last placed was odd
        java.math.BigInteger[][] cntEven = new java.math.BigInteger[oddTotal + 1][evenTotal + 1]; // last placed was even
        java.math.BigInteger CAP = K.add(java.math.BigInteger.ONE);

        for (java.math.BigInteger[] row : cntOdd) java.util.Arrays.fill(row, java.math.BigInteger.ZERO);
        for (java.math.BigInteger[] row : cntEven) java.util.Arrays.fill(row, java.math.BigInteger.ZERO);
        // Base: 0 elements left = 1 way
        cntOdd[0][0] = java.math.BigInteger.ONE;
        cntEven[0][0] = java.math.BigInteger.ONE;

        // Fill DP (after last odd placed: next must be even)
        for (int o = 0; o <= oddTotal; o++) {
            for (int e = 0; e <= evenTotal; e++) {
                // After placing odd: next even choices = e
                if (e > 0) {
                    cntOdd[o][e] = cntEven[o][e - 1].multiply(java.math.BigInteger.valueOf(e)).min(CAP);
                }
                // After placing even: next odd choices = o
                if (o > 0) {
                    cntEven[o][e] = cntOdd[o - 1][e].multiply(java.math.BigInteger.valueOf(o)).min(CAP);
                }
            }
        }

        // Total permutations starting with odd or even
        java.math.BigInteger total = java.math.BigInteger.ZERO;
        if (oddTotal > 0) total = total.add(cntEven[oddTotal - 1][evenTotal].multiply(java.math.BigInteger.valueOf(oddTotal))).min(CAP);
        if (evenTotal > 0) total = total.add(cntOdd[oddTotal][evenTotal - 1].multiply(java.math.BigInteger.valueOf(evenTotal))).min(CAP);
        if (total.compareTo(K) < 0) return new long[0];

        // Build k-th permutation
        long[] result = new long[n];
        boolean[] usedOdds = new boolean[oddTotal + 1];
        boolean[] usedEvens = new boolean[evenTotal + 1];
        int lastParity = -1; // -1 = start
        java.math.BigInteger remaining = K;

        for (int pos = 0; pos < n; pos++) {
            // Determine which numbers can be placed
            // If lastParity == 0 (last odd), must place even; if == 1 (last even), must place odd; if -1, can place either
            boolean canOdd = (lastParity != 0);
            boolean canEven = (lastParity != 1);
            // Collect candidates in sorted order
            List<Long> candidates = new ArrayList<>();
            if (canOdd) for (int i = 1; i <= oddTotal; i++) if (!usedOdds[i]) candidates.add((long)(2*i-1));
            if (canEven) for (int i = 1; i <= evenTotal; i++) if (!usedEvens[i]) candidates.add((long)(2*i));
            Collections.sort(candidates);

            for (long cand : candidates) {
                boolean isOdd = cand % 2 == 1;
                int o2 = oddTotal, e2 = evenTotal;
                for (int i = 1; i <= oddTotal; i++) if (usedOdds[i]) o2--;
                for (int i = 1; i <= evenTotal; i++) if (usedEvens[i]) e2--;
                int remainO = isOdd ? o2 - 1 : o2;
                int remainE = isOdd ? e2 : e2 - 1;
                int np = isOdd ? 0 : 1;
                java.math.BigInteger ways;
                if (remainO == 0 && remainE == 0) {
                    ways = java.math.BigInteger.ONE;
                } else {
                    ways = java.math.BigInteger.ZERO;
                    if (np == 0 && remainE > 0) ways = cntOdd[remainO][remainE].min(CAP);
                    if (np == 1 && remainO > 0) ways = cntEven[remainO][remainE].min(CAP);
                }
                if (remaining.compareTo(ways) <= 0) {
                    result[pos] = cand;
                    if (isOdd) usedOdds[(int)(cand + 1) / 2] = true;
                    else usedEvens[(int)(cand / 2)] = true;
                    lastParity = isOdd ? 0 : 1;
                    break;
                }
                remaining = remaining.subtract(ways);
            }
        }
        return result;
    }
}
