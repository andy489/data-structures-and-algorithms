// https://leetcode.com/problems/k-th-symbol-in-grammar/

// Solution: Recursive Parent Lookup — O(n) time, O(n) space
class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int parent = kthGrammar(n - 1, (k + 1) / 2);
        if (k % 2 == 1) {
            return parent;
        } else {
            return 1 - parent;
        }
    }
}
