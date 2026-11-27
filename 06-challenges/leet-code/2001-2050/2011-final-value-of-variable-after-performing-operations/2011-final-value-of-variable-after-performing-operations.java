// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

// Solution: Simulation — O(n) time, O(1) space
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations) {
            if (op.contains("+")) { x++; } else { x--; }
        }
        return x;
    }
}
