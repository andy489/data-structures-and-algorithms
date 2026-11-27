// https://leetcode.com/problems/repeated-string-match/

// Solution: Repeat Until Length ≥ b + Check — O((n+m)·m/n) time, O(n+m) space
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = (int) Math.ceil((double) b.length() / a.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(a);
        }
        if (sb.toString().contains(b)) {
            return count;
        }
        sb.append(a);
        if (sb.toString().contains(b)) {
            return count + 1;
        }
        return -1;
    }
}
