// https://leetcode.com/problems/find-all-anagrams-in-a-string/

// Solution: Sliding Window with Frequency Array — O(n) time, O(1) space
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] pCount = new int[26];
        int[] windowCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        int windowSize = p.length();
        for (int i = 0; i < windowSize; i++) {
            windowCount[s.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (pCount[i] == windowCount[i]) {
                matches++;
            }
        }
        for (int right = windowSize; right < s.length(); right++) {
            if (matches == 26) {
                result.add(right - windowSize);
            }
            int addIdx = s.charAt(right) - 'a';
            if (windowCount[addIdx] == pCount[addIdx]) {
                matches--;
            }
            windowCount[addIdx]++;
            if (windowCount[addIdx] == pCount[addIdx]) {
                matches++;
            }
            int removeIdx = s.charAt(right - windowSize) - 'a';
            if (windowCount[removeIdx] == pCount[removeIdx]) {
                matches--;
            }
            windowCount[removeIdx]--;
            if (windowCount[removeIdx] == pCount[removeIdx]) {
                matches++;
            }
        }
        if (matches == 26) {
            result.add(s.length() - windowSize);
        }
        return result;
    }
}
