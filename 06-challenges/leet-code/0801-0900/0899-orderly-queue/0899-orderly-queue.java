// https://leetcode.com/problems/orderly-queue/

// Solution: Math Insight — O(n^2) time, O(n) space
class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String best = s;
            for (int i = 1; i < s.length(); i++) {
                String rot = s.substring(i) + s.substring(0, i);
                if (rot.compareTo(best) < 0) { best = rot; }
            }
            return best;
        }
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
