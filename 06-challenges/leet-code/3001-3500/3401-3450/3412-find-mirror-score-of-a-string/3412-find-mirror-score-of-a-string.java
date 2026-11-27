// https://leetcode.com/problems/find-mirror-score-of-a-string/
class Solution {
    public long calculateScore(String s) {
        long score = 0;
        Stack<Integer>[] stacks = new Stack[26];
        for (int i = 0; i < 26; i++) {
            stacks[i] = new Stack<>();
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            int mirror = 25 - c;
            if (!stacks[mirror].isEmpty()) {
                score += i - stacks[mirror].pop();
            } else {
                stacks[c].push(i);
            }
        }
        return score;
    }
}
