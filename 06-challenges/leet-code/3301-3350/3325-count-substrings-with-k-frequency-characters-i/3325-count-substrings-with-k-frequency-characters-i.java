// https://leetcode.com/problems/count-substrings-with-k-frequency-characters-i/

class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int result = 0;
        int[] freq = new int[26];
        int left = 0;
        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;
            while (freq[s.charAt(right) - 'a'] >= k) {
                result += n - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return result;
    }
}
