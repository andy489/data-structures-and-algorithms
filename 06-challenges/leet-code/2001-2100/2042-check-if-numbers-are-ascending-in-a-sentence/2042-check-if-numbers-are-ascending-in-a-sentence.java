// https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/

// Solution: Tokenize and Compare — O(n) time, O(1) space
class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = 0;
        for (String token : s.split(" ")) {
            if (Character.isDigit(token.charAt(0))) {
                int num = Integer.parseInt(token);
                if (num <= prev) { return false; }
                prev = num;
            }
        }
        return true;
    }
}
