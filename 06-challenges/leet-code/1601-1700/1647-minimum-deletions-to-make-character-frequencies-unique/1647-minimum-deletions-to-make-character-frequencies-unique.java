// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

// Solution: Greedy with Seen-Frequencies Set — O(n) time, O(1) space
class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        Set<Integer> seen = new HashSet<>();
        int deletions = 0;
        for (int i = 25; i >= 0; i--) {
            int f = freq[i];
            while (f > 0 && seen.contains(f)) {
                f--;
                deletions++;
            }
            seen.add(f);
        }
        return deletions;
    }
}
