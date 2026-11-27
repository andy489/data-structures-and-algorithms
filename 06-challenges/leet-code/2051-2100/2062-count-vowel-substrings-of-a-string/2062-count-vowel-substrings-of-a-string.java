// https://leetcode.com/problems/count-vowel-substrings-of-a-string/

// Solution: Brute Force — O(n^3) time, O(1) space
class Solution {
    public int countVowelSubstrings(String word) {
        String vowels = "aeiou";
        int count = 0, n = word.length();
        for (int i = 0; i < n; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (vowels.indexOf(c) == -1) { break; }
                seen.add(c);
                if (seen.size() == 5) { count++; }
            }
        }
        return count;
    }
}
