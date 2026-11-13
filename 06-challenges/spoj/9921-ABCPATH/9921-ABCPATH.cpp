// https://www.spoj.com/problems/ABCPATH/

#include <bits/stdc++.h>
using namespace std;

const int dx[] = {-1,-1,-1,0,0,1,1,1};
const int dy[] = {-1,0,1,-1,1,-1,0,1};

struct Solution {
    int H, W;
    char grid[55][55];
    int dp[55][55];

    bool read() {
        cin >> H >> W;
        if (!H && !W) return false;
        for (int i = 0; i < H; i++)
            cin >> grid[i];
        return true;
    }

    int solve() {
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                dp[i][j] = 1;

        for (char c = 'Y'; c >= 'A'; c--) {
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (grid[i][j] != c) continue;
                    for (int d = 0; d < 8; d++) {
                        int ni = i + dx[d], nj = j + dy[d];
                        if (ni < 0 || ni >= H || nj < 0 || nj >= W) continue;
                        if (grid[ni][nj] == c + 1)
                            dp[i][j] = max(dp[i][j], 1 + dp[ni][nj]);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                if (grid[i][j] == 'A')
                    ans = max(ans, dp[i][j]);
        return ans;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    Solution s;
    int cas = 1;
    while (s.read())
        cout << "Case " << cas++ << ": " << s.solve() << "\n";
    return 0;
}
