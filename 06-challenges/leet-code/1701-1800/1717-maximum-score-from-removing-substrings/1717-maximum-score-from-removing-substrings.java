// https://leetcode.com/problems/maximum-score-from-removing-substrings/

// Solution: Greedy Stack — O(n) time, O(n) space
class Solution {
    private int[] removePair(char[] chars, char first, char second, int points) {
        char[] stack = new char[chars.length];
        int top = 0;
        int score = 0;
        for (char c : chars) {
            if (top > 0 && stack[top - 1] == first && c == second) {
                top--;
                score += points;
            } else {
                stack[top++] = c;
            }
        }
        return new int[]{score, top};
    }

    public int maximumGain(String s, int x, int y) {
        char[] chars = s.toCharArray();
        char first1 = x >= y ? 'a' : 'b';
        char second1 = x >= y ? 'b' : 'a';
        int pts1 = x >= y ? x : y;
        char first2 = x >= y ? 'b' : 'a';
        char second2 = x >= y ? 'a' : 'b';
        int pts2 = x >= y ? y : x;

        char[] stack1 = new char[chars.length];
        int top1 = 0;
        int score1 = 0;
        for (char c : chars) {
            if (top1 > 0 && stack1[top1 - 1] == first1 && c == second1) {
                top1--;
                score1 += pts1;
            } else {
                stack1[top1++] = c;
            }
        }

        char[] stack2 = new char[top1];
        int top2 = 0;
        int score2 = 0;
        for (int i = 0; i < top1; i++) {
            char c = stack1[i];
            if (top2 > 0 && stack2[top2 - 1] == first2 && c == second2) {
                top2--;
                score2 += pts2;
            } else {
                stack2[top2++] = c;
            }
        }

        return score1 + score2;
    }
}
