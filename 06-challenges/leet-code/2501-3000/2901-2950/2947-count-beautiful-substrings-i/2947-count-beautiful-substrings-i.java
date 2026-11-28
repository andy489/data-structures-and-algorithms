// https://leetcode.com/problems/count-beautiful-substrings-i/

// Solution: Brute Force — O(n^2) time, O(1) extra space
class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int count = 0;
        String vowelSet = "aeiou";
        for (int i = 0; i < n; i++) {
            int vowels = 0;
            for (int j = i; j < n; j++) {
                if (vowelSet.indexOf(s.charAt(j)) >= 0) {
                    vowels++;
                }
                int len = j - i + 1;
                int consonants = len - vowels;
                if (vowels == consonants && (vowels * consonants) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
