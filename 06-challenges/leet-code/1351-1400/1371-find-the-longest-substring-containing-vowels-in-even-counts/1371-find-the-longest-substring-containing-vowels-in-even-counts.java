// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/

// Solution: Bitmask prefix — O(n) time, O(32) space
class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> vowels = new HashMap<>();
        vowels.put('a',0); vowels.put('e',1); vowels.put('i',2); vowels.put('o',3); vowels.put('u',4);
        int[] first = new int[32];
        Arrays.fill(first, -2);
        first[0] = -1;
        int mask = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer bit = vowels.get(s.charAt(i));
            if (bit != null) mask ^= (1 << bit);
            if (first[mask] == -2) first[mask] = i;
            else ans = Math.max(ans, i - first[mask]);
        }
        return ans;
    }
}
