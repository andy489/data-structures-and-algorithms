// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/

// Solution: Right-to-Left Carry Simulation — O(n) time, O(1) space
class Solution {
    public int numSteps(String s) {
        int steps = 0, carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;
            if (bit == 1) { steps += 2; carry = 1; }
            else { steps++; }
        }
        return steps + carry;
    }
}
