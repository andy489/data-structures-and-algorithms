// https://leetcode.com/problems/letter-tile-possibilities/

// Solution: Backtracking with Frequency Count — O(n! / repetitions) time, O(26) space
class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        return dfs(freq);
    }

    private int dfs(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq[i]--;
                count += 1 + dfs(freq);
                freq[i]++;
            }
        }
        return count;
    }
}
