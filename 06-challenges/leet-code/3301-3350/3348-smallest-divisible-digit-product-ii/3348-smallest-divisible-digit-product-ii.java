// https://leetcode.com/problems/smallest-divisible-digit-product-ii/

// Solution: Prime Factorization + Greedy Digit Construction
class Solution {
    // Contribution of each digit (1-9) to prime factors [2, 3, 5, 7]
    static final int[][] CONTRIB = {
        {0, 0, 0, 0}, // 0 (unused)
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {
        // Factorize t
        int[] need = new int[4]; // need[i] = required exponent of prime[i]
        int[] primes = {2, 3, 5, 7};
        long rem = t;
        for (int i = 0; i < 4; i++) {
            while (rem % primes[i] == 0) {
                need[i]++;
                rem /= primes[i];
            }
        }
        if (rem > 1) return "-1"; // t has prime factor other than 2,3,5,7

        int n = num.length();
        char[] digits = num.toCharArray();

        // Try to build answer with exactly n digits
        String res = tryBuild(digits, need, true);
        if (res != null) return res;

        // Need more digits: find minimum extra digits needed
        // Minimum digits to cover need[] using digits 2-9
        // Build the smallest number with n+1, n+2, ... digits
        for (int len = n + 1; len <= n + 50; len++) {
            // We need (len - n) extra digits beyond all-1s to cover need[]
            // Build minimum covering digits greedily
            String s = buildMinLen(len, need);
            if (s != null) return s;
        }
        return "-1";
    }

    private String tryBuild(char[] digits, int[] need, boolean tight) {
        int n = digits.length;
        // Try placing each position with tight constraint
        // remaining[i] = remaining required exponent after current position
        return dfs(digits, need, 0, true, new StringBuilder());
    }

    private String dfs(char[] digits, int[] need, int pos, boolean tight, StringBuilder sb) {
        int n = digits.length;
        if (pos == n) {
            // Check if all needs are met
            for (int x : need) if (x > 0) return null;
            return sb.toString();
        }
        int lo = tight ? (digits[pos] - '0') : 1;
        // digits must be 1-9 (zero-free)
        if (lo == 0) lo = 1; // skip zero even if tight forces it
        for (int d = lo; d <= 9; d++) {
            int[] newNeed = new int[4];
            for (int i = 0; i < 4; i++) {
                newNeed[i] = Math.max(0, need[i] - CONTRIB[d][i]);
            }
            sb.append((char) ('0' + d));
            String res = dfs(digits, newNeed, pos + 1, tight && (d == digits[pos] - '0'), sb);
            if (res != null) return res;
            sb.deleteCharAt(sb.length() - 1);
            if (d == lo && tight) {
                // After trying lo with tight, further digits are free (not tight)
                tight = false;
            }
        }
        return null;
    }

    private String buildMinLen(int len, int[] origNeed) {
        // Build the smallest zero-free number of given length
        // whose digit product is divisible by 2^need[0] * 3^need[1] * 5^need[2] * 7^need[3]
        // Strategy: place covering digits at the end (smallest significant positions),
        // fill the rest with 1s
        // Find minimum list of digits (each 2-9) that covers need[]
        int[] need = origNeed.clone();
        List<Integer> extra = new ArrayList<>();
        // Greedily use 9,8,7,5 (highest contribution digits) to minimize count
        // Actually to minimize number value, we want fewest extra digits placed
        // as small as possible. We use a greedy: pick the digit >= 2 that maximally
        // covers remaining need.
        while (!allZero(need)) {
            int bestD = -1, bestScore = -1;
            int[] bestNeed = null;
            for (int d = 2; d <= 9; d++) {
                int[] after = new int[4];
                int score = 0;
                for (int i = 0; i < 4; i++) {
                    int reduction = Math.min(need[i], CONTRIB[d][i]);
                    score += reduction;
                    after[i] = need[i] - reduction;
                }
                if (score > bestScore) {
                    bestScore = score;
                    bestD = d;
                    bestNeed = after;
                }
            }
            if (bestScore == 0) return null; // cannot reduce
            extra.add(bestD);
            need = bestNeed;
        }
        int extraCount = extra.size();
        if (extraCount > len) return null;
        // Build: (len - extraCount) ones followed by sorted extra digits
        Collections.sort(extra);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - extraCount; i++) sb.append('1');
        for (int d : extra) sb.append((char) ('0' + d));
        return sb.toString();
    }

    private boolean allZero(int[] arr) {
        for (int x : arr) if (x > 0) return false;
        return true;
    }
}
