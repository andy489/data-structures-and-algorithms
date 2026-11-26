// https://leetcode.com/problems/number-of-paths-with-max-score/

// Solution: DP — O(n^2) time, O(n^2) space
class Solution {
    static final int MOD = 1_000_000_007;
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] score = new int[n][n];
        int[][] cnt = new int[n][n];
        cnt[n-1][n-1] = 1;
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == n-1 && j == n-1) continue;
                char c = board.get(i).charAt(j);
                if (c == 'X') continue;
                int val = (c == 'E') ? 0 : (c - '0');
                int[] best = new int[]{-1, 0};
                int[][] nexts = {{i+1,j},{i,j+1},{i+1,j+1}};
                for (int[] nx : nexts) {
                    int ni = nx[0], nj = nx[1];
                    if (ni < n && nj < n && cnt[ni][nj] > 0) {
                        if (score[ni][nj] > best[0]) { best[0] = score[ni][nj]; best[1] = cnt[ni][nj]; }
                        else if (score[ni][nj] == best[0]) { best[1] = (best[1] + cnt[ni][nj]) % MOD; }
                    }
                }
                if (best[1] > 0) { score[i][j] = best[0] + val; cnt[i][j] = best[1]; }
            }
        }
        if (cnt[0][0] == 0) return new int[]{0, 0};
        return new int[]{score[0][0], cnt[0][0]};
    }
}
