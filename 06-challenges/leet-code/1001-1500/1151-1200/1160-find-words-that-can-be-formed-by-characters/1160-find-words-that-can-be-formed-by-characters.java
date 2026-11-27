// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

// Solution: Frequency Count — O((n + m) × 26) time, O(26) space
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] avail = new int[26];
        for (char c : chars.toCharArray()) {
            avail[c - 'a']++;
        }
        int result = 0;
        for (String word : words) {
            int[] need = new int[26];
            for (char c : word.toCharArray()) {
                need[c - 'a']++;
            }
            boolean good = true;
            for (int i = 0; i < 26; i++) {
                if (need[i] > avail[i]) {
                    good = false;
                    break;
                }
            }
            if (good) {
                result += word.length();
            }
        }
        return result;
    }
}
