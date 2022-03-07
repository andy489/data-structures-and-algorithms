// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// bfs
// Time: O(4^n), where n is the number of digits

class Solution {
    const const vector <string> pad = {
            "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
    };
public:
    vector <string> letterCombinations(string digits) {
        int n = digits.size();
        if (!n) {
            return {};
        }

        vector <string> res;

        queue <string> q;
        q.push("");

        for (char d: digits) {
            int size = q.size();

            while (size--) {
                string out = q.front();
                q.pop();

                for (char c: pad[d - '2']) {
                    q.push(out + c);
                }
            }
        }

        while (!q.empty()) {
            res.push_back(q.front());
            q.pop();
        }

        return res;
    }
};
