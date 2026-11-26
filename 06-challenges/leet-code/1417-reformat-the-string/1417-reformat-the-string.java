// https://leetcode.com/problems/reformat-the-string/

// Solution: Separate and Interleave — O(n) time, O(n) space
class Solution {
    public String reformat(String s) {
        List<Character> digits = new ArrayList<>(), letters = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) digits.add(c);
            else letters.add(c);
        }
        if (Math.abs(digits.size() - letters.size()) > 1) return "";
        if (letters.size() > digits.size()) { List<Character> tmp = letters; letters = digits; digits = tmp; }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.size(); i++) {
            sb.append(digits.get(i));
            if (i < letters.size()) sb.append(letters.get(i));
        }
        return sb.toString();
    }
}
