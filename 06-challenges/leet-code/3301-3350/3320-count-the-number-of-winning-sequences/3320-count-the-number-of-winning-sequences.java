// https://leetcode.com/problems/count-the-number-of-winning-sequences/

class Solution {
    public int countWinningSequences(String s) {
        final long MOD = 1_000_000_007L;
        int n = s.length();
        // score map: creature -> score when Alice plays s[i]
        // F=0, W=1, E=2
        // F beats E (+1 for Bob if Bob=F,Alice=E), W beats F, E beats W
        // delta[bobCreature][aliceCreature]: +1 if Bob wins, -1 if Alice wins, 0 tie
        int[][] delta = new int[3][3];
        // F(0) beats E(2): delta[0][2]=+1, E beats F: delta[2][0]=-1
        // W(1) beats F(0): delta[1][0]=+1, F beats W: delta[0][1]=-1
        // E(2) beats W(1): delta[2][1]=+1, W beats E: delta[1][2]=-1
        delta[0][2] = 1; delta[2][0] = -1;
        delta[1][0] = 1; delta[0][1] = -1;
        delta[2][1] = 1; delta[1][2] = -1;

        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('F', 0); charMap.put('W', 1); charMap.put('E', 2);

        // dp[last][score+n] = ways
        int offset = n;
        long[][] dp = new long[3][2 * n + 1];
        int alice0 = charMap.get(s.charAt(0));
        for (int c = 0; c < 3; c++) {
            int d = delta[c][alice0];
            dp[c][d + offset]++;
        }
        for (int i = 1; i < n; i++) {
            long[][] ndp = new long[3][2 * n + 1];
            int alice = charMap.get(s.charAt(i));
            for (int last = 0; last < 3; last++) {
                for (int sc = 0; sc <= 2 * n; sc++) {
                    if (dp[last][sc] == 0) {
                        continue;
                    }
                    for (int c = 0; c < 3; c++) {
                        if (c == last) {
                            continue;
                        }
                        int d = delta[c][alice];
                        int nsc = sc + d;
                        if (nsc >= 0 && nsc <= 2 * n) {
                            ndp[c][nsc] = (ndp[c][nsc] + dp[last][sc]) % MOD;
                        }
                    }
                }
            }
            dp = ndp;
        }
        long result = 0;
        for (int c = 0; c < 3; c++) {
            for (int sc = offset + 1; sc <= 2 * n; sc++) {
                result = (result + dp[c][sc]) % MOD;
            }
        }
        return (int) result;
    }
}
