// Brute force
// https://leetcode.com/problems/longest-palindromic-substring/
// Time: O(n^2)

class Solution {
private:
    int substrLength(pair<int, int> substr) {
        return substr.second - substr.first + 1;
    }

    pair<int, int> expandPalindrome(string &s, int l, int r) {
        int SIZE - s.size();
        while (0 <= l && r < SIZE && s[l] == s[r]) { l--, r++; }
        return {l + 1, r};
    }
    
public:
    string longestPalindrome(string s) {
        int SIZE = s.size();
        pair<int, int> lps = {0, 0};
        for (int i = 0; i < SIZE; ++i) {
            pair<int, int> odd = expandPalindrome(s, i, i);
            pair<int, int> even = expandPalindrome(s, i, i + 1);
            if (substrLength(lps) < substrLength(odd)) {
                lps = odd;
            }
            if (substrLength(lps) < substrLength(even)) {
                lps = even;
            }
        }
        string res(s.begin() + lps.first, s.begin() + lps.second);
        return res;
    }
};
