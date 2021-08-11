// https://leetcode.com/problems/roman-to-integer/
// Time: O(n)

class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> T = {{'I', 1},
                                      {'V', 5},
                                      {'X', 10},
                                      {'L', 50},
                                      {'C', 100},
                                      {'D', 500},
                                      {'M', 1000}};
        int res = T[s.back()], SIZE = s.size();
        for (int i = SIZE - 2; i >= 0; --i)
            if (T[s[i]] < T[s[i + 1]]) res -= T[s[i]];
            else res += T[s[i]];
        return res;
    }
};
