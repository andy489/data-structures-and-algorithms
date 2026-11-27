// https://leetcode.com/problems/minimum-operations-to-make-character-frequencies-equal/

// Solution: DP over alphabet with carry — O(26 * max_freq) time, O(26) space
class Solution {
    public int makeStringGood(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int ans = s.length(); // worst case: delete everything and re-insert

        for (int k = 0; k <= maxFreq; k++) {
            int cost = 0, carry = 0;
            for (int i = 0; i < 26; i++) {
                int f = freq[i] + carry;
                if (k == 0) {
                    // delete all
                    cost += freq[i];
                    carry = 0;
                } else if (f > k) {
                    // excess: can carry to next char (free) or delete (cost 1 each)
                    // carry costs 0, deletion costs f - k
                    // We always carry to avoid deletion cost
                    carry = f - k;
                    // no additional cost for carrying
                } else if (f < k) {
                    // deficit: insert (cost k - f) or delete all freq[i] (cost freq[i])
                    int insertCost = k - f;
                    int deleteCost = freq[i]; // delete freq[i] and start fresh (carry was consumed)
                    cost += Math.min(insertCost, deleteCost);
                    carry = 0;
                } else {
                    // f == k exactly
                    carry = 0;
                }
            }
            ans = Math.min(ans, cost);
        }
        return ans;
    }
}
