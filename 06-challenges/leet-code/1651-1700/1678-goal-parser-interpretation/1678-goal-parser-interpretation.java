// https://leetcode.com/problems/goal-parser-interpretation/

// Solution: String Replace — O(n) time, O(n) space
class Solution {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
