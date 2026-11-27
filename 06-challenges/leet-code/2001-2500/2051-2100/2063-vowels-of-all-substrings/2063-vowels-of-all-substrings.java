// https://leetcode.com/problems/vowels-of-all-substrings/

// Solution: Contribution Count — O(n) time, O(1) space
class Solution {
    public long countVowels(String word) {
        long res = 0, n = word.length();
        String vowels = "aeiou";
        for (int i = 0; i < n; i++) {
            if (vowels.indexOf(word.charAt(i)) != -1) { res += (long)(i + 1) * (n - i); }
        }
        return res;
    }
}
