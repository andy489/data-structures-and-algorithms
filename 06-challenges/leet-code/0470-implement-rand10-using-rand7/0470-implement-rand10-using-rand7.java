// https://leetcode.com/problems/implement-rand10-using-rand7/

// Solution: Rejection Sampling — O(1) expected time, O(1) space
class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int row = rand7() - 1;
            int col = rand7() - 1;
            int idx = row * 7 + col;
            if (idx < 40) {
                return idx % 10 + 1;
            }
        }
    }
}
