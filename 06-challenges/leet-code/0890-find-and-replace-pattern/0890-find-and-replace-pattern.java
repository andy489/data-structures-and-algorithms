// https://leetcode.com/problems/find-and-replace-pattern/

// Solution: Bijection Check — O(n*m) time, O(m) space
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean matches(String word, String pattern) {
        Map<Character, Character> wp = new HashMap<>(), pw = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i), p = pattern.charAt(i);
            if (wp.containsKey(w) && wp.get(w) != p) { return false; }
            if (pw.containsKey(p) && pw.get(p) != w) { return false; }
            wp.put(w, p); pw.put(p, w);
        }
        return true;
    }
}
