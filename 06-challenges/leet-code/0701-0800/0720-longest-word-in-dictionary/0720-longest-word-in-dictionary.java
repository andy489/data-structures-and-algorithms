// https://leetcode.com/problems/longest-word-in-dictionary/

// Solution: HashSet + Sort — O(n·L log n) time, O(n·L) space
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> seen = new HashSet<>();
        seen.add("");
        String ans = "";
        for (String word : words) {
            if (seen.contains(word.substring(0, word.length() - 1))) {
                seen.add(word);
                if (word.length() > ans.length()) {
                    ans = word;
                }
            }
        }
        return ans;
    }
}
