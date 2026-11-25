// https://leetcode.com/problems/word-subsets/

// Solution: Max Frequency Merge — O((A+B)*26) time, O(26) space
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] need = new int[26];
        for (String b : words2) {
            int[] freq = new int[26];
            for (char c : b.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                need[i] = Math.max(need[i], freq[i]);
            }
        }
        List<String> result = new ArrayList<>();
        outer:
        for (String a : words1) {
            int[] freq = new int[26];
            for (char c : a.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (freq[i] < need[i]) {
                    continue outer;
                }
            }
            result.add(a);
        }
        return result;
    }
}
