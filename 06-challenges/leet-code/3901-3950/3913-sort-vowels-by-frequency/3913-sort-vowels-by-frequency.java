// https://leetcode.com/problems/sort-vowels-by-frequency/
class Solution {
    public String sortVowelsByFrequency(String s) {
        String vowels = "aeiou";
        int[] freq = new int[26];
        int[] firstOccurrence = new int[26];
        java.util.Arrays.fill(firstOccurrence, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.indexOf(c) != -1) {
                freq[c - 'a']++;
                if (firstOccurrence[c - 'a'] == -1) {
                    firstOccurrence[c - 'a'] = i;
                }
            }
        }
        // Collect vowel positions
        java.util.List<Integer> vowelPositions = new java.util.ArrayList<>();
        java.util.List<Character> vowelChars = new java.util.ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                vowelPositions.add(i);
                vowelChars.add(s.charAt(i));
            }
        }
        // Sort vowel characters by freq desc, then by first occurrence asc
        vowelChars.sort((a, b) -> {
            int fa = freq[a - 'a'], fb = freq[b - 'a'];
            if (fa != fb) {
                return fb - fa;
            }
            return firstOccurrence[a - 'a'] - firstOccurrence[b - 'a'];
        });
        char[] res = s.toCharArray();
        for (int i = 0; i < vowelPositions.size(); i++) {
            res[vowelPositions.get(i)] = vowelChars.get(i);
        }
        return new String(res);
    }
}
