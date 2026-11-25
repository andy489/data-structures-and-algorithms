// https://leetcode.com/problems/numbers-with-same-consecutive-differences/

// Solution: BFS — O(2^n) time, O(2^n) space
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> cur = new ArrayList<>();
        for (int d = 1; d <= 9; d++) { cur.add(d); }
        for (int len = 1; len < n; len++) {
            List<Integer> next = new ArrayList<>();
            for (int num : cur) {
                int last = num % 10;
                if (last + k <= 9) { next.add(num * 10 + last + k); }
                if (k != 0 && last - k >= 0) { next.add(num * 10 + last - k); }
            }
            cur = next;
        }
        return cur.stream().mapToInt(Integer::intValue).toArray();
    }
}
