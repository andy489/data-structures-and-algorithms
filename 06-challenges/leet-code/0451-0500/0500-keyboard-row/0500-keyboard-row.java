// https://leetcode.com/problems/keyboard-row/

// Solution: Row Membership Check — O(n · w) time, O(1) space
class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int[] charToRow = new int[26];
        for (int r = 0; r < rows.length; r++) {
            for (char c : rows[r].toCharArray()) {
                charToRow[c - 'a'] = r;
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            String lower = word.toLowerCase();
            int row = charToRow[lower.charAt(0) - 'a'];
            boolean valid = true;
            for (int i = 1; i < lower.length(); i++) {
                if (charToRow[lower.charAt(i) - 'a'] != row) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
}
