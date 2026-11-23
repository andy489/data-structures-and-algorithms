class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        int[] window = new int[26];
        int k = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;
            if (i >= k) {
                window[s2.charAt(i - k) - 'a']--;
            }
            if (Arrays.equals(freq, window)) {
                return true;
            }
        }
        return false;
    }
}
