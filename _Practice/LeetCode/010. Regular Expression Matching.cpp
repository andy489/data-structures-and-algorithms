// Dynamic Programming
// https://leetcode.com/problems/regular-expression-matching/
// Time: O(n*m), Space: O(n*m)

class Solution {

public:
    bool isMatch(string &s, string &p) { // Top-Down Memoization
        int n = s.size(), m = p.size();
        vector <vector<short>> cache(n + 1, vector<short>(m, -1));

        function<bool(int, int)> dfs = [&](int i, int j) { // nested function (avoiding variable passing)
            if (i <= n && j < m && cache[i][j] >= 0) { // check if it is already in the cache
                return (bool) cache[i][j];
            }
            if (j >= m) { // if we read the pattern string
                return i >= n; // check if we also read the string for matching
            }
            // index i could be technically out of bounds here (that's why cache rows are n+1)
            bool match = (i < n && (s[i] == p[j] || p[j] == '.'));
            // * has the highest precedence (we hendle * first)
            if (j + 1 < m && p[j + 1] == '*') {
                return (bool) (cache[i][j] = (dfs(i, j + 2) // don't use *
                                              || (match && dfs(i + 1, j)))); // use *
            }
            if (match) { // simple match of one character
                return (bool) (cache[i][j] = dfs(i + 1, j + 1));
            }
            return (bool) (cache[i][j] = false);
        };
        return dfs(0, 0);
    }
};
