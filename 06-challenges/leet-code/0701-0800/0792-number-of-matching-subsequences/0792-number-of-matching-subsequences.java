// https://leetcode.com/problems/number-of-matching-subsequences/

// Solution: Waiting Buckets — O(|s| + sum of word lengths) time, O(total chars) space
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<int[]>[] buckets = new List[26];
        for (int i = 0; i < 26; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < words.length; i++) {
            buckets[words[i].charAt(0) - 'a'].add(new int[]{i, 0});
        }
        int count = 0;
        for (char c : s.toCharArray()) {
            List<int[]> waiting = buckets[c - 'a'];
            buckets[c - 'a'] = new ArrayList<>();
            for (int[] entry : waiting) {
                int wi = entry[0], pos = entry[1] + 1;
                if (pos == words[wi].length()) {
                    count++;
                } else {
                    buckets[words[wi].charAt(pos) - 'a'].add(new int[]{wi, pos});
                }
            }
        }
        return count;
    }
}
