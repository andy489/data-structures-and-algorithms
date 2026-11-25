// https://leetcode.com/problems/shortest-completing-word/

// Solution: Frequency Count — O(n·L) time, O(1) space
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] need = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                need[Character.toLowerCase(c) - 'a']++;
            }
        }
        String result = null;
        for (String word : words) {
            int[] have = new int[26];
            for (char c : word.toCharArray()) {
                have[c - 'a']++;
            }
            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (have[i] < need[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid && (result == null || word.length() < result.length())) {
                result = word;
            }
        }
        return result;
    }
}
