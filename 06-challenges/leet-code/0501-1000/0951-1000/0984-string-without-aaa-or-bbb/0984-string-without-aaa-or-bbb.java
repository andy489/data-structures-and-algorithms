// https://leetcode.com/problems/string-without-aaa-or-bbb/

// Solution: Greedy — O(a+b) time, O(a+b) space
class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while (a > 0 || b > 0) {
            if (a > b) {
                sb.append('a');
                a--;
                if (a > b) { sb.append('a'); a--; }
            } else {
                sb.append('b');
                b--;
                if (b > a) { sb.append('b'); b--; }
            }
        }
        return sb.toString();
    }
}
