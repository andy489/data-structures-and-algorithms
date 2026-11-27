// https://leetcode.com/problems/longest-well-performing-interval/

// Solution: Prefix Score + Hash Map — O(n) time, O(n) space
class Solution {
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> seen = new HashMap<>();
        int score = 0;
        int ans = 0;
        for (int i = 0; i < hours.length; i++) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                ans = i + 1;
            } else {
                if (seen.containsKey(score - 1)) {
                    ans = Math.max(ans, i - seen.get(score - 1));
                }
            }
            seen.putIfAbsent(score, i);
        }
        return ans;
    }
}
