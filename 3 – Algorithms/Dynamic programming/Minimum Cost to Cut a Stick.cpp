class Solution {
    int dp[102][102] = {};
    const int INF = 1e9;

    int dfs(vector<int> &cuts, int i, int j) {
        if (j - i <= 1) {
            return 0;
        }

        if (!dp[i][j]) {
            dp[i][j] = INF;

            for (auto k = i + 1; k < j; ++k) {
                dp[i][j] = min(dp[i][j], cuts[j] - cuts[i] + dfs(cuts, i, k) + dfs(cuts, k, j));
            }
        }

        return dp[i][j];
    }
    
public:
    int minCost(int n, vector<int> &cuts) {
        cuts.push_back(0);
        cuts.push_back(n);

        sort(begin(cuts), end(cuts));

        return dfs(cuts, 0, cuts.size() - 1);
    }
};