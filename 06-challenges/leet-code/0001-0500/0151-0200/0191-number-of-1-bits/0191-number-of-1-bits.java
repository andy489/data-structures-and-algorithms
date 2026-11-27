// https://leetcode.com/problems/number-of-1-bits/

// Brian Kernighan — O(k) time, O(1) space
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
