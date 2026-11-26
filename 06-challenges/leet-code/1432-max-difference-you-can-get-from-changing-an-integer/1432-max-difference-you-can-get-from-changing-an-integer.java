// https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/

// Solution: Greedy Digit Replacement — O(d) time, O(d) space
class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        String maxS = s, minS = s;
        for (char c : s.toCharArray()) {
            if (c != '9') { maxS = s.replace(c, '9'); break; }
        }
        if (s.charAt(0) != '1') {
            minS = s.replace(s.charAt(0), '1');
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                    minS = s.replace(s.charAt(i), '0');
                    break;
                }
            }
        }
        return Integer.parseInt(maxS) - Integer.parseInt(minS);
    }
}
