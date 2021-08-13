// backtracking
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Time: O(4^n), where n is the number of digits

class Solution {
    vector <string> res;
    string word;
    int n, convert[10] = {0, 3, 6, 9, 12, 15, 19, 22, 26};
public:
    vector <string> letterCombinations(string &digits) {
        n = digits.size();
        if (!n) return {};
        function<void(int)> backtrack = [&](int i) {
            if (i == n) {
                res.push_back(word);
                return;
            }
            int tmp = digits[i] - '2';
            for (int j = convert[tmp]; j < convert[tmp + 1]; ++j) {
                word.push_back('a' + j);
                backtrack(i + 1);
                word.pop_back();
            }
        };
        backtrack(0);
        return res;
    }
};
