// https://www.spoj.com/problems/ABCPATH/

import java.util.*;
import java.io.*;

public class Main {
    static final int[] dx = {-1,-1,-1,0,0,1,1,1};
    static final int[] dy = {-1,0,1,-1,1,-1,0,1};

    static class Solution {
        int H, W;
        char[][] grid;
        int[][] dp;

        boolean read(BufferedReader br) throws IOException {
            String line = br.readLine();
            if (line == null) return false;
            StringTokenizer st = new StringTokenizer(line);
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            if (H == 0 && W == 0) return false;
            grid = new char[H][W];
            dp = new int[H][W];
            for (int i = 0; i < H; i++) {
                String row = br.readLine().trim();
                for (int j = 0; j < W; j++) {
                    grid[i][j] = row.charAt(j);
                    dp[i][j] = 1;
                }
            }
            return true;
        }

        int solve() {
            for (char c = 'Y'; c >= 'A'; c--) {
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (grid[i][j] != c) continue;
                        for (int d = 0; d < 8; d++) {
                            int ni = i + dx[d], nj = j + dy[d];
                            if (ni < 0 || ni >= H || nj < 0 || nj >= W) continue;
                            if (grid[ni][nj] == c + 1)
                                dp[i][j] = Math.max(dp[i][j], 1 + dp[ni][nj]);
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < H; i++)
                for (int j = 0; j < W; j++)
                    if (grid[i][j] == 'A')
                        ans = Math.max(ans, dp[i][j]);
            return ans;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Solution s = new Solution();
        int cas = 1;
        while (s.read(br))
            sb.append("Case ").append(cas++).append(": ").append(s.solve()).append("\n");
        System.out.print(sb);
    }
}
