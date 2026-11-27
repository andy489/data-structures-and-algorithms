// https://leetcode.com/problems/count-vowel-strings-in-ranges/

// Solution: Prefix Sum — O(n + q) time, O(n) space
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int n = words.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int val = (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) ? 1 : 0;
            prefix[i + 1] = prefix[i] + val;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }
        return ans;
    }
}
