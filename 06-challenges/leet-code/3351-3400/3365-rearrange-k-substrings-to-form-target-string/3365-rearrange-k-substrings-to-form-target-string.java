// https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string/

// Solution: Frequency Map of Chunks — O(n) time, O(n) space
class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int len = s.length() / k;
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String chunk = s.substring(i * len, (i + 1) * len);
            freq.merge(chunk, 1, Integer::sum);
        }
        for (int i = 0; i < k; i++) {
            String chunk = t.substring(i * len, (i + 1) * len);
            int cnt = freq.getOrDefault(chunk, 0) - 1;
            if (cnt < 0) {
                return false;
            }
            if (cnt == 0) {
                freq.remove(chunk);
            } else {
                freq.put(chunk, cnt);
            }
        }
        return true;
    }
}
