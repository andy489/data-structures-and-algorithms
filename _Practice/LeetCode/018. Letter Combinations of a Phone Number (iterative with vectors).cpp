// iterative with vectors
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Time: O(4^n), where n is the number of digits

class Solution {
    const vector <string> pad = {
            "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
    };
    int n;
    vector <string> res;
public:
    vector <string> letterCombinations(string digits) {
        n = digits.size();
        if (!n) return {};
        res.push_back("");
        for (char d:digits) {
            vector <string> tmp;
            for (char candidate: pad[d - '2']) {
                for (string s: res) {
                    tmp.push_back(s + candidate);
                }
            }
            res.swap(tmp);
        }
        return res;
    }
};
