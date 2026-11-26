// https://leetcode.com/problems/replace-words/

// Solution: Hash Set + Prefix Search — O(n·L) time, O(d) space
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> rootSet = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String replacement = word;
            for (int len = 1; len <= word.length(); len++) {
                String prefix = word.substring(0, len);
                if (rootSet.contains(prefix)) {
                    replacement = prefix;
                    break;
                }
            }
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(replacement);
        }
        return sb.toString();
    }
}
