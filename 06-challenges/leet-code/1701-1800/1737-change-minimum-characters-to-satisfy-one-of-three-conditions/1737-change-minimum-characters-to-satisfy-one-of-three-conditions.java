// https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/

// Solution: Frequency + Prefix Sums — O(n+m) time, O(26) space
class Solution {
    public int minCharacters(String a, String b) {
        int[] fa = new int[26], fb = new int[26];
        for (char c : a.toCharArray()) { fa[c - 'a']++; }
        for (char c : b.toCharArray()) { fb[c - 'a']++; }

        int na = a.length(), nb = b.length();
        int ans = na + nb; // worst case

        // Condition 3: same single char
        for (int i = 0; i < 26; i++) {
            ans = Math.min(ans, (na - fa[i]) + (nb - fb[i]));
        }

        // Build prefix sums
        int[] prefA = new int[26], prefB = new int[26];
        prefA[0] = fa[0]; prefB[0] = fb[0];
        for (int i = 1; i < 26; i++) {
            prefA[i] = prefA[i - 1] + fa[i];
            prefB[i] = prefB[i - 1] + fb[i];
        }

        // Conditions 1 & 2: cut at index c means a uses chars 0..c-1, b uses c..25
        for (int c = 1; c < 26; c++) {
            // Condition 1: all a < c, all b >= c
            ans = Math.min(ans, (na - prefA[c - 1]) + prefB[c - 1]);
            // Condition 2: all b < c, all a >= c
            ans = Math.min(ans, (nb - prefB[c - 1]) + prefA[c - 1]);
        }
        return ans;
    }
}
