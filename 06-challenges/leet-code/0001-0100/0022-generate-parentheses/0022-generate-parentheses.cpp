// https://leetcode.com/problems/generate-parentheses/

// Solution: Backtracking — O(4ⁿ / √n) time, O(n) space
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> result;
        backtrack(result, "", 0, 0, n);
        return result;
    }

private:
    void backtrack(vector<string>& result, string s, int open, int close, int n) {
        if ((int)s.size() == 2 * n) {
            result.push_back(s);
            return;
        }
        if (open < n) {
            backtrack(result, s + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(result, s + ")", open, close + 1, n);
        }
    }
};
