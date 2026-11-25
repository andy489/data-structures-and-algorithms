// https://leetcode.com/problems/short-encoding-of-words/

// Solution: Suffix Set — O(Σ|w|²) time, O(Σ|w|) space
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        for (String w : words) {
            set.add(w);
        }
        for (String w : words) {
            for (int i = 1; i < w.length(); i++) {
                set.remove(w.substring(i));
            }
        }
        int len = 0;
        for (String w : set) {
            len += w.length() + 1;
        }
        return len;
    }
}
