// https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/

class Solution {
    private static final String VOWELS = "aeiou";

    private long atLeast(String word, int minK) {
        int n = word.length();
        int[] vowelCount = new int[26];
        int vowelDistinct = 0;
        int consonants = 0;
        long result = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            char c = word.charAt(r);
            if (VOWELS.indexOf(c) >= 0) {
                if (vowelCount[c - 'a'] == 0) {
                    vowelDistinct++;
                }
                vowelCount[c - 'a']++;
            } else {
                consonants++;
            }
            while (vowelDistinct == 5 && consonants >= minK) {
                result += n - r;
                char lc = word.charAt(l);
                if (VOWELS.indexOf(lc) >= 0) {
                    vowelCount[lc - 'a']--;
                    if (vowelCount[lc - 'a'] == 0) {
                        vowelDistinct--;
                    }
                } else {
                    consonants--;
                }
                l++;
            }
        }
        return result;
    }

    public int countOfSubstrings(String word, int k) {
        return (int) (atLeast(word, k) - atLeast(word, k + 1));
    }
}
