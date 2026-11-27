// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/
class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int result = -1;
        for (int len = 1; len <= n; len++) {
            for (char c = 'a'; c <= 'z'; c++) {
                int count = 0;
                for (int i = 0; i <= n - len; i++) {
                    boolean valid = true;
                    for (int j = i; j < i + len; j++) {
                        if (s.charAt(j) != c) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        count++;
                    }
                }
                if (count >= 3) {
                    result = len;
                }
            }
        }
        return result;
    }
}
