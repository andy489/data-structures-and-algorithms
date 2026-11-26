// https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/

// Solution: Greedy + BIT (Binary Indexed Tree) — O(n * 10 * log n) time, O(n) space
class Solution {
    private int[] bit;
    private int n;

    private void update(int i) {
        for (i++; i <= n; i += i & (-i)) {
            bit[i]++;
        }
    }

    private int query(int i) {
        int s = 0;
        for (i++; i > 0; i -= i & (-i)) {
            s += bit[i];
        }
        return s;
    }

    public String minInteger(String num, int k) {
        n = num.length();
        bit = new int[n + 1];
        Queue<Integer>[] pos = new Queue[10];
        for (int d = 0; d < 10; d++) {
            pos[d] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            pos[num.charAt(i) - '0'].add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int d = 0; d <= 9; d++) {
                if (pos[d].isEmpty()) {
                    continue;
                }
                int j = pos[d].peek();
                int cost = j - query(j - 1);
                // query(j-1) = number of already-placed elements with original index < j
                if (cost <= k) {
                    k -= cost;
                    pos[d].poll();
                    update(j);
                    sb.append((char) ('0' + d));
                    break;
                }
            }
        }
        return sb.toString();
    }
}
