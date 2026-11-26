// https://leetcode.com/problems/add-to-array-form-of-integer/

// Solution: Add k as carry from right — O(max(n, log k)) time, O(n) space
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = num.length - 1;
        while (i >= 0 || k > 0) {
            if (i >= 0) { k += num[i--]; }
            res.addFirst(k % 10);
            k /= 10;
        }
        return res;
    }
}
